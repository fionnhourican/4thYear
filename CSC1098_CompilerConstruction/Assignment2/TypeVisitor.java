import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

public class TypeVisitor extends calBaseVisitor<Object> {
    private Map<String, Object> memory;
    private SymbolTable symbolTable;
    private List<String> tacInstructions;

    public TypeVisitor(Map<String, Object> memory, SymbolTable symbolTable, List<String> tacInstructions) {
        this.memory = memory;
        this.symbolTable = symbolTable;
        this.tacInstructions = tacInstructions;
    }

    @Override
    public Object visitIntType(calParser.IntTypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitBoolType(calParser.BoolTypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitVoidType(calParser.VoidTypeContext ctx) {
        return visitChildren(ctx);
    }
}