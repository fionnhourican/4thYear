import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.tree.ParseTree;


public class FragVisitor extends calBaseVisitor<Object> {
    private Map<String, Object> memory;
    private SymbolTable symbolTable;
    private List<String> tacInstructions;

    public FragVisitor(Map<String, Object> memory, SymbolTable symbolTable, List<String> tacInstructions) {
        this.memory = memory;
        this.symbolTable = symbolTable;
        this.tacInstructions = tacInstructions;
    }

    @Override
    public Object visitFragID(calParser.FragIDContext ctx) {
        String id = ctx.ID().getText();
        if (symbolTable.lookup(id) == null) {
            System.err.println("Error: Variable " + id + " not declared.");
        }
        if (symbolTable.lookup(id) == null) {
            // Check if variable is a decendent of a function declaration
            if (!(symbolTable.IsFunctionParent(ctx))) {
                System.err.println("Error: Variable " + id + " not declared.");
            }
        }
        symbolTable.markVariableRead(id);
        return visitChildren(ctx);
    }

    @Override
    public Object visitNegIdentifier(calParser.NegIdentifierContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitNumber(calParser.NumberContext ctx) {
        return Integer.valueOf(ctx.NUMBER().getText());
    }

    @Override
    public Object visitTrue(calParser.TrueContext ctx) {
        return Boolean.valueOf(true);
    }

    @Override
    public Object visitFalse(calParser.FalseContext ctx) {
        return Boolean.valueOf(false);
    }
}
