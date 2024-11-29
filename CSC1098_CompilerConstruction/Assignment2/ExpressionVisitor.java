import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class ExpressionVisitor extends calBaseVisitor<Object> {
    private Map<String, Object> memory;
    private SymbolTable symbolTable;
    private String expectedType;
    private List<String> tacInstructions;
    private int tempVarCounter;

    public ExpressionVisitor(Map<String, Object> memory, SymbolTable symbolTable, List<String> tacInstructions) {
        this.memory = memory;
        this.symbolTable = symbolTable;
        this.tacInstructions = tacInstructions;
        this.tempVarCounter = 1;
    }

    public void setExpectedType(String expectedType) {
        this.expectedType = expectedType;
    }

    public List<String> getTacInstructions() {
        return tacInstructions;
    }

    private String newTempVar() {
        int tempVarCounter = (this.tempVarCounter++);
        return "t" + String.valueOf(tempVarCounter);
    }

    @Override
    public Object visitExpressionStructure(calParser.ExpressionStructureContext ctx) {
        // Get the left and right operands
        calParser.FragContext leftOperand = ctx.frag(0);
        calParser.FragContext rightOperand = ctx.frag(1);

        String leftValue = getValue(leftOperand);
        String rightValue = getValue(rightOperand);

        String tempVar = newTempVar();
        String op = ctx.binary_arith_op() instanceof calParser.PlusContext ? "+" : "-";

        int leftInt, rightInt;

        try {
            // Try to parse leftValue as an integer constant
            leftInt = Integer.parseInt(leftValue);
        } catch (NumberFormatException e) {
            // If it fails, treat it as an identifier and get its value from memory
            leftInt = Integer.parseInt(memory.get(leftValue).toString());
        }

        try {
            // Try to parse rightValue as an integer constant
            rightInt = Integer.parseInt(rightValue);
        } catch (NumberFormatException e) {
            // If it fails, treat it as an identifier and get its value from memory
            rightInt = Integer.parseInt(memory.get(rightValue).toString());
        }

        int result;
        if (op.equals("+")) {
            result = leftInt + rightInt;
        } else {
            result = leftInt - rightInt;
        }


        // Store the result in a temporary variable
        memory.put(tempVar, result);

        // Add to Tac instructions
        tacInstructions.add(tempVar + " = " + leftValue + " " + op + " " + rightValue);

        // Check if both operands are integer variables or integer constants
        if (!isIntegerVariableOrConstant(leftOperand) || !isIntegerVariableOrConstant(rightOperand)) {
            System.err.println("Error: Both operands of an arithmetic operator must be integer variables or integer constants.");
            return null;
        }
        return tempVar;
    }

    @Override
    public Object visitParenthesizedExpression(calParser.ParenthesizedExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFunctionCallInExpression(calParser.FunctionCallInExpressionContext ctx) {
        String id = ctx.ID().getText();
        int argCount = ctx.arg_list().getChildCount();
        int paramCount = symbolTable.getFunctionParameterCount(id);
        if (symbolTable.lookup(id) == null) {
            System.err.println("Error: Variable " + id + " not declared.");
        }else if (argCount != paramCount) {
            System.err.println("Error: Function " + id + " expects " + paramCount + " arguments but got " + argCount + ".");
        } else {
            symbolTable.markVariableRead(id);
        }
        // Print the parameters
        List<String> parameters = new ArrayList<>();
        for (int i = 0; i < ctx.arg_list().getChildCount(); i++) {
            String tempvar = newTempVar();
            ParseTree arg = ctx.arg_list().getChild(i);
            symbolTable.markVariableRead(arg.getText());
            tacInstructions.add("param " + arg.getText());
            parameters.add(tempvar);
        }
        String tempvar = newTempVar();
        tacInstructions.add(tempvar + " = " + "call " + id + ", " + parameters.size());
        
        return tempvar;
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
    public Object visitSingleExpression(calParser.SingleExpressionContext ctx) {        
        String actualType = getType(ctx.getChild(0));

        if (expectedType != null && !expectedType.equals(actualType)) {

            System.err.println("Error: Type mismatch for variable " + ctx.getText().replace("-", "") + ". Expected " + expectedType + " but found " + actualType + ".");
            return null;
        }

        if (ctx.getChild(0) instanceof calParser.NumberContext) {
            return visit(ctx.getChild(0));
        }
        if (ctx.getChild(0) instanceof calParser.TrueContext) {
            return visit(ctx.getChild(0));
        }
        if (ctx.getChild(0) instanceof calParser.FalseContext) {
            return visit(ctx.getChild(0));
        }
        return visitChildren(ctx);
    }

    public String getType(ParseTree ctx) {
        if (ctx instanceof calParser.NumberContext) {
            return "int";
        }
        else if (ctx instanceof calParser.TrueContext || ctx instanceof calParser.FalseContext) {
            return "bool";
        } else if (ctx instanceof calParser.FragIDContext) {
            return symbolTable.lookup(ctx.getText().replace("-", ""));
        }
        return "unknown";
    }

    private String getValue(calParser.FragContext ctx) {
        if (ctx instanceof calParser.FragIDContext) {
            return ((calParser.FragIDContext) ctx).ID().getText();
        } else if (ctx instanceof calParser.NumberContext) {
            //System.out.println("getValue: " + ((calParser.NumberContext) ctx).NUMBER().getText());
            return ((calParser.NumberContext) ctx).NUMBER().getText();
        }
        return null;
    }

    private boolean isIntegerVariableOrConstant(calParser.FragContext ctx) {
        if (ctx instanceof calParser.FragIDContext) {
            String id = ((calParser.FragIDContext) ctx).ID().getText();
            String type = symbolTable.lookup(id);
            return "int".equals(type);
        } else if (ctx instanceof calParser.NumberContext) {
            return true;
        }
        return false;
    }
}