import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;
import java.util.Map;

public class ArgListVisitor extends calBaseVisitor<Object> {
    private Map<String, Object> memory;
    private SymbolTable symbolTable;
    private List<String> tacInstructions;

    public ArgListVisitor(Map<String, Object> memory, SymbolTable symbolTable, List<String> tacInstructions) {
        this.memory = memory;
        this.symbolTable = symbolTable;
        this.tacInstructions = tacInstructions;
    }

    @Override
    public Object visitNonEmptyArgList(calParser.NonEmptyArgListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitEmptyArgList(calParser.EmptyArgListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitSingleArg(calParser.SingleArgContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitRecursiveArg(calParser.RecursiveArgContext ctx) {
        return visitChildren(ctx);
    }
}
