package compiler.scanner;
import static compiler.scanner.Tokens.*;
%%
%class Lexer
%type Tokens
%line
%column

id = ([A-Za-z][_0-9A-Za-z]+)
alpha = [a-zA-Z_]
digit = [0-9]
hex_digit = ([0-9a-fA-F])
decimal_literal = ([0-9][0-9]*)
hex_literal = (0[Xx]{hex_digit}+)
rel_op = ([<|>])
arith_op = [+|-|*|/|%]
assign_op = [=]


espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
    public int linea;
    public int columna;
%}
%%

int {lexeme=yytext(); linea=yyline; columna=yycolumn; return Int;}
boolean {lexeme=yytext(); linea=yyline; columna=yycolumn; return Boolean;}
callout {lexeme=yytext(); linea=yyline; columna=yycolumn; return Callout;}
if {lexeme=yytext(); linea=yyline; columna=yycolumn; return If;}
for {lexeme=yytext(); linea=yyline; columna=yycolumn; return For;}
else {lexeme=yytext(); linea=yyline; columna=yycolumn; return Else;}
return {lexeme=yytext(); linea=yyline; columna=yycolumn; return Return;}
break {lexeme=yytext(); linea=yyline; columna=yycolumn; return Break;}
continue {lexeme=yytext(); linea=yyline; columna=yycolumn; return Continue;}
true {lexeme=yytext(); linea=yyline; columna=yycolumn; return True;}
false {lexeme=yytext(); linea=yyline; columna=yycolumn; return False;}
void {lexeme=yytext(); linea=yyline; columna=yycolumn; return Void;}
class {lexeme=yytext(); linea=yyline; columna=yycolumn; return Class;}
Program {lexeme=yytext(); linea=yyline; columna=yycolumn; return Program;}
while {lexeme=yytext(); linea=yyline; columna=yycolumn; return While;}

{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
{id} {lexeme=yytext(); linea=yyline; columna=yycolumn; return id;}
{arith_op} {lexeme=yytext(); linea=yyline; columna=yycolumn; return operador_arith;}
{digit} {lexeme=yytext(); linea=yyline; columna=yycolumn; return digit;}
{alpha} {lexeme=yytext(); linea=yyline; columna=yycolumn; return alpha;}
{hex_digit} {lexeme=yytext(); linea=yyline; columna=yycolumn; return hex_digit;}
{decimal_literal} {lexeme=yytext(); linea=yyline; columna=yycolumn; return decimal_literal;}
{hex_literal} {lexeme=yytext(); linea=yyline; columna=yycolumn;  return hex_literal;}
{rel_op} {lexeme=yytext(); linea=yyline; columna=yycolumn; return rel_op;}
{assign_op} {lexeme=yytext(); linea=yyline; columna=yycolumn; return assign_op;}

"\n"                {return Linea}
"<="                {lexeme=yytext(); linea=yyline; columna=yycolumn; return LESS_EQUAL;    }
">="                { lexeme=yytext();linea=yyline; columna=yycolumn;  return GREATER_EQUAL; }
"=="                { lexeme=yytext();linea=yyline; columna=yycolumn; return EQUAL;         }
"!="                { lexeme=yytext();linea=yyline; columna=yycolumn; return NOT_EQUAL;     }
"&&"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return AND;           }
"||"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return OR;            }
"("                {lexeme=yytext(); linea=yyline; columna=yycolumn; return LEFT_PAR;           }
")"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return RIGHT_PAR;            }
";"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return Punto_coma;            }

 . {return ERROR;}
