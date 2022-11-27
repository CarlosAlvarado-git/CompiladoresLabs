package compiler.scanner;
import static compiler.scanner.Tokens.*;
%%
%class Lexer
%type Tokens
%line
%column

string_literal = ([\"][^\".]+[\"])
char_literal = ([\'][^\'.][\'])
digit = [0-9]
alpha = [a-zA-Z]
hex_digit = [0-9a-fA-F]
id = {alpha}({alpha}|{digit})*
hex_literal = [0][xX]{hex_digit}({hex_digit})*
decimal_literal = {digit}({digit})*


espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
    public int linea;
    public int columna;
%}
%%

int |
boolean |
callout |
if |
for |
else |
return |
break |
continue |
true |
false |
void |
class |
Program |
while {lexeme=yytext(); linea=yyline; columna=yycolumn; return Reservadas;}

{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
{string_literal} {lexeme=yytext(); linea=yyline; columna=yycolumn;  return string_literal;}
{char_literal} {lexeme=yytext(); linea=yyline; columna=yycolumn;  return char_literal;}
{id} {lexeme=yytext(); linea=yyline; columna=yycolumn; return id;}
{digit} {lexeme=yytext(); linea=yyline; columna=yycolumn; return digit;}
{alpha} {lexeme=yytext(); linea=yyline; columna=yycolumn; return alpha;}
{hex_digit} {lexeme=yytext(); linea=yyline; columna=yycolumn; return hex_digit;}
{decimal_literal} {lexeme=yytext(); linea=yyline; columna=yycolumn; return decimal_literal;}
{hex_literal} {lexeme=yytext(); linea=yyline; columna=yycolumn;  return hex_literal;}



"<"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return GREATER;    }
">"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return LESS;    }
"<="               {lexeme=yytext(); linea=yyline; columna=yycolumn; return LESS_EQUAL;    }
">="               {lexeme=yytext(); linea=yyline; columna=yycolumn; return GREATER_EQUAL;    }
"+="               {lexeme=yytext(); linea=yyline; columna=yycolumn; return PLUS_EQUAL;    }
"="                {lexeme=yytext(); linea=yyline; columna=yycolumn; return ASSIGN;    }
"-="               {lexeme=yytext(); linea=yyline; columna=yycolumn; return MINUS_EQUAL;    }
"=="               {lexeme=yytext(); linea=yyline; columna=yycolumn; return EQUAL;    }
"!="               {lexeme=yytext(); linea=yyline; columna=yycolumn; return NOT_EQUAL;    }
"&&"               {lexeme=yytext(); linea=yyline; columna=yycolumn; return AND;    }
"||"               {lexeme=yytext(); linea=yyline; columna=yycolumn; return OR;    }
"("                {lexeme=yytext(); linea=yyline; columna=yycolumn; return LEFT_PAR;    }
")"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return RIGHT_PAR;    }
";"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return Punto_coma;    }
"+"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return Mas;    }
"-"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return Menos;    }
"*"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return Multiplicacion;    }
"/"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return Division;    }
"%"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return Mod;    }
"{"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return Llave_A;    }
"}"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return Llave_C;    }
"["                {lexeme=yytext(); linea=yyline; columna=yycolumn; return Corche_A;    }
"]"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return Corche_C;    }
","                {lexeme=yytext(); linea=yyline; columna=yycolumn; return Coma;    }
"!"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return Exclamacion;    }


 . {lexeme=yytext(); linea=yyline; columna=yycolumn; return ERROR;}
