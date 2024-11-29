import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.List;
import java.util.Map;

public class StatementVisitor extends calBaseVisitor<Object> {
    private Map<String, Object> memory;
    private SymbolTable symbolTable;
    private ExpressionVisitor expressionVisitor;
    private ConditionVisitor conditionVisitor;
    private List<String> tacInstructions;
    private int loopCounter = 1;

    public StatementVisitor(Map<String, Object> memory, SymbolTable symbolTable, List<String> tacInstructions) {
        this.memory = memory;
        this.symbolTable = symbolTable;
        this.tacInstructions = tacInstructions;
        this.expressionVisitor = new ExpressionVisitor(memory, symbolTable, tacInstructions);
        this.conditionVisitor = new ConditionVisitor(memory, symbolTable, tacInstructions);
    }

    private String generateLabel() {
        return "L" + loopCounter++;
    }

    @Override
    public Object visitAssignmentStatement(calParser.AssignmentStatementContext ctx) {
        String id = ctx.ID().getText();
        // Check if variable is declared
        if (symbolTable.lookup(id.replace("-", "")) == null) {
            System.err.println("Error: Variable " + id + " not declared.");
            return null;
        }

        if (symbolTable.getType(id.replace("-", "")).equals("const")) {
            System.err.println("Semantic error: Constant " + id + " cannot be reassigned.");
        }

        // Use ExpressionVisitor to evaluate the expression
        String expectedType = symbolTable.lookup(id.replace("-", ""));
        expressionVisitor.setExpectedType(expectedType);

        Object value = expressionVisitor.visit(ctx.expression());
        symbolTable.markVariableWritten(id);
        //System.out.println("value: " + value);
        //System.out.println("id: " + memory.get(id));
        // mark variable as written

        // Store the value in memory
        if (ctx.getChild(2).getChild(0) instanceof calParser.NumberContext && expectedType.equals("int")) {
            memory.put(id, Integer.parseInt(ctx.getChild(2).getChild(0).getText()));
            tacInstructions.add(id + " = " + memory.get(id).toString());
        } else if (ctx.getChild(2).getChild(0) instanceof calParser.TrueContext && expectedType.equals("bool")) {
            memory.put(id, true);
            tacInstructions.add(id + " = " + memory.get(id).toString());
        } else if (ctx.getChild(2).getChild(0) instanceof calParser.FalseContext && expectedType.equals("bool")) {
            memory.put(id, false);
            tacInstructions.add(id + " = " + memory.get(id).toString());
        } else if (ctx.getChild(2) instanceof calParser.ExpressionContext) {
            //System.out.println(id + " = " + ctx.getChild(2).getText());
            tacInstructions.add(id + " = " + value);
            // memory.put(id, memory.get(value));
        } else if (ctx.getChild(2) instanceof calParser.FunctionCallContext) {
            //System.out.println(id + " = " + ctx.getChild(2).getText());
            tacInstructions.add(id + " = " + value);
            // memory.put(id, memory.get(value));
        } else {
            System.err.println("Semantic Error here: Type mismatch for variable " + id.replace("-", "") + ". Expected " + expectedType + ".");
        }

        // Mark all variables in the expression as read
        markExpressionAsRead(ctx.expression());
        return visitChildren(ctx);
    }

    private void markExpressionAsRead(calParser.ExpressionContext ctx) {
        if (ctx instanceof calParser.SingleExpressionContext) {
            calParser.SingleExpressionContext singleExpr = (calParser.SingleExpressionContext) ctx;
            if (singleExpr.getChild(0) instanceof calParser.FragIDContext) {
                calParser.FragIDContext fragID = (calParser.FragIDContext) singleExpr.getChild(0);
                symbolTable.markVariableRead(fragID.ID().getText());
            }
        }
    }

    @Override
    public Object visitFunctionCall(calParser.FunctionCallContext ctx) {
        String id = ctx.ID().getText();
        if (symbolTable.lookup(id) == null) {
            System.err.println("Error: Function " + id + " not declared.");
            return null;
        }
        symbolTable.markVariableRead(id);
        return visitChildren(ctx);
    }

    @Override
    public Object visitBeginBlock(calParser.BeginBlockContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitIfElseBlock(calParser.IfElseBlockContext ctx) {
        // Evaluate the condition using ConditionVisitor
        String condition = ctx.condition().getText()
                .replace("(", "")
                .replace(")", "")
                .replace("=", "==")
                .replace(">==", ">=")
                .replace("<==", "<=")
                .replace(">==", ">=")
                .replace("!==", "!=");
        //System.out.println("condition: " + condition);

        // Generate labels for the if and else blocks
        String ifLabel = generateLabel();
        String elseLabel = generateLabel();
        String endLabel = generateLabel();

        // Add TAC instructions for the if condition
        tacInstructions.add("if " + condition + " goto " + ifLabel);
        tacInstructions.add("goto " + elseLabel);
        //System.out.println("condition if: " + condition);

        // Add TAC instructions for the if block
        tacInstructions.add(ifLabel + ":");
        visit(ctx.statement_block(0));
        tacInstructions.add("goto " + endLabel);

        // Add TAC instructions for the else block (if it exists)
        tacInstructions.add(elseLabel + ":");
        if (ctx.statement_block().size() > 1) {
            visit(ctx.statement_block(1));
        }
        tacInstructions.add(endLabel + ":");
        return visitChildren(ctx);
    }

    @Override
    public Object visitWhileStatement(calParser.WhileStatementContext ctx) {
        // Generate labels for the start of the loop, the body of the loop, and the end of the loop
        String startLabel = generateLabel();
        String bodyLabel = generateLabel();
        String endLabel = generateLabel();

        // Add TAC instructions for the start of the loop
        tacInstructions.add(startLabel + ":");

        // Evaluate the condition using ConditionVisitor
        String conditionText = ctx.condition().getText()
            .replace("(", "")
            .replace(")", "")
            .replace("=", "==")
            .replace(">==", ">=")
            .replace("<==", "<=")
            .replace("!==", "!=");
        //System.out.println("condition while: " + conditionText);

        // Add TAC instructions for the while condition
        tacInstructions.add("if " + conditionText + " goto " + bodyLabel);
        tacInstructions.add("goto " + endLabel);

        // Add TAC instructions for the body of the loop
        tacInstructions.add(bodyLabel + ":");
        /*
        System.out.println("about to visit statement block");
        if (ctx.statement_block() != null) {
            visit(ctx.statement_block());
        }
            */
        //System.out.println("visited statement block");
        tacInstructions.add("goto " + startLabel);

        // Add TAC instructions for the end of the loop
        tacInstructions.add(endLabel + ":");

        //System.out.println("end of while statement");
        return null;
    }

    @Override
    public Object visitSkipStatement(calParser.SkipStatementContext ctx) {
        return visitChildren(ctx);
    }
}
