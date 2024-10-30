grammar cal;

// Program structure
prog:   decl_list function_list main;

// Declaration list (variables and constants)
decl_list:      decl SEMI decl_list
                |
                ;

// Declaration of variables or constants
decl:   var_decl        # VariableDeclaration
        | const_decl    # ConstantDeclaration
        ;

// Variable declaration
var_decl:  Variable ID COLON type;

// Constant declaration
const_decl: Constant ID COLON type ASSIGN expression;

// Function list
function_list:  function function_list  # FunctionList
                |                       # EmptyFunctionList
                ;

// Function definition
function: type ID LBR parameter_list RBR Is
            decl_list
            Begin
            statement_block
            Return LBR (expression |) RBR SEMI
            End;

// Type definitions
type:   Int             # IntType
        | Bool          # BoolType
        | Void          # VoidType
        ;

// Parameter list (can be empty)
parameter_list: nemp_parameter_list     # ParamList
                |                       # EmptyParamList
                ;

// Non-empty parameter list
nemp_parameter_list:    ID COLON type                                   # SingleParamCall
                        | ID COLON type COMMA nemp_parameter_list       # RecursiveParam
                        ;

// Main function
main:   Main
        Begin
        decl_list
        statement_block
        End;

// Statement block (can be empty)
statement_block:        statement statement_block       # StatmentBlock
                        |                               # EmptyStatement
                        ;

// Different types of statements
statement:      ID ASSIGN expression SEMI                                               # AssignmentStatement
                | ID LBR arg_list RBR SEMI                                              # FunctionCall
                | Begin statement_block End                                             # BeginBlock
                | If condition Begin statement_block End Else Begin statement_block End # IfElseBlock
                | While condition Begin statement_block End                             # WhileStatement
                | Skip SEMI                                                             # SkipStatement
                ;

// Expression handling with binary operations
expression:     frag binary_arith_op frag       # ExpressionStructure
                | LBR expression RBR            # ParenthesizedExpression
                | ID LBR arg_list RBR           # FunctionCallInExpression
                | frag                          # SingleExpression
                ;

// Binary arithmetic operations
binary_arith_op:        PLUS            # Plus
                        | MINUS         # Minus
                        ;

// Fragment definitions for expressions
frag:   ID              # FragID
        | MINUS ID      # NegIdentifier
        | NUMBER        # Number
        | True          # True
        | False         # False
        ;

// Condition definitions
condition:  NEG condition                       # NegCondition
            | LBR condition RBR                 # Brackets
            | expression comp_op expression     # CompareOp
            | condition (OR | AND) condition    # OrAndComp
            ;

// Comparison operators
comp_op:        EQUAL           # Equal
                | NOTEQUAL      # NotEqual
                | LESSTHAN      # LessThan
                | LESSOREQUAL   # LessOrEqual
                | GREATERTHAN   # GreaterThan
                | GREATOREQUAL  # GreatOrEqual
                ;

// Argument list (can be empty)
arg_list:       nemp_arg_list   # NonEmptyArgList
                |               # EmptyArgList
                ;

// Non-empty argument list
nemp_arg_list:  ID                              # SingleArg
                | ID COMMA nemp_arg_list        # RecursiveArg
                ;

// Defining Tokens

LBR:            '(' ;
RBR:            ')' ;
SEMI:           ';';
COLON:          ':';
ASSIGN:         ':=';
COMMA:          ',';
PLUS:           '+';
MINUS:          '-';
NEG:            '~';
OR:             '|';
AND:            '&';
EQUAL:          '=';
NOTEQUAL:       '!=';
LESSTHAN:       '<';
LESSOREQUAL:    '<=';
GREATERTHAN:    '>';
GREATOREQUAL:   '>=';
DOUBLESLASH:    '//';


// Making the language case insensitive

fragment A:       'a' | 'A';
fragment B:       'b' | 'B';
fragment C:       'c' | 'C';
fragment D:       'd' | 'D';
fragment E:       'e' | 'E';
fragment F:       'f' | 'F';
fragment G:       'g' | 'G';
fragment H:       'h' | 'H';
fragment I:       'i' | 'I';
fragment K:       'k' | 'K';
fragment L:       'l' | 'L';
fragment M:       'm' | 'M';
fragment N:       'n' | 'N';
fragment O:       'o' | 'O';
fragment P:       'p' | 'P';
fragment R:       'r' | 'R';
fragment S:       's' | 'S';
fragment T:       't' | 'T';
fragment U:       'u' | 'U';
fragment V:       'v' | 'V';
fragment W:       'w' | 'W';

// Keywords and identifiers

Variable:       V A R I A B L E;
Constant:       C O N S T A N T;
Begin:          B E G I N;
End:            E N D;
Int:            I N T;
True:           T R U E;
False:          F A L S E;
If:             I F;
Is:             I S;
Return:         R E T U R N;
Void:           V O I D;
Bool:           B O O L;
Else:           E L S E;
While:          W H I L E;
Skip:           S K I P;
Main:           M A I N;

// Identifier and number definitions

fragment Letter: [a-zA-Z];
fragment UnderScore: '_';

ID:           [a-zA-Z][a-zA-Z0-9_]*;
NUMBER:       '0' | '-'? [1-9][0-9]*;

// Define comment types
LINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN); // Line comment
COMMENT: '/*' ( . | WS )* '*/' -> channel(HIDDEN); // Block comment

// Whitespace handling
WS:           [ \t\n\r]+ -> skip;