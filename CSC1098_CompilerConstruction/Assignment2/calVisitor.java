// Generated from cal.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link calParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface calVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link calParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(calParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link calParser#decl_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_list(calParser.Decl_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableDeclaration}
	 * labeled alternative in {@link calParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(calParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstantDeclaration}
	 * labeled alternative in {@link calParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclaration(calParser.ConstantDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link calParser#var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl(calParser.Var_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link calParser#const_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst_decl(calParser.Const_declContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionList}
	 * labeled alternative in {@link calParser#function_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionList(calParser.FunctionListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyFunctionList}
	 * labeled alternative in {@link calParser#function_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyFunctionList(calParser.EmptyFunctionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link calParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(calParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link calParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(calParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link calParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(calParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VoidType}
	 * labeled alternative in {@link calParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidType(calParser.VoidTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParamList}
	 * labeled alternative in {@link calParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(calParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyParamList}
	 * labeled alternative in {@link calParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyParamList(calParser.EmptyParamListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleParamCall}
	 * labeled alternative in {@link calParser#nemp_parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleParamCall(calParser.SingleParamCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RecursiveParam}
	 * labeled alternative in {@link calParser#nemp_parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecursiveParam(calParser.RecursiveParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link calParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(calParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatmentBlock}
	 * labeled alternative in {@link calParser#statement_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatmentBlock(calParser.StatmentBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyStatement}
	 * labeled alternative in {@link calParser#statement_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(calParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentStatement}
	 * labeled alternative in {@link calParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(calParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link calParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(calParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BeginBlock}
	 * labeled alternative in {@link calParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginBlock(calParser.BeginBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElseBlock}
	 * labeled alternative in {@link calParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseBlock(calParser.IfElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link calParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(calParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SkipStatement}
	 * labeled alternative in {@link calParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipStatement(calParser.SkipStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionStructure}
	 * labeled alternative in {@link calParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStructure(calParser.ExpressionStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link calParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpression(calParser.ParenthesizedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallInExpression}
	 * labeled alternative in {@link calParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallInExpression(calParser.FunctionCallInExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleExpression}
	 * labeled alternative in {@link calParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleExpression(calParser.SingleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link calParser#binary_arith_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(calParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link calParser#binary_arith_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(calParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FragID}
	 * labeled alternative in {@link calParser#frag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFragID(calParser.FragIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegIdentifier}
	 * labeled alternative in {@link calParser#frag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegIdentifier(calParser.NegIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link calParser#frag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(calParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code True}
	 * labeled alternative in {@link calParser#frag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(calParser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code False}
	 * labeled alternative in {@link calParser#frag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(calParser.FalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Brackets}
	 * labeled alternative in {@link calParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBrackets(calParser.BracketsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegCondition}
	 * labeled alternative in {@link calParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegCondition(calParser.NegConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompareOp}
	 * labeled alternative in {@link calParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareOp(calParser.CompareOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrAndComp}
	 * labeled alternative in {@link calParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrAndComp(calParser.OrAndCompContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link calParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(calParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotEqual}
	 * labeled alternative in {@link calParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqual(calParser.NotEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link calParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThan(calParser.LessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessOrEqual}
	 * labeled alternative in {@link calParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessOrEqual(calParser.LessOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterThan}
	 * labeled alternative in {@link calParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThan(calParser.GreaterThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreatOrEqual}
	 * labeled alternative in {@link calParser#comp_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreatOrEqual(calParser.GreatOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NonEmptyArgList}
	 * labeled alternative in {@link calParser#arg_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonEmptyArgList(calParser.NonEmptyArgListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyArgList}
	 * labeled alternative in {@link calParser#arg_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyArgList(calParser.EmptyArgListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleArg}
	 * labeled alternative in {@link calParser#nemp_arg_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleArg(calParser.SingleArgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RecursiveArg}
	 * labeled alternative in {@link calParser#nemp_arg_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecursiveArg(calParser.RecursiveArgContext ctx);
}