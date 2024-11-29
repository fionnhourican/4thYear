import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

public class DeclVisitor extends calBaseVisitor<Object> {
    private Map<String, Object> memory;
    private SymbolTable symbolTable;
    private List<String> tacInstructions;

    public DeclVisitor(Map<String, Object> memory, SymbolTable symbolTable, List<String> tacInstructions) {
        this.memory = memory;
        this.symbolTable = symbolTable;
    }

    @Override
    public Object visitDecl_list(calParser.Decl_listContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitVariableDeclaration(calParser.VariableDeclarationContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitConstantDeclaration(calParser.ConstantDeclarationContext ctx) {

        return visitChildren(ctx);
    }

    @Override
    public Object visitVar_decl(calParser.Var_declContext ctx) {
        String name = ctx.ID().getText();
        String type = ctx.type().getText();
        if (symbolTable.isDeclaredInCurrentScope(name)) {
            System.err.println("Error: Variable " + name + " is already declared in the current scope.");
        } else {
            symbolTable.insertVariable(name, type);
            symbolTable.markVariableWritten(name);   
        }
        return visitChildren(ctx);
    }

    @Override
    public Object visitConst_decl(calParser.Const_declContext ctx) {
        String name = ctx.ID().getText();
        String type = ctx.type().getText();
        if (symbolTable.isDeclaredInCurrentScope(name)) {
            System.err.println("Error: Constant " + name + " is already declared in the current scope.");
        } else {
            symbolTable.insertConstant(name, type);
            symbolTable.markVariableWritten(name);
        }
        return visitChildren(ctx);
    }
}
