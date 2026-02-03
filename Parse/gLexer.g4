lexer grammar gLexer;

@header {
   package Parse.antlr_build;
}

@members {
   StringBuilder sb;
   private int stringToInt(String target) {
      return 0;
   }
}

fragment ALPHA : [A-Za-z];
fragment DIGIT : [0-9];

WS : [ \t\r\n]+ -> skip;

LINE_COMMENT : '//' ~[\r\n]* -> skip;

VAR : 'var';
FUN : 'fun';
WHILE : 'while';
CONST : 'const';
STRING : 'string';
VOID : 'void';
RETURN : 'return';
IF : 'if';
ELSE : 'else';
BREAK : 'break';
INT : 'int';
TYPEDEF : 'typedef';
STRUCT : 'struct';
UNION : 'union';

ARROW : '->';
ANDAND : '&&';
OROR : '||';

LT : '<';
STAR : '*';
PLUS : '+';
TILDE : '~';
ASSIGN : '=';
DOT : '.';

LBRACE : '{';
RBRACE : '}';
COMMA : ',';
LPAREN : '(';
RPAREN : ')';
AMP : '&';
BAR : '|';
BANG : '!';
SEMI : ';';
COLON : ':';
LBRACK : '[';
RBRACK : ']';

DECIMAL_LITERAL : DIGIT+ ;

ID : (ALPHA | '_') (ALPHA | DIGIT | '_')*;
