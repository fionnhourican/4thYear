import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Trees;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class EvalVisitor extends calBaseVisitor<Object> {
    private Map<String, Object> memory = new HashMap<>();
    private SymbolTable symbolTable;
    private FunctionVisitor functionVisitor;
    private DeclVisitor declVisitor;
    private TypeVisitor typeVisitor;
    private ParamVisitor paramVisitor;
    private StatementVisitor statementVisitor;
    private ExpressionVisitor expressionVisitor;
    private BinaryOpVisitor binaryOpVisitor;
    private FragVisitor fragVisitor;
    private ConditionVisitor conditionVisitor;
    private CompOpVisitor compOpVisitor;
    private ArgListVisitor argListVisitor;
    private StatmentBlockVisitor statmentBlockVisitor;
    private List<String> tacInstructions = new ArrayList<>();

    public EvalVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        this.functionVisitor = new FunctionVisitor(memory, symbolTable, tacInstructions);
        this.declVisitor = new DeclVisitor(memory, symbolTable, tacInstructions);
        this.typeVisitor = new TypeVisitor(memory, symbolTable, tacInstructions);
        this.paramVisitor = new ParamVisitor(memory, symbolTable, tacInstructions);
        this.statementVisitor = new StatementVisitor(memory, symbolTable, tacInstructions);
        this.expressionVisitor = new ExpressionVisitor(memory, symbolTable, tacInstructions);
        this.binaryOpVisitor = new BinaryOpVisitor(memory, symbolTable, tacInstructions);
        this.fragVisitor = new FragVisitor(memory, symbolTable, tacInstructions);
        this.conditionVisitor = new ConditionVisitor(memory, symbolTable, tacInstructions);
        this.compOpVisitor = new CompOpVisitor(memory, symbolTable);
        this.argListVisitor = new ArgListVisitor(memory, symbolTable, tacInstructions);
        this.statmentBlockVisitor = new StatmentBlockVisitor(memory, symbolTable, tacInstructions);
    }

    public Map<String, Object> getMemory() {
        return memory;
    }
    public List<String> getTacInstructions() {

        return tacInstructions;

    }

    @Override
    public Object visitProg(calParser.ProgContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitDecl_list(calParser.Decl_listContext ctx) {
        return declVisitor.visitDecl_list(ctx);
    }

    @Override
    public Object visitVariableDeclaration(calParser.VariableDeclarationContext ctx) {
        return declVisitor.visitVariableDeclaration(ctx);
    }

    @Override
    public Object visitConstantDeclaration(calParser.ConstantDeclarationContext ctx) {
        return declVisitor.visitConstantDeclaration(ctx);
    }

    @Override
    public Object visitVar_decl(calParser.Var_declContext ctx) {
        return declVisitor.visitVar_decl(ctx);
    }

    @Override
    public Object visitConst_decl(calParser.Const_declContext ctx) {
        return declVisitor.visitConst_decl(ctx);
    }

    @Override
    public Object visitFunctionList(calParser.FunctionListContext ctx) {
        return functionVisitor.visitFunctionList(ctx);
    }

    @Override
    public Object visitEmptyFunctionList(calParser.EmptyFunctionListContext ctx) {
        return functionVisitor.visitEmptyFunctionList(ctx);
    }

    @Override
    public Object visitFunction(calParser.FunctionContext ctx) {
        return functionVisitor.visitFunction(ctx);
    }

    @Override
    public Object visitIntType(calParser.IntTypeContext ctx) {
        return typeVisitor.visitIntType(ctx);
    }

    @Override
    public Object visitBoolType(calParser.BoolTypeContext ctx) {
        return typeVisitor.visitBoolType(ctx);
    }

    @Override
    public Object visitVoidType(calParser.VoidTypeContext ctx) {
        return typeVisitor.visitVoidType(ctx);
    }

    @Override
    public Object visitParamList(calParser.ParamListContext ctx) {
        return paramVisitor.visitParamList(ctx);
    }

    @Override
    public Object visitEmptyParamList(calParser.EmptyParamListContext ctx) {
        return paramVisitor.visitEmptyParamList(ctx);
    }

    @Override
    public Object visitSingleParamCall(calParser.SingleParamCallContext ctx) {
        return paramVisitor.visitSingleParamCall(ctx);
    }

    @Override
    public Object visitRecursiveParam(calParser.RecursiveParamContext ctx) {
        return paramVisitor.visitRecursiveParam(ctx);
    }

    @Override
    public Object visitMain(calParser.MainContext ctx) {
        symbolTable.enterScope("main");
        tacInstructions.add("main:");
        statementVisitor.visit(ctx.statement_block());
        visitChildren(ctx);
        symbolTable.exitScope();
        return null;
    }

    @Override
    public Object visitStatmentBlock(calParser.StatmentBlockContext ctx) {
        return statmentBlockVisitor.visitStatmentBlock(ctx);
    }

    @Override
    public Object visitEmptyStatement(calParser.EmptyStatementContext ctx) {
        return statmentBlockVisitor.visitEmptyStatement(ctx);
    }

    @Override
    public Object visitAssignmentStatement(calParser.AssignmentStatementContext ctx) {
        return statementVisitor.visitAssignmentStatement(ctx);
    }

    @Override
    public Object visitFunctionCall(calParser.FunctionCallContext ctx) {
        return statementVisitor.visitFunctionCall(ctx);
    }

    @Override
    public Object visitBeginBlock(calParser.BeginBlockContext ctx) {
        return statementVisitor.visitBeginBlock(ctx);
    }

    @Override
    public Object visitIfElseBlock(calParser.IfElseBlockContext ctx) {
        return statementVisitor.visitIfElseBlock(ctx);
    }

    @Override
    public Object visitWhileStatement(calParser.WhileStatementContext ctx) {
        return statementVisitor.visitWhileStatement(ctx);
    }

    @Override
    public Object visitSkipStatement(calParser.SkipStatementContext ctx) {
        return statementVisitor.visitSkipStatement(ctx);
    }

    @Override
    public Object visitExpressionStructure(calParser.ExpressionStructureContext ctx) {
        return expressionVisitor.visitExpressionStructure(ctx);
    }

    @Override
    public Object visitParenthesizedExpression(calParser.ParenthesizedExpressionContext ctx) {
        return expressionVisitor.visitParenthesizedExpression(ctx);
    }

    @Override
    public Object visitFunctionCallInExpression(calParser.FunctionCallInExpressionContext ctx) {
        return expressionVisitor.visitFunctionCallInExpression(ctx);
    }

    @Override
    public Object visitSingleExpression(calParser.SingleExpressionContext ctx) {
        return expressionVisitor.visitSingleExpression(ctx);
    }

    @Override
    public Object visitPlus(calParser.PlusContext ctx) {
        return binaryOpVisitor.visitPlus(ctx);
    }

    @Override
    public Object visitMinus(calParser.MinusContext ctx) {
        return binaryOpVisitor.visitMinus(ctx);
    }

    @Override
    public Object visitFragID(calParser.FragIDContext ctx) {
        return fragVisitor.visitFragID(ctx);
    }

    @Override
    public Object visitNegIdentifier(calParser.NegIdentifierContext ctx) {
        return fragVisitor.visitNegIdentifier(ctx);
    }

    @Override
    public Object visitNumber(calParser.NumberContext ctx) {
        return fragVisitor.visitNumber(ctx);
    }

    @Override
    public Object visitTrue(calParser.TrueContext ctx) {
        return fragVisitor.visitTrue(ctx);
    }

    @Override
    public Object visitFalse(calParser.FalseContext ctx) {
        return fragVisitor.visitFalse(ctx);
    }

    @Override
    public Object visitBrackets(calParser.BracketsContext ctx) {
        return conditionVisitor.visitBrackets(ctx);
    }

    @Override
    public Object visitNegCondition(calParser.NegConditionContext ctx) {
        return conditionVisitor.visitNegCondition(ctx);
    }

    @Override
    public Object visitCompareOp(calParser.CompareOpContext ctx) {
        return conditionVisitor.visitCompareOp(ctx);
    }

    @Override
    public Object visitOrAndComp(calParser.OrAndCompContext ctx) {
        return conditionVisitor.visitOrAndComp(ctx);
    }

    @Override
    public Object visitEqual(calParser.EqualContext ctx) {
        return compOpVisitor.visitEqual(ctx);
    }

    @Override
    public Object visitNotEqual(calParser.NotEqualContext ctx) {
        return compOpVisitor.visitNotEqual(ctx);
    }

    @Override
    public Object visitLessThan(calParser.LessThanContext ctx) {
        return compOpVisitor.visitLessThan(ctx);
    }

    @Override
    public Object visitLessOrEqual(calParser.LessOrEqualContext ctx) {
        return compOpVisitor.visitLessOrEqual(ctx);
    }

    @Override
    public Object visitGreaterThan(calParser.GreaterThanContext ctx) {
        return compOpVisitor.visitGreaterThan(ctx);
    }

    @Override
    public Object visitGreatOrEqual(calParser.GreatOrEqualContext ctx) {
        return compOpVisitor.visitGreatOrEqual(ctx);
    }

    @Override
    public Object visitNonEmptyArgList(calParser.NonEmptyArgListContext ctx) {
        return argListVisitor.visitNonEmptyArgList(ctx);
    }

    @Override
    public Object visitEmptyArgList(calParser.EmptyArgListContext ctx) {
        return argListVisitor.visitEmptyArgList(ctx);
    }

    @Override
    public Object visitSingleArg(calParser.SingleArgContext ctx) {
        return argListVisitor.visitSingleArg(ctx);
    }

    @Override
    public Object visitRecursiveArg(calParser.RecursiveArgContext ctx) {
        return argListVisitor.visitRecursiveArg(ctx);
    }

    // Method to print the parse tree nicely
    public void printTree(ParseTree tree, calParser parser, int indent) {
        StringBuilder sb = new StringBuilder();
        buildTreeString(tree, parser, indent, sb);
        System.out.println(sb.toString());
    }
    
    private void buildTreeString(ParseTree tree, calParser parser, int indent, StringBuilder sb) {
        for (int i = 0; i < indent; i++) {
            sb.append(" |- ");
        }
        sb.append(Trees.getNodeText(tree, parser));
        sb.append("\n");
        for (int i = 0; i < tree.getChildCount(); i++) {
            buildTreeString(tree.getChild(i), parser, indent + 1, sb);
        }
    }

    public void printSymbolTable() {
        symbolTable.printAllScopes(memory);
    }
}
