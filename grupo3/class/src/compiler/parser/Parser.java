/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compiler.parser;

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
public class Parser {
public static void main(String[] args, String ruta){
        //String jflex = System.getProperty("user.dir");
        //jflex = jflex + "/src/compiler/scanner/Lexer.flex";
        //generarLexer(jflex);
        try{
            try{
                //Path to file
                String archivo = ruta;
                Reader lector = new BufferedReader(new FileReader(archivo));
                // Este lexer debe ser el nuevo, que se conecte con cup. 
                LexerCup lexer = new LexerCup(lector);
                
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
            
    }
public static void generarLexer(String ruta){
        //File archivo = new File(ruta);
        //JFlex.Main.generate(archivo);
    }
    
}
