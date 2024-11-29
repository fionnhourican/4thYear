// Generated from cal.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class calParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LBR=1, RBR=2, SEMI=3, COLON=4, ASSIGN=5, COMMA=6, PLUS=7, MINUS=8, NEG=9, 
		OR=10, AND=11, EQUAL=12, NOTEQUAL=13, LESSTHAN=14, LESSOREQUAL=15, GREATERTHAN=16, 
		GREATOREQUAL=17, DOUBLESLASH=18, Variable=19, Constant=20, Begin=21, End=22, 
		Int=23, True=24, False=25, If=26, Is=27, Return=28, Void=29, Bool=30, 
		Else=31, While=32, Skip=33, Main=34, ID=35, NUMBER=36, LINE_COMMENT=37, 
		COMMENT=38, WS=39;
	public static final int
		RULE_prog = 0, RULE_decl_list = 1, RULE_decl = 2, RULE_var_decl = 3, RULE_const_decl = 4, 
		RULE_function_list = 5, RULE_function = 6, RULE_type = 7, RULE_parameter_list = 8, 
		RULE_nemp_parameter_list = 9, RULE_main = 10, RULE_statement_block = 11, 
		RULE_statement = 12, RULE_expression = 13, RULE_binary_arith_op = 14, 
		RULE_frag = 15, RULE_condition = 16, RULE_comp_op = 17, RULE_arg_list = 18, 
		RULE_nemp_arg_list = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl_list", "decl", "var_decl", "const_decl", "function_list", 
			"function", "type", "parameter_list", "nemp_parameter_list", "main", 
			"statement_block", "statement", "expression", "binary_arith_op", "frag", 
			"condition", "comp_op", "arg_list", "nemp_arg_list"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "';'", "':'", "':='", "','", "'+'", "'-'", "'~'", 
			"'|'", "'&'", "'='", "'!='", "'<'", "'<='", "'>'", "'>='", "'//'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LBR", "RBR", "SEMI", "COLON", "ASSIGN", "COMMA", "PLUS", "MINUS", 
			"NEG", "OR", "AND", "EQUAL", "NOTEQUAL", "LESSTHAN", "LESSOREQUAL", "GREATERTHAN", 
			"GREATOREQUAL", "DOUBLESLASH", "Variable", "Constant", "Begin", "End", 
			"Int", "True", "False", "If", "Is", "Return", "Void", "Bool", "Else", 
			"While", "Skip", "Main", "ID", "NUMBER", "LINE_COMMENT", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "cal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public calParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public Decl_listContext decl_list() {
			return getRuleContext(Decl_listContext.class,0);
		}
		public Function_listContext function_list() {
			return getRuleContext(Function_listContext.class,0);
		}
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			decl_list();
			setState(41);
			function_list();
			setState(42);
			main();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Decl_listContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(calParser.SEMI, 0); }
		public Decl_listContext decl_list() {
			return getRuleContext(Decl_listContext.class,0);
		}
		public Decl_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitDecl_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decl_listContext decl_list() throws RecognitionException {
		Decl_listContext _localctx = new Decl_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl_list);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Variable:
			case Constant:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				decl();
				setState(45);
				match(SEMI);
				setState(46);
				decl_list();
				}
				break;
			case Begin:
			case End:
			case Int:
			case If:
			case Void:
			case Bool:
			case While:
			case Skip:
			case Main:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	 
		public DeclContext() { }
		public void copyFrom(DeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstantDeclarationContext extends DeclContext {
		public Const_declContext const_decl() {
			return getRuleContext(Const_declContext.class,0);
		}
		public ConstantDeclarationContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitConstantDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends DeclContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public VariableDeclarationContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Variable:
				_localctx = new VariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				var_decl();
				}
				break;
			case Constant:
				_localctx = new ConstantDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				const_decl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_declContext extends ParserRuleContext {
		public TerminalNode Variable() { return getToken(calParser.Variable, 0); }
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode COLON() { return getToken(calParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitVar_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(Variable);
			setState(56);
			match(ID);
			setState(57);
			match(COLON);
			setState(58);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Const_declContext extends ParserRuleContext {
		public TerminalNode Constant() { return getToken(calParser.Constant, 0); }
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode COLON() { return getToken(calParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(calParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Const_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitConst_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Const_declContext const_decl() throws RecognitionException {
		Const_declContext _localctx = new Const_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_const_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(Constant);
			setState(61);
			match(ID);
			setState(62);
			match(COLON);
			setState(63);
			type();
			setState(64);
			match(ASSIGN);
			setState(65);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_listContext extends ParserRuleContext {
		public Function_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_list; }
	 
		public Function_listContext() { }
		public void copyFrom(Function_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyFunctionListContext extends Function_listContext {
		public EmptyFunctionListContext(Function_listContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitEmptyFunctionList(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionListContext extends Function_listContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public Function_listContext function_list() {
			return getRuleContext(Function_listContext.class,0);
		}
		public FunctionListContext(Function_listContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitFunctionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_listContext function_list() throws RecognitionException {
		Function_listContext _localctx = new Function_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_list);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
			case Void:
			case Bool:
				_localctx = new FunctionListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				function();
				setState(68);
				function_list();
				}
				break;
			case Main:
				_localctx = new EmptyFunctionListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public List<TerminalNode> LBR() { return getTokens(calParser.LBR); }
		public TerminalNode LBR(int i) {
			return getToken(calParser.LBR, i);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public List<TerminalNode> RBR() { return getTokens(calParser.RBR); }
		public TerminalNode RBR(int i) {
			return getToken(calParser.RBR, i);
		}
		public TerminalNode Is() { return getToken(calParser.Is, 0); }
		public Decl_listContext decl_list() {
			return getRuleContext(Decl_listContext.class,0);
		}
		public TerminalNode Begin() { return getToken(calParser.Begin, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode Return() { return getToken(calParser.Return, 0); }
		public TerminalNode SEMI() { return getToken(calParser.SEMI, 0); }
		public TerminalNode End() { return getToken(calParser.End, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			type();
			setState(74);
			match(ID);
			setState(75);
			match(LBR);
			setState(76);
			parameter_list();
			setState(77);
			match(RBR);
			setState(78);
			match(Is);
			setState(79);
			decl_list();
			setState(80);
			match(Begin);
			setState(81);
			statement_block();
			setState(82);
			match(Return);
			setState(83);
			match(LBR);
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBR:
			case MINUS:
			case True:
			case False:
			case ID:
			case NUMBER:
				{
				setState(84);
				expression();
				}
				break;
			case RBR:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(88);
			match(RBR);
			setState(89);
			match(SEMI);
			setState(90);
			match(End);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VoidTypeContext extends TypeContext {
		public TerminalNode Void() { return getToken(calParser.Void, 0); }
		public VoidTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitVoidType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolTypeContext extends TypeContext {
		public TerminalNode Bool() { return getToken(calParser.Bool, 0); }
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntTypeContext extends TypeContext {
		public TerminalNode Int() { return getToken(calParser.Int, 0); }
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Int:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				match(Int);
				}
				break;
			case Bool:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(Bool);
				}
				break;
			case Void:
				_localctx = new VoidTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				match(Void);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parameter_listContext extends ParserRuleContext {
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
	 
		public Parameter_listContext() { }
		public void copyFrom(Parameter_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyParamListContext extends Parameter_listContext {
		public EmptyParamListContext(Parameter_listContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitEmptyParamList(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends Parameter_listContext {
		public Nemp_parameter_listContext nemp_parameter_list() {
			return getRuleContext(Nemp_parameter_listContext.class,0);
		}
		public ParamListContext(Parameter_listContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameter_list);
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new ParamListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				nemp_parameter_list();
				}
				break;
			case RBR:
				_localctx = new EmptyParamListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Nemp_parameter_listContext extends ParserRuleContext {
		public Nemp_parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nemp_parameter_list; }
	 
		public Nemp_parameter_listContext() { }
		public void copyFrom(Nemp_parameter_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleParamCallContext extends Nemp_parameter_listContext {
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode COLON() { return getToken(calParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SingleParamCallContext(Nemp_parameter_listContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitSingleParamCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RecursiveParamContext extends Nemp_parameter_listContext {
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode COLON() { return getToken(calParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(calParser.COMMA, 0); }
		public Nemp_parameter_listContext nemp_parameter_list() {
			return getRuleContext(Nemp_parameter_listContext.class,0);
		}
		public RecursiveParamContext(Nemp_parameter_listContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitRecursiveParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nemp_parameter_listContext nemp_parameter_list() throws RecognitionException {
		Nemp_parameter_listContext _localctx = new Nemp_parameter_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nemp_parameter_list);
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new SingleParamCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(ID);
				setState(102);
				match(COLON);
				setState(103);
				type();
				}
				break;
			case 2:
				_localctx = new RecursiveParamContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(ID);
				setState(105);
				match(COLON);
				setState(106);
				type();
				setState(107);
				match(COMMA);
				setState(108);
				nemp_parameter_list();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public TerminalNode Main() { return getToken(calParser.Main, 0); }
		public TerminalNode Begin() { return getToken(calParser.Begin, 0); }
		public Decl_listContext decl_list() {
			return getRuleContext(Decl_listContext.class,0);
		}
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode End() { return getToken(calParser.End, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(Main);
			setState(113);
			match(Begin);
			setState(114);
			decl_list();
			setState(115);
			statement_block();
			setState(116);
			match(End);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Statement_blockContext extends ParserRuleContext {
		public Statement_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_block; }
	 
		public Statement_blockContext() { }
		public void copyFrom(Statement_blockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyStatementContext extends Statement_blockContext {
		public EmptyStatementContext(Statement_blockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatmentBlockContext extends Statement_blockContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public StatmentBlockContext(Statement_blockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitStatmentBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_blockContext statement_block() throws RecognitionException {
		Statement_blockContext _localctx = new Statement_blockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement_block);
		try {
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Begin:
			case If:
			case While:
			case Skip:
			case ID:
				_localctx = new StatmentBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				statement();
				setState(119);
				statement_block();
				}
				break;
			case End:
			case Return:
				_localctx = new EmptyStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfElseBlockContext extends StatementContext {
		public TerminalNode If() { return getToken(calParser.If, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<TerminalNode> Begin() { return getTokens(calParser.Begin); }
		public TerminalNode Begin(int i) {
			return getToken(calParser.Begin, i);
		}
		public List<Statement_blockContext> statement_block() {
			return getRuleContexts(Statement_blockContext.class);
		}
		public Statement_blockContext statement_block(int i) {
			return getRuleContext(Statement_blockContext.class,i);
		}
		public List<TerminalNode> End() { return getTokens(calParser.End); }
		public TerminalNode End(int i) {
			return getToken(calParser.End, i);
		}
		public TerminalNode Else() { return getToken(calParser.Else, 0); }
		public IfElseBlockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitIfElseBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SkipStatementContext extends StatementContext {
		public TerminalNode Skip() { return getToken(calParser.Skip, 0); }
		public TerminalNode SEMI() { return getToken(calParser.SEMI, 0); }
		public SkipStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitSkipStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BeginBlockContext extends StatementContext {
		public TerminalNode Begin() { return getToken(calParser.Begin, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode End() { return getToken(calParser.End, 0); }
		public BeginBlockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitBeginBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentStatementContext extends StatementContext {
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(calParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(calParser.SEMI, 0); }
		public AssignmentStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends StatementContext {
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public TerminalNode SEMI() { return getToken(calParser.SEMI, 0); }
		public FunctionCallContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends StatementContext {
		public TerminalNode While() { return getToken(calParser.While, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode Begin() { return getToken(calParser.Begin, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode End() { return getToken(calParser.End, 0); }
		public WhileStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new AssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(ID);
				setState(125);
				match(ASSIGN);
				setState(126);
				expression();
				setState(127);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new FunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(ID);
				setState(130);
				match(LBR);
				setState(131);
				arg_list();
				setState(132);
				match(RBR);
				setState(133);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new BeginBlockContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(135);
				match(Begin);
				setState(136);
				statement_block();
				setState(137);
				match(End);
				}
				break;
			case 4:
				_localctx = new IfElseBlockContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(139);
				match(If);
				setState(140);
				condition(0);
				setState(141);
				match(Begin);
				setState(142);
				statement_block();
				setState(143);
				match(End);
				setState(144);
				match(Else);
				setState(145);
				match(Begin);
				setState(146);
				statement_block();
				setState(147);
				match(End);
				}
				break;
			case 5:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(149);
				match(While);
				setState(150);
				condition(0);
				setState(151);
				match(Begin);
				setState(152);
				statement_block();
				setState(153);
				match(End);
				}
				break;
			case 6:
				_localctx = new SkipStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(155);
				match(Skip);
				setState(156);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesizedExpressionContext extends ExpressionContext {
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public ParenthesizedExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitParenthesizedExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleExpressionContext extends ExpressionContext {
		public FragContext frag() {
			return getRuleContext(FragContext.class,0);
		}
		public SingleExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitSingleExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStructureContext extends ExpressionContext {
		public List<FragContext> frag() {
			return getRuleContexts(FragContext.class);
		}
		public FragContext frag(int i) {
			return getRuleContext(FragContext.class,i);
		}
		public Binary_arith_opContext binary_arith_op() {
			return getRuleContext(Binary_arith_opContext.class,0);
		}
		public ExpressionStructureContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitExpressionStructure(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallInExpressionContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public FunctionCallInExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitFunctionCallInExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expression);
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new ExpressionStructureContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				frag();
				setState(160);
				binary_arith_op();
				setState(161);
				frag();
				}
				break;
			case 2:
				_localctx = new ParenthesizedExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(LBR);
				setState(164);
				expression();
				setState(165);
				match(RBR);
				}
				break;
			case 3:
				_localctx = new FunctionCallInExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				match(ID);
				setState(168);
				match(LBR);
				setState(169);
				arg_list();
				setState(170);
				match(RBR);
				}
				break;
			case 4:
				_localctx = new SingleExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				frag();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Binary_arith_opContext extends ParserRuleContext {
		public Binary_arith_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_arith_op; }
	 
		public Binary_arith_opContext() { }
		public void copyFrom(Binary_arith_opContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlusContext extends Binary_arith_opContext {
		public TerminalNode PLUS() { return getToken(calParser.PLUS, 0); }
		public PlusContext(Binary_arith_opContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MinusContext extends Binary_arith_opContext {
		public TerminalNode MINUS() { return getToken(calParser.MINUS, 0); }
		public MinusContext(Binary_arith_opContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_arith_opContext binary_arith_op() throws RecognitionException {
		Binary_arith_opContext _localctx = new Binary_arith_opContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_binary_arith_op);
		try {
			setState(177);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				_localctx = new PlusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				match(PLUS);
				}
				break;
			case MINUS:
				_localctx = new MinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				match(MINUS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FragContext extends ParserRuleContext {
		public FragContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frag; }
	 
		public FragContext() { }
		public void copyFrom(FragContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends FragContext {
		public TerminalNode NUMBER() { return getToken(calParser.NUMBER, 0); }
		public NumberContext(FragContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegIdentifierContext extends FragContext {
		public TerminalNode MINUS() { return getToken(calParser.MINUS, 0); }
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public NegIdentifierContext(FragContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitNegIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueContext extends FragContext {
		public TerminalNode True() { return getToken(calParser.True, 0); }
		public TrueContext(FragContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FragIDContext extends FragContext {
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public FragIDContext(FragContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitFragID(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseContext extends FragContext {
		public TerminalNode False() { return getToken(calParser.False, 0); }
		public FalseContext(FragContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitFalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FragContext frag() throws RecognitionException {
		FragContext _localctx = new FragContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_frag);
		try {
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new FragIDContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(ID);
				}
				break;
			case MINUS:
				_localctx = new NegIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				match(MINUS);
				setState(181);
				match(ID);
				}
				break;
			case NUMBER:
				_localctx = new NumberContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				match(NUMBER);
				}
				break;
			case True:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(183);
				match(True);
				}
				break;
			case False:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(184);
				match(False);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	 
		public ConditionContext() { }
		public void copyFrom(ConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BracketsContext extends ConditionContext {
		public TerminalNode LBR() { return getToken(calParser.LBR, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RBR() { return getToken(calParser.RBR, 0); }
		public BracketsContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitBrackets(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegConditionContext extends ConditionContext {
		public TerminalNode NEG() { return getToken(calParser.NEG, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public NegConditionContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitNegCondition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompareOpContext extends ConditionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Comp_opContext comp_op() {
			return getRuleContext(Comp_opContext.class,0);
		}
		public CompareOpContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitCompareOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrAndCompContext extends ConditionContext {
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode OR() { return getToken(calParser.OR, 0); }
		public TerminalNode AND() { return getToken(calParser.AND, 0); }
		public OrAndCompContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitOrAndComp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_condition, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				_localctx = new NegConditionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(188);
				match(NEG);
				setState(189);
				condition(4);
				}
				break;
			case 2:
				{
				_localctx = new BracketsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				match(LBR);
				setState(191);
				condition(0);
				setState(192);
				match(RBR);
				}
				break;
			case 3:
				{
				_localctx = new CompareOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				expression();
				setState(195);
				comp_op();
				setState(196);
				expression();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(205);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OrAndCompContext(new ConditionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_condition);
					setState(200);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(201);
					_la = _input.LA(1);
					if ( !(_la==OR || _la==AND) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(202);
					condition(2);
					}
					} 
				}
				setState(207);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Comp_opContext extends ParserRuleContext {
		public Comp_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_op; }
	 
		public Comp_opContext() { }
		public void copyFrom(Comp_opContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessOrEqualContext extends Comp_opContext {
		public TerminalNode LESSOREQUAL() { return getToken(calParser.LESSOREQUAL, 0); }
		public LessOrEqualContext(Comp_opContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitLessOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessThanContext extends Comp_opContext {
		public TerminalNode LESSTHAN() { return getToken(calParser.LESSTHAN, 0); }
		public LessThanContext(Comp_opContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitLessThan(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotEqualContext extends Comp_opContext {
		public TerminalNode NOTEQUAL() { return getToken(calParser.NOTEQUAL, 0); }
		public NotEqualContext(Comp_opContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitNotEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualContext extends Comp_opContext {
		public TerminalNode EQUAL() { return getToken(calParser.EQUAL, 0); }
		public EqualContext(Comp_opContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreaterThanContext extends Comp_opContext {
		public TerminalNode GREATERTHAN() { return getToken(calParser.GREATERTHAN, 0); }
		public GreaterThanContext(Comp_opContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitGreaterThan(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreatOrEqualContext extends Comp_opContext {
		public TerminalNode GREATOREQUAL() { return getToken(calParser.GREATOREQUAL, 0); }
		public GreatOrEqualContext(Comp_opContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitGreatOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comp_opContext comp_op() throws RecognitionException {
		Comp_opContext _localctx = new Comp_opContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_comp_op);
		try {
			setState(214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EQUAL:
				_localctx = new EqualContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				match(EQUAL);
				}
				break;
			case NOTEQUAL:
				_localctx = new NotEqualContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				match(NOTEQUAL);
				}
				break;
			case LESSTHAN:
				_localctx = new LessThanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
				match(LESSTHAN);
				}
				break;
			case LESSOREQUAL:
				_localctx = new LessOrEqualContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(211);
				match(LESSOREQUAL);
				}
				break;
			case GREATERTHAN:
				_localctx = new GreaterThanContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(212);
				match(GREATERTHAN);
				}
				break;
			case GREATOREQUAL:
				_localctx = new GreatOrEqualContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(213);
				match(GREATOREQUAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Arg_listContext extends ParserRuleContext {
		public Arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_list; }
	 
		public Arg_listContext() { }
		public void copyFrom(Arg_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NonEmptyArgListContext extends Arg_listContext {
		public Nemp_arg_listContext nemp_arg_list() {
			return getRuleContext(Nemp_arg_listContext.class,0);
		}
		public NonEmptyArgListContext(Arg_listContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitNonEmptyArgList(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyArgListContext extends Arg_listContext {
		public EmptyArgListContext(Arg_listContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitEmptyArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arg_list);
		try {
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new NonEmptyArgListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				nemp_arg_list();
				}
				break;
			case RBR:
				_localctx = new EmptyArgListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Nemp_arg_listContext extends ParserRuleContext {
		public Nemp_arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nemp_arg_list; }
	 
		public Nemp_arg_listContext() { }
		public void copyFrom(Nemp_arg_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleArgContext extends Nemp_arg_listContext {
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public SingleArgContext(Nemp_arg_listContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitSingleArg(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RecursiveArgContext extends Nemp_arg_listContext {
		public TerminalNode ID() { return getToken(calParser.ID, 0); }
		public TerminalNode COMMA() { return getToken(calParser.COMMA, 0); }
		public Nemp_arg_listContext nemp_arg_list() {
			return getRuleContext(Nemp_arg_listContext.class,0);
		}
		public RecursiveArgContext(Nemp_arg_listContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calVisitor ) return ((calVisitor<? extends T>)visitor).visitRecursiveArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nemp_arg_listContext nemp_arg_list() throws RecognitionException {
		Nemp_arg_listContext _localctx = new Nemp_arg_listContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_nemp_arg_list);
		try {
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new SingleArgContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				match(ID);
				}
				break;
			case 2:
				_localctx = new RecursiveArgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				match(ID);
				setState(222);
				match(COMMA);
				setState(223);
				nemp_arg_list();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\'\u00e3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"2\b\u0001\u0001\u0002\u0001\u0002\u0003\u00026\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005H\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006W\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007`\b\u0007\u0001\b\u0001\b\u0003"+
		"\bd\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\to\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b{\b\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u009e\b\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00ae\b\r\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u00b2\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00ba\b\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00c7\b\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00cc\b\u0010\n\u0010\f\u0010"+
		"\u00cf\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u00d7\b\u0011\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u00db\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u00e1\b\u0013\u0001\u0013\u0000\u0001 \u0014\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000"+
		"\u0001\u0001\u0000\n\u000b\u00ee\u0000(\u0001\u0000\u0000\u0000\u0002"+
		"1\u0001\u0000\u0000\u0000\u00045\u0001\u0000\u0000\u0000\u00067\u0001"+
		"\u0000\u0000\u0000\b<\u0001\u0000\u0000\u0000\nG\u0001\u0000\u0000\u0000"+
		"\fI\u0001\u0000\u0000\u0000\u000e_\u0001\u0000\u0000\u0000\u0010c\u0001"+
		"\u0000\u0000\u0000\u0012n\u0001\u0000\u0000\u0000\u0014p\u0001\u0000\u0000"+
		"\u0000\u0016z\u0001\u0000\u0000\u0000\u0018\u009d\u0001\u0000\u0000\u0000"+
		"\u001a\u00ad\u0001\u0000\u0000\u0000\u001c\u00b1\u0001\u0000\u0000\u0000"+
		"\u001e\u00b9\u0001\u0000\u0000\u0000 \u00c6\u0001\u0000\u0000\u0000\""+
		"\u00d6\u0001\u0000\u0000\u0000$\u00da\u0001\u0000\u0000\u0000&\u00e0\u0001"+
		"\u0000\u0000\u0000()\u0003\u0002\u0001\u0000)*\u0003\n\u0005\u0000*+\u0003"+
		"\u0014\n\u0000+\u0001\u0001\u0000\u0000\u0000,-\u0003\u0004\u0002\u0000"+
		"-.\u0005\u0003\u0000\u0000./\u0003\u0002\u0001\u0000/2\u0001\u0000\u0000"+
		"\u000002\u0001\u0000\u0000\u00001,\u0001\u0000\u0000\u000010\u0001\u0000"+
		"\u0000\u00002\u0003\u0001\u0000\u0000\u000036\u0003\u0006\u0003\u0000"+
		"46\u0003\b\u0004\u000053\u0001\u0000\u0000\u000054\u0001\u0000\u0000\u0000"+
		"6\u0005\u0001\u0000\u0000\u000078\u0005\u0013\u0000\u000089\u0005#\u0000"+
		"\u00009:\u0005\u0004\u0000\u0000:;\u0003\u000e\u0007\u0000;\u0007\u0001"+
		"\u0000\u0000\u0000<=\u0005\u0014\u0000\u0000=>\u0005#\u0000\u0000>?\u0005"+
		"\u0004\u0000\u0000?@\u0003\u000e\u0007\u0000@A\u0005\u0005\u0000\u0000"+
		"AB\u0003\u001a\r\u0000B\t\u0001\u0000\u0000\u0000CD\u0003\f\u0006\u0000"+
		"DE\u0003\n\u0005\u0000EH\u0001\u0000\u0000\u0000FH\u0001\u0000\u0000\u0000"+
		"GC\u0001\u0000\u0000\u0000GF\u0001\u0000\u0000\u0000H\u000b\u0001\u0000"+
		"\u0000\u0000IJ\u0003\u000e\u0007\u0000JK\u0005#\u0000\u0000KL\u0005\u0001"+
		"\u0000\u0000LM\u0003\u0010\b\u0000MN\u0005\u0002\u0000\u0000NO\u0005\u001b"+
		"\u0000\u0000OP\u0003\u0002\u0001\u0000PQ\u0005\u0015\u0000\u0000QR\u0003"+
		"\u0016\u000b\u0000RS\u0005\u001c\u0000\u0000SV\u0005\u0001\u0000\u0000"+
		"TW\u0003\u001a\r\u0000UW\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000"+
		"VU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0005\u0002\u0000"+
		"\u0000YZ\u0005\u0003\u0000\u0000Z[\u0005\u0016\u0000\u0000[\r\u0001\u0000"+
		"\u0000\u0000\\`\u0005\u0017\u0000\u0000]`\u0005\u001e\u0000\u0000^`\u0005"+
		"\u001d\u0000\u0000_\\\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000"+
		"_^\u0001\u0000\u0000\u0000`\u000f\u0001\u0000\u0000\u0000ad\u0003\u0012"+
		"\t\u0000bd\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cb\u0001\u0000"+
		"\u0000\u0000d\u0011\u0001\u0000\u0000\u0000ef\u0005#\u0000\u0000fg\u0005"+
		"\u0004\u0000\u0000go\u0003\u000e\u0007\u0000hi\u0005#\u0000\u0000ij\u0005"+
		"\u0004\u0000\u0000jk\u0003\u000e\u0007\u0000kl\u0005\u0006\u0000\u0000"+
		"lm\u0003\u0012\t\u0000mo\u0001\u0000\u0000\u0000ne\u0001\u0000\u0000\u0000"+
		"nh\u0001\u0000\u0000\u0000o\u0013\u0001\u0000\u0000\u0000pq\u0005\"\u0000"+
		"\u0000qr\u0005\u0015\u0000\u0000rs\u0003\u0002\u0001\u0000st\u0003\u0016"+
		"\u000b\u0000tu\u0005\u0016\u0000\u0000u\u0015\u0001\u0000\u0000\u0000"+
		"vw\u0003\u0018\f\u0000wx\u0003\u0016\u000b\u0000x{\u0001\u0000\u0000\u0000"+
		"y{\u0001\u0000\u0000\u0000zv\u0001\u0000\u0000\u0000zy\u0001\u0000\u0000"+
		"\u0000{\u0017\u0001\u0000\u0000\u0000|}\u0005#\u0000\u0000}~\u0005\u0005"+
		"\u0000\u0000~\u007f\u0003\u001a\r\u0000\u007f\u0080\u0005\u0003\u0000"+
		"\u0000\u0080\u009e\u0001\u0000\u0000\u0000\u0081\u0082\u0005#\u0000\u0000"+
		"\u0082\u0083\u0005\u0001\u0000\u0000\u0083\u0084\u0003$\u0012\u0000\u0084"+
		"\u0085\u0005\u0002\u0000\u0000\u0085\u0086\u0005\u0003\u0000\u0000\u0086"+
		"\u009e\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0015\u0000\u0000\u0088"+
		"\u0089\u0003\u0016\u000b\u0000\u0089\u008a\u0005\u0016\u0000\u0000\u008a"+
		"\u009e\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u001a\u0000\u0000\u008c"+
		"\u008d\u0003 \u0010\u0000\u008d\u008e\u0005\u0015\u0000\u0000\u008e\u008f"+
		"\u0003\u0016\u000b\u0000\u008f\u0090\u0005\u0016\u0000\u0000\u0090\u0091"+
		"\u0005\u001f\u0000\u0000\u0091\u0092\u0005\u0015\u0000\u0000\u0092\u0093"+
		"\u0003\u0016\u000b\u0000\u0093\u0094\u0005\u0016\u0000\u0000\u0094\u009e"+
		"\u0001\u0000\u0000\u0000\u0095\u0096\u0005 \u0000\u0000\u0096\u0097\u0003"+
		" \u0010\u0000\u0097\u0098\u0005\u0015\u0000\u0000\u0098\u0099\u0003\u0016"+
		"\u000b\u0000\u0099\u009a\u0005\u0016\u0000\u0000\u009a\u009e\u0001\u0000"+
		"\u0000\u0000\u009b\u009c\u0005!\u0000\u0000\u009c\u009e\u0005\u0003\u0000"+
		"\u0000\u009d|\u0001\u0000\u0000\u0000\u009d\u0081\u0001\u0000\u0000\u0000"+
		"\u009d\u0087\u0001\u0000\u0000\u0000\u009d\u008b\u0001\u0000\u0000\u0000"+
		"\u009d\u0095\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000"+
		"\u009e\u0019\u0001\u0000\u0000\u0000\u009f\u00a0\u0003\u001e\u000f\u0000"+
		"\u00a0\u00a1\u0003\u001c\u000e\u0000\u00a1\u00a2\u0003\u001e\u000f\u0000"+
		"\u00a2\u00ae\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u0001\u0000\u0000"+
		"\u00a4\u00a5\u0003\u001a\r\u0000\u00a5\u00a6\u0005\u0002\u0000\u0000\u00a6"+
		"\u00ae\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005#\u0000\u0000\u00a8\u00a9"+
		"\u0005\u0001\u0000\u0000\u00a9\u00aa\u0003$\u0012\u0000\u00aa\u00ab\u0005"+
		"\u0002\u0000\u0000\u00ab\u00ae\u0001\u0000\u0000\u0000\u00ac\u00ae\u0003"+
		"\u001e\u000f\u0000\u00ad\u009f\u0001\u0000\u0000\u0000\u00ad\u00a3\u0001"+
		"\u0000\u0000\u0000\u00ad\u00a7\u0001\u0000\u0000\u0000\u00ad\u00ac\u0001"+
		"\u0000\u0000\u0000\u00ae\u001b\u0001\u0000\u0000\u0000\u00af\u00b2\u0005"+
		"\u0007\u0000\u0000\u00b0\u00b2\u0005\b\u0000\u0000\u00b1\u00af\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b2\u001d\u0001\u0000"+
		"\u0000\u0000\u00b3\u00ba\u0005#\u0000\u0000\u00b4\u00b5\u0005\b\u0000"+
		"\u0000\u00b5\u00ba\u0005#\u0000\u0000\u00b6\u00ba\u0005$\u0000\u0000\u00b7"+
		"\u00ba\u0005\u0018\u0000\u0000\u00b8\u00ba\u0005\u0019\u0000\u0000\u00b9"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b9\u00b4\u0001\u0000\u0000\u0000\u00b9"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9"+
		"\u00b8\u0001\u0000\u0000\u0000\u00ba\u001f\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\u0006\u0010\uffff\uffff\u0000\u00bc\u00bd\u0005\t\u0000\u0000\u00bd"+
		"\u00c7\u0003 \u0010\u0004\u00be\u00bf\u0005\u0001\u0000\u0000\u00bf\u00c0"+
		"\u0003 \u0010\u0000\u00c0\u00c1\u0005\u0002\u0000\u0000\u00c1\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c3\u0003\u001a\r\u0000\u00c3\u00c4\u0003\""+
		"\u0011\u0000\u00c4\u00c5\u0003\u001a\r\u0000\u00c5\u00c7\u0001\u0000\u0000"+
		"\u0000\u00c6\u00bb\u0001\u0000\u0000\u0000\u00c6\u00be\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c2\u0001\u0000\u0000\u0000\u00c7\u00cd\u0001\u0000\u0000"+
		"\u0000\u00c8\u00c9\n\u0001\u0000\u0000\u00c9\u00ca\u0007\u0000\u0000\u0000"+
		"\u00ca\u00cc\u0003 \u0010\u0002\u00cb\u00c8\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd"+
		"\u00ce\u0001\u0000\u0000\u0000\u00ce!\u0001\u0000\u0000\u0000\u00cf\u00cd"+
		"\u0001\u0000\u0000\u0000\u00d0\u00d7\u0005\f\u0000\u0000\u00d1\u00d7\u0005"+
		"\r\u0000\u0000\u00d2\u00d7\u0005\u000e\u0000\u0000\u00d3\u00d7\u0005\u000f"+
		"\u0000\u0000\u00d4\u00d7\u0005\u0010\u0000\u0000\u00d5\u00d7\u0005\u0011"+
		"\u0000\u0000\u00d6\u00d0\u0001\u0000\u0000\u0000\u00d6\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d2\u0001\u0000\u0000\u0000\u00d6\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d7#\u0001\u0000\u0000\u0000\u00d8\u00db\u0003&\u0013\u0000"+
		"\u00d9\u00db\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000"+
		"\u00da\u00d9\u0001\u0000\u0000\u0000\u00db%\u0001\u0000\u0000\u0000\u00dc"+
		"\u00e1\u0005#\u0000\u0000\u00dd\u00de\u0005#\u0000\u0000\u00de\u00df\u0005"+
		"\u0006\u0000\u0000\u00df\u00e1\u0003&\u0013\u0000\u00e0\u00dc\u0001\u0000"+
		"\u0000\u0000\u00e0\u00dd\u0001\u0000\u0000\u0000\u00e1\'\u0001\u0000\u0000"+
		"\u0000\u001115GV_cnz\u009d\u00ad\u00b1\u00b9\u00c6\u00cd\u00d6\u00da\u00e0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}