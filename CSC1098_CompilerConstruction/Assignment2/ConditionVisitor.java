import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.tree.ParseTree;

public class ConditionVisitor extends calBaseVisitor<Object> {
    private Map<String, Object> memory;
    private SymbolTable symbolTable;
    private List<String> tacInstructions;

    public ConditionVisitor(Map<String, Object> memory, SymbolTable symbolTable, List<String> tacInstructions) {	
        this.memory = memory;
        this.symbolTable = symbolTable;
        this.tacInstructions = tacInstructions;
    }

    @Override
    public Object visitBrackets(calParser.BracketsContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitNegCondition(calParser.NegConditionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitCompareOp(calParser.CompareOpContext ctx) {
        // Get the left and right operands
        calParser.ExpressionContext leftExpression = ctx.expression(0);
        calParser.ExpressionContext rightExpression = ctx.expression(1);

        // Check if both operands are of the same type
        String leftType = getType(leftExpression);
        String rightType = getType(rightExpression);

        if (!leftType.equals(rightType)) {
            System.err.println("Error: Both operands of a comparison operator must be of the same type.");
            return null;
        }
        
        // Create an instance of CompOpVisitor
        CompOpVisitor compOpVisitor = new CompOpVisitor(memory, symbolTable);

        // Evaluate the expressions
        // Perform the comparison
        String operator = ctx.getChild(1).getText();
        //System.out.println(leftExpression.getText() + " " + operator + " " + rightExpression.getText());

        Object result = null;
        switch (operator) {
            case "=":
                result = compOpVisitor.visitEqual(ctx);
                break;
            case "!=":
                result = compOpVisitor.visitNotEqual(ctx);
                break;
            case "<":
                result = compOpVisitor.visitLessThan(ctx);
                break;
            case "<=":
                result = compOpVisitor.visitLessOrEqual(ctx);
                break;
            case ">":
                result = compOpVisitor.visitGreaterThan(ctx);
                break;
            case ">=":
                result = compOpVisitor.visitGreatOrEqual(ctx);
                break;
        }
        //System.out.println("Result: " + result);

        return result;
    }

    @Override
    public Object visitOrAndComp(calParser.OrAndCompContext ctx) {
        // Get the left and right conditions
        calParser.ConditionContext leftCondition = ctx.condition(0);
        calParser.ConditionContext rightCondition = ctx.condition(1);

        // Check if both conditions are boolean variables or boolean constants
        if (!isBooleanVariableOrConstant(leftCondition) || !isBooleanVariableOrConstant(rightCondition)) {
            System.err.println("Error: Both operands of a boolean operator must be boolean variables or boolean constants.");
            return null;
        }
        return visitChildren(ctx);
    }

    private boolean isBooleanVariableOrConstant(calParser.ConditionContext ctx) {
        return "bool".equals(getType(ctx));
    }

    public String getType(ParseTree ctx) {
        String id = ctx.getText();
        return symbolTable.lookup(id);
    }
}
