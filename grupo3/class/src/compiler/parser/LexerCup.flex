package compiler.parser;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup 
%full
%line
%char

alpha = [a-zA-Z_]
alpha_num = [_0-9A-Za-z]
//digit = [0-9]
decimal_literal = ([0-9][0-9]*)
hex_digit = ([0-9a-fA-F])
hex_literal = (0[Xx]{hex_digit}+)
//rel_op = ([<|>])
//arith_op = [+|-|*|/|%]
//assign_op = [=]


espacio=[\t\r\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

int {return new Symbol(sym.Int, yychar, yyline, yytext());}
boolean {return new Symbol(sym.Boolean, yychar, yyline, yytext());}
callout {return new Symbol(sym.Callout, yychar, yyline, yytext());}
if {return new Symbol(sym.If, yychar, yyline, yytext());}
for {return new Symbol(sym.For, yychar, yyline, yytext());}
else {return new Symbol(sym.Else, yychar, yyline, yytext());}
return {return new Symbol(sym.Return, yychar, yyline, yytext());}
break {return new Symbol(sym.Break, yychar, yyline, yytext());}
continue {return new Symbol(sym.Continue, yychar, yyline, yytext());}
true {return new Symbol(sym.True, yychar, yyline, yytext());}
false {return new Symbol(sym.False, yychar, yyline, yytext());}
void {return new Symbol(sym.Void, yychar, yyline, yytext());}
class {return new Symbol(sym.Class, yychar, yyline, yytext());}
Program {return new Symbol(sym.Program, yychar, yyline, yytext());}

{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
" " {/*Ignore*/} 
{alpha} {return new Symbol(sym.Alpha, yychar, yyline, yytext());}
{alpha_num} {return new Symbol(sym.Alpha_num, yychar, yyline, yytext());}

{decimal_literal} {return new Symbol(sym.Decimal_literal, yychar, yyline, yytext());}
{hex_digit} {return new Symbol(sym.Hex_digit, yychar, yyline, yytext());}
{hex_literal} {return new Symbol(sym.Hex_literal, yychar, yyline, yytext());}
//{rel_op} {return new Symbol(sym.Rel_op, yychar, yyline, yytext());}
//{assign_op} {return new Symbol(sym.Assign_op, yychar, yyline, yytext());}

"<"                {return new Symbol(sym.GREATER, yychar, yyline, yytext());}
">"                {return new Symbol(sym.LESS, yychar, yyline, yytext());}
"<="                {return new Symbol(sym.LESS_EQUAL, yychar, yyline, yytext());}
">="                {return new Symbol(sym.GREATER_EQUAL, yychar, yyline, yytext());}
"+="                {return new Symbol(sym.PLUS_EQUAL, yychar, yyline, yytext());}
"="                {return new Symbol(sym.ASSIGN, yychar, yyline, yytext());}
"-="                {return new Symbol(sym.MINUS_EQUAL, yychar, yyline, yytext());}
"=="                {return new Symbol(sym.EQUAL, yychar, yyline, yytext());}
"!="                {return new Symbol(sym.NOT_EQUAL, yychar, yyline, yytext());}
"&&"                {return new Symbol(sym.AND, yychar, yyline, yytext());}
"||"                {return new Symbol(sym.OR, yychar, yyline, yytext());}
"("                {return new Symbol(sym.LEFT_PAR, yychar, yyline, yytext());}
")"                {return new Symbol(sym.RIGHT_PAR, yychar, yyline, yytext());}
";"                {return new Symbol(sym.Punto_coma, yychar, yyline, yytext());}
"+"                {return new Symbol(sym.Mas, yychar, yyline, yytext());}
"-"                {return new Symbol(sym.Menos, yychar, yyline, yytext());}
"*"                {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}
"/"                {return new Symbol(sym.Division, yychar, yyline, yytext());}
"%"                {return new Symbol(sym.Mod, yychar, yyline, yytext());}
"{"                {return new Symbol(sym.Llave_A, yychar, yyline, yytext());}
"}"                {return new Symbol(sym.Llave_C, yychar, yyline, yytext());}
"["                {return new Symbol(sym.Corche_A, yychar, yyline, yytext());}
"]"                {return new Symbol(sym.Corche_C, yychar, yyline, yytext());}
","                {return new Symbol(sym.Coma, yychar, yyline, yytext());}
"'"                {return new Symbol(sym.Comillas, yychar, yyline, yytext());}
"''"                {return new Symbol(sym.ComillasDoble, yychar, yyline, yytext());}
"!"                {return new Symbol(sym.Exclamacion, yychar, yyline, yytext());}




. {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
