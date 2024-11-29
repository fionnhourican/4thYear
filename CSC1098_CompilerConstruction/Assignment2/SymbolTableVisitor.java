import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class SymbolTableVisitor extends calBaseVisitor<Void> {
    private SymbolTable symbolTable = new SymbolTable();
    private ParseTreeProperty<String> types = new ParseTreeProperty<>();

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }
    
    @Override
    public Void visitProg(calParser.ProgContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitFunction(calParser.FunctionContext ctx) {
        String functionName = ctx.ID().getText();
        if (symbolTable.isDeclaredInCurrentScope(functionName)) {
            //System.err.println("Error: Function " + functionName + " is already declared in the current scope.");
        } else {
            symbolTable.insert(functionName, "function");
            symbolTable.enterScope("function " + functionName);
            visitChildren(ctx);
            symbolTable.exitScope();
        }
        return null;
    }

    @Override
    public Void visitSingleParamCall(calParser.SingleParamCallContext ctx) {
        String name = ctx.ID().getText();
        String type = ctx.type().getText();
        if (symbolTable.isDeclaredInCurrentScope(name)) {
            //System.err.println("Error: Variable " + name + " is already declared in the current scope.");
        } else {
            symbolTable.insert(name, type);
        }
        return visitChildren(ctx);
    }

    @Override
    public Void visitRecursiveParam(calParser.RecursiveParamContext ctx) {
        String name = ctx.ID().getText();
        String type = ctx.type().getText();
        if (symbolTable.isDeclaredInCurrentScope(name)) {
            //System.err.println("Error: Variable " + name + " is already declared in the current scope.");
        } else {
            symbolTable.insert(name, type);
        }
        visit(ctx.nemp_parameter_list());
        return visitChildren(ctx);
    }

    @Override
    public Void visitVar_decl(calParser.Var_declContext ctx) {
        String name = ctx.ID().getText();
        String type = ctx.type().getText();
        if (symbolTable.isDeclaredInCurrentScope(name)) {
            //System.err.println("Error: Variable " + name + " is already declared in the current scope.");
        } else {
            symbolTable.insert(name, type);
        }
        return visitChildren(ctx);
    }

    @Override
    public Void visitConst_decl(calParser.Const_declContext ctx) {
        String name = ctx.ID().getText();
        String type = ctx.type().getText();
        if (symbolTable.isDeclaredInCurrentScope(name)) {
            //System.err.println("Error: Constant " + name + " is already declared in the current scope.");
        } else {
            symbolTable.insert(name, "const " + type);
        }
        return visitChildren(ctx);
    }

    @Override
    public Void visitFragID(calParser.FragIDContext ctx) {
        String id = ctx.ID().getText();
        if (symbolTable.lookup(id) == null) {
            // Check if variable is a decendent of a function declaration
            if (!(IsFunctionParent(ctx))) {
                System.err.println("Error: Variable " + id + " not declared.");
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public Void visitAssignmentStatement(calParser.AssignmentStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Void visitFunctionCall(calParser.FunctionCallContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Void visitFunctionCallInExpression(calParser.FunctionCallInExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Void visitMain(calParser.MainContext ctx) {
        symbolTable.enterScope("main");
        visitChildren(ctx);
        symbolTable.exitScope();
        return null;
    }

    public Boolean IsFunctionParent(ParseTree ctx) {
        while (ctx.getParent() != null) {
            if (ctx.getParent() == null) {
                return false;
            }
            if (ctx.getParent().getClass().getSimpleName().equals("FunctionContext")) {
                return true;
            }
            ctx = ctx.getParent();
            if (ctx.getParent().getClass().getSimpleName().equals("ProgContext")) {
                return false;
            }
        }
        return false;
    }
}
