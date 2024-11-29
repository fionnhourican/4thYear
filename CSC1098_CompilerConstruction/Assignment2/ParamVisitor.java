import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.tree.ParseTree;

public class ParamVisitor extends calBaseVisitor<Object> {
    private Map<String, Object> memory;
    private SymbolTable symbolTable;
    public int paramCount;
    private List<String> tacInstructions;

    public ParamVisitor(Map<String, Object> memory, SymbolTable symbolTable, List<String> tacInstructions) {
        this.memory = memory;
        this.symbolTable = symbolTable;
        this.tacInstructions = tacInstructions;
        this.paramCount = 0;
    }

    @Override
    public Object visitParamList(calParser.ParamListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitEmptyParamList(calParser.EmptyParamListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitSingleParamCall(calParser.SingleParamCallContext ctx) {
        String name = ctx.ID().getText();
        String type = ctx.type().getText();
        if (symbolTable.isDeclaredInCurrentScope(name)) {
            System.err.println("Error: Variable " + name + " is already declared in the current scope.");
        } else {
            symbolTable.insertParameter(name, type);
            this.paramCount++;
            tacInstructions.add("param " + name);
        }
        return visitChildren(ctx);
    }

    @Override
    public Object visitRecursiveParam(calParser.RecursiveParamContext ctx) {
        String name = ctx.ID().getText();
        String type = ctx.type().getText();
        if (symbolTable.isDeclaredInCurrentScope(name)) {
            System.err.println("Error: Variable " + name + " is already declared in the current scope.");
        } else {
            symbolTable.insertParameter(name, type);
            this.paramCount++;
            tacInstructions.add("param " + name);
        }
        return visitChildren(ctx);
    }
}