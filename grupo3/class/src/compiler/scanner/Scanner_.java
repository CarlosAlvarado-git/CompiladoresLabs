/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compiler.scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author carlosalvarado
 */
public class Scanner_ {
public static void main(String[] args, String ruta){
        //String jflex = System.getProperty("user.dir");
        //jflex = jflex + "/src/compiler/scanner/Lexer.flex";
        //generarLexer(jflex);
        
        try{
            try{
                //Path to file
                String archivo = ruta;
                Reader lector = new BufferedReader(new FileReader(archivo));
                Lexer lexer = new Lexer(lector);
                String resultado = "";
                while (true) {
                    Tokens tokens = lexer.yylex();
                    if (tokens == null) {
                        resultado += "FIN";
                        System.out.println(resultado);
                        return;
                    }
                    switch (tokens){
                        case ERROR:
                            resultado += "El simbolo no definido\n";
                            break;
                        case Reservadas: case operador_arith: case alpha:
                        case id:
                        case hex_digit:
                        case decimal_literal:
                        case hex_literal:
                        case rel_op:
                        case assign_op:
                        case digit:
                        case LESS_EQUAL:
                        case GREATER_EQUAL:
                        case EQUAL:
                        case NOT_EQUAL:
                        case AND:
                        case OR:
                        case LEFT_PAR:
                        case RIGHT_PAR:
                                resultado += lexer.lexeme + " Es un " + tokens + " linea: " + lexer.linea +  " columna: " + lexer.columna + "\n";
                                break;
                        default:
                            resultado += "Token " + tokens + "\n";
                            break;
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
            
    }
public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
    
}
