lexer grammar gLexer;

@header {
   package Parse.antlr_build;
}

@members {
   private int stringToInt(String target) {
      if (target == null || target.length() == 0) return 0;
      if (target.charAt(0) == 'x' || target.charAt(0) == 'X') {
         return Integer.parseInt(target.substring(1), 16);
      }
      return Integer.parseInt(target, 8);
   }

   private String processString(String raw) {
      StringBuilder out = new StringBuilder();
      int i = 1;
      int end = raw.length() - 1;
      while (i < end) {
         char c = raw.charAt(i);
         if (c != '\\') {
            out.append(c);
            i++;
            continue;
         }
         i++;
         if (i >= end) break;
         char e = raw.charAt(i);
         if (e == 'n') { out.append('\n'); i++; continue; }
         if (e == 't') { out.append('\t'); i++; continue; }
         if (e == 'r') { out.append('\r'); i++; continue; }
         if (e == 'b') { out.append('\b'); i++; continue; }
         if (e == 'f') { out.append('\f'); i++; continue; }
         if (e == '\\') { out.append('\\'); i++; continue; }
         if (e == '"') { out.append('\"'); i++; continue; }

         if (e == 'x' || e == 'X') {
            int j = i + 1;
            while (j < end) {
               char h = raw.charAt(j);
               boolean ok = (h >= '0' && h <= '9') || (h >= 'a' && h <= 'f') || (h >= 'A' && h <= 'F');
               if (!ok) break;
               j++;
            }
            String hex = raw.substring(i, j);
            out.append((char) stringToInt(hex));
            i = j;
            continue;
         }

         if (e >= '0' && e <= '7') {
            int j = i;
            int count = 0;
            while (j < end && count < 3) {
               char o = raw.charAt(j);
               if (o < '0' || o > '7') break;
               j++;
               count++;
            }
            String oct = raw.substring(i, j);
            out.append((char) stringToInt(oct));
            i = j;
            continue;
         }

         out.append(e);
         i++;
      }
      return out.toString();
   }
}


fragment ALPHA : [A-Za-z];
fragment DIGIT : [0-9];

WS : [ \t\r\n]+ -> skip;

LINE_COMMENT : '//' ~[\r\n]* -> skip;
BLOCK_COMMENT : '/*' .*? '*/' -> skip;

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

STRING_LITERAL
   : '"' ( '\\' . | ~["\\\r\n] )* '"'
      { setText(processString(getText())); }
   ;
   
HEX_LITERAL : '0' [xX] [0-9a-fA-F]+ ;       
OCTAL_LITERAL : '0' [0-7]+ ;                 
DECIMAL_LITERAL : [1-9] DIGIT* | '0' ; 

ID : (ALPHA | '_') (ALPHA | DIGIT | '_')*;


