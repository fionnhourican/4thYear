import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.tree.ParseTree;

public class CompOpVisitor extends calBaseVisitor<Object> {
    private Map<String, Object> memory;
    private SymbolTable symbolTable;

    public CompOpVisitor(Map<String, Object> memory, SymbolTable symbolTable) {
        this.memory = memory;
        this.symbolTable = symbolTable;
    }

    public Object visitEqual(calParser.CompareOpContext ctx) {
        // Implement the logic for the '=' operator
        // Get the left and right expressions
        calParser.ExpressionContext leftExpression = ctx.expression(0);
        calParser.ExpressionContext rightExpression = ctx.expression(1);

        return leftExpression.getText() + " == " + rightExpression.getText();
    }

    public Object visitNotEqual(calParser.CompareOpContext ctx) {
        // Implement the logic for the '!=' operator
        // Get the left and right expressions
        calParser.ExpressionContext leftExpression = ctx.expression(0);
        calParser.ExpressionContext rightExpression = ctx.expression(1);

        return leftExpression.getText() + " != " + rightExpression.getText();
    }

    public Object visitLessThan(calParser.CompareOpContext ctx) {
        // Implement the logic for the '<' operator
        // Get the left and right expressions
        calParser.ExpressionContext leftExpression = ctx.expression(0);
        calParser.ExpressionContext rightExpression = ctx.expression(1);

        return leftExpression.getText() + " < " + rightExpression.getText();
    }

    public Object visitLessOrEqual(calParser.CompareOpContext ctx) {
        // Implement the logic for the '<=' operator
        // Get the left and right expressions
        calParser.ExpressionContext leftExpression = ctx.expression(0);
        calParser.ExpressionContext rightExpression = ctx.expression(1);

        return leftExpression.getText() + " <= " + rightExpression.getText();
    }

    public Object visitGreaterThan(calParser.CompareOpContext ctx) {
        // Implement the logic for the '>' operator
        // Get the left and right expressions
        calParser.ExpressionContext leftExpression = ctx.expression(0);
        calParser.ExpressionContext rightExpression = ctx.expression(1);

        return leftExpression.getText() + " > " + rightExpression.getText();
    }

    public Object visitGreatOrEqual(calParser.CompareOpContext ctx) {
        // Implement the logic for the '>=' operator
        // Get the left and right expressions
        calParser.ExpressionContext leftExpression = ctx.expression(0);
        calParser.ExpressionContext rightExpression = ctx.expression(1);

        return leftExpression.getText() + " >= " + rightExpression.getText();
    }
}
