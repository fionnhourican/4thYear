import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

public class FunctionVisitor extends calBaseVisitor<Object> {
    private Map<String, Object> memory;
    private SymbolTable symbolTable;
    private ParamVisitor paramVisitor;
    private DeclVisitor declVisitor;
    private List<String> tacInstructions;
    private StatementVisitor statmentBlock;
    
    public FunctionVisitor(Map<String, Object> memory, SymbolTable symbolTable, List<String> tacInstructions) {
        this.memory = memory;
        this.symbolTable = symbolTable;
        this.tacInstructions = tacInstructions;
        this.paramVisitor = new ParamVisitor(memory, symbolTable, tacInstructions);
        this.declVisitor = new DeclVisitor(memory, symbolTable, tacInstructions);
        this.statmentBlock = new StatementVisitor(memory, symbolTable, tacInstructions);
    }

    @Override
    public Object visitFunctionList(calParser.FunctionListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitEmptyFunctionList(calParser.EmptyFunctionListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFunction(calParser.FunctionContext ctx) {
        String functionName = ctx.ID().getText();
        if (symbolTable.isDeclaredInCurrentScope(functionName)) {
            System.err.println("Error: Function " + functionName + " is already declared in the current scope. here");
        } else {
            if (symbolTable.lookup(functionName) == null){
                symbolTable.insert(functionName, "function");
                symbolTable.enterScope("function " + functionName);
                tacInstructions.add(functionName + ":");
            }
            // store the return type of the function
            symbolTable.insertFunctionReturnType(functionName, ctx.type().getText());

            // Explicitly visit the parameter list using ParamVisitor
            paramVisitor.paramCount = 0;
            paramVisitor.visit(ctx.parameter_list());

            // store number of parameters in the symbol table
            symbolTable.insertFunctionParameterCount(functionName, paramVisitor.paramCount);
            
            if (ctx.decl_list() != null) {
                // Visit the function body
                declVisitor.visit(ctx.decl_list());
                visit(ctx.statement_block());
                //String statmentBlock = ctx.statement_block().getText().replace(":", " ").replace(";", "\n");
                //tacInstructions.add(statmentBlock);
            }

            // Check if function has statments
            if (ctx.statement_block() != null) {
                // visit the statement block
                statmentBlock.visit(ctx.statement_block());
            }
            
            // Handle return statement
            if (ctx.expression() != null) {
                String returnExpression = ctx.expression().getText();
                String actualReturnType = getActualReturnType(ctx.expression());

                //System.out.println(symbolTable.lookup(ctx.expression().getText()));
                String expectedReturnType = symbolTable.getFunctionReturnTypes().get(functionName);
            
                tacInstructions.add("return " + ctx.expression().getText());

                // Semantic check: Verify return type
                if (!expectedReturnType.equals(actualReturnType)) {
                    System.err.println("Semantic error: Function " + functionName + " expected return type " + expectedReturnType + " but got " + actualReturnType);
                }

                // Semantic check: Verify return statement
                if (!expectedReturnType.equals("void") && ctx.expression() == null) {
                    System.err.println("Semantic error: Non-void function " + functionName + " must have a return statement.");
                } else if (expectedReturnType.equals("void") && ctx.expression() != null) {
                    System.err.println("Semantic error: Void function " + functionName + " cannot have a return statement.");
                }
                
            }

            // mark the function as written
            symbolTable.markVariableWritten(functionName);
            visitChildren(ctx);
            symbolTable.exitScope();
        }
        return null;
    }

    public String getActualReturnType(ParseTree ctx) {
        if (ctx instanceof calParser.ExpressionContext) {
            calParser.ExpressionContext exprCtx = (calParser.ExpressionContext) ctx;
            String type = symbolTable.lookup(exprCtx.getText());
            if (type.equals("int") || type.equals("bool")) {
                return type;
            } else if (type.equals("function")) {
                return symbolTable.getFunctionReturnTypes().get(exprCtx.getText());
            }
        }  
        return null;
    }
}
