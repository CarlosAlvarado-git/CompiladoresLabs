/*-----1 Area: Codigo usuario--*/
//-------> Paquetes, importaciones
package Analizadores;
import java_cup.runtime.*;
import java.util.LinkedList;

/*-----2 Area: Opciones y declaraciones--*/

%%
%{
    //codigo de usuario, sintaxis java
    public static LinkedList<TError> TablaEl = new LinkedList<TError>();

%}
//----> directivas
%public
%class Analizadores_Lexicos
%cupsym Simbolos
%cup
%char
%column
%full
%ignorecase
%line
%unicode
//-----> Expresiones regulares
numero = [0-9]+


%%
/*-----3 Area: Reglas lexicas--*/
//-----> simbolos

<YYINITIAL> "+"             {System.out.println("Reconocio " + yytext() + " mas "); return new Symbol(Simbolos.mas, yycolumn, yyline, yytext();)}
<YYINITIAL> "-"             {System.out.println("Reconocio " + yytext() + " menos "); return new Symbol(Simbolos.menos, yycolumn, yyline, yytext();)}
<YYINITIAL> "*"             {System.out.println("Reconocio " + yytext() + " por "); return new Symbol(Simbolos.pos, yycolumn, yyline, yytext();)}
<YYINITIAL> "/"             {System.out.println("Reconocio " + yytext() + " div "); return new Symbol(Simbolos.div, yycolumn, yyline, yytext();)}
<YYINITIAL> "("             {System.out.println("Reconocio " + yytext() + " para "); return new Symbol(Simbolos.para, yycolumn, yyline, yytext();)}
<YYINITIAL> ")"             {System.out.println("Reconocio " + yytext() + " parc "); return new Symbol(Simbolos.parc, yycolumn, yyline, yytext();)}

//------> Simbolos ER
<YYINITIAL> {numero}        {System.out.println("Reconocio " + yytext() + " numero "); return new Symbol(Simbolos.num, yycolumn, yyline, yytext();)}

//-----> Espacios
[ \t\r\n\f]                 { /* Espacios en blanco, se ignoran */ }

//-----> Errores lexicos 
.                           {System.out.println("Error lexico"+yytext()+" Linea " + yyline + " Col " + yycolumn);
                                TError datos = new TError(yytext(), yyline, yycolumn, "Error lexico", "Simbolo no existe en el lenguaje");
                                TablaEl.add(datos)
                                }