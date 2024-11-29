import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.tree.ParseTree;

public class BinaryOpVisitor extends calBaseVisitor<Object> {
    private Map<String, Object> memory;
    private SymbolTable symbolTable;
    private List<String> tacInstructions;

    public BinaryOpVisitor(Map<String, Object> memory, SymbolTable symbolTable, List<String> tacInstructions) {
        this.memory = memory;
        this.symbolTable = symbolTable;
        this.tacInstructions = tacInstructions;
    }

    @Override
    public Object visitPlus(calParser.PlusContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitMinus(calParser.MinusContext ctx) {
        return visitChildren(ctx);
    }
}