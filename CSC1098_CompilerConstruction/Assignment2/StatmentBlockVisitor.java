import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.tree.ParseTree;

public class StatmentBlockVisitor extends calBaseVisitor<Object> {
    private Map<String, Object> memory;
    private SymbolTable symbolTable;
    private List<String> tacInstructions;

    public StatmentBlockVisitor(Map<String, Object> memory, SymbolTable symbolTable, List<String> tacInstructions) {
        this.memory = memory;
        this.symbolTable = symbolTable;
        this.tacInstructions = tacInstructions;
    }

    @Override
    public Object visitStatmentBlock(calParser.StatmentBlockContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitEmptyStatement(calParser.EmptyStatementContext ctx) {
        return visitChildren(ctx);
    }  
}
