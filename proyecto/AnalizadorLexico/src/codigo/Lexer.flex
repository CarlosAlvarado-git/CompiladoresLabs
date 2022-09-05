package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens

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
{id} {lexeme=yytext(); linea=yyline; columna=yycolumn; return id;}
{arith_op} {lexeme=yytext(); linea=yyline; columna=yycolumn; return operador_arith;}
{digit} {lexeme=yytext(); linea=yyline; columna=yycolumn; return digit;}
{alpha} {lexeme=yytext(); linea=yyline; columna=yycolumn; return alpha;}
{hex_digit} {lexeme=yytext(); linea=yyline; columna=yycolumn; return hex_digit;}
{decimal_literal} {lexeme=yytext(); linea=yyline; columna=yycolumn; return decimal_literal;}
{hex_literal} {lexeme=yytext(); linea=yyline; columna=yycolumn;  return hex_literal;}
{rel_op} {lexeme=yytext(); linea=yyline; columna=yycolumn; return rel_op;}
{assign_op} {lexeme=yytext(); linea=yyline; columna=yycolumn; return assign_op;}
left_par {lexeme=yytext(); linea=yyline; columna=yycolumn; return left_par;}
right_par {lexeme=yytext(); linea=yyline; columna=yycolumn; return right_par;}

"<="                {lexeme=yytext(); linea=yyline; columna=yycolumn; return LESS_EQUAL;    }
">="                { lexeme=yytext();linea=yyline; columna=yycolumn;  return GREATER_EQUAL; }
"=="                { lexeme=yytext();linea=yyline; columna=yycolumn; return EQUAL;         }
"!="                { lexeme=yytext();linea=yyline; columna=yycolumn; return NOT_EQUAL;     }
"&&"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return AND;           }
"||"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return OR;            }
"("                {lexeme=yytext(); linea=yyline; columna=yycolumn; return LEFT_PAR;           }
")"                {lexeme=yytext(); linea=yyline; columna=yycolumn; return RIGHT_PAR;            }


 . {return ERROR;}
