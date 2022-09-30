package compiler.scanner;
import static java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup 
%full
%line
%char

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
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value)
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn)
    }
%}
%%

int {return new Symbol(sym.Int, yychar, yyline, yytext());}
boolean {return new Symbol(sym.Boolena, yychar, yyline, yytext());}
callout {return new Symbol(sym.Callout, yychar, yyline, yytext());}
if {return new Symbol(sym.If, yychar, yyline, yytext());}
for {return new Symbol(sym.For, yychar, yyline, yytext());}
else {return new Symbol(sym.Else, yychar, yyline, yytext());}
return {return new Symbol(sym.Return, yychar, yyline, yytext());}
break {return new Symbol(sym.Break, yychar, yyline, yytext());}
continue {return new Symbol(sym.Continue, yychar, yyline, yytext());}
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
