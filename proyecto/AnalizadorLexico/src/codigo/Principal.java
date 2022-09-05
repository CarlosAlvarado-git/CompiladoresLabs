/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import java.io.File;

/**
 *
 * @author carlosalvarado
 */
public class Principal {
    public static void main(String[] args) {
        String ruta = "/Users/carlosalvarado/NetBeansProjects/AnalizadorLexico/src/codigo/Lexer.flex";
        generarLexer(ruta);
        // leer de terminal java Compiler <filename> -target scan
        //Leer archivo txt por medio del <filename>
        //Crear linkedlist para guardar los tokens en ver de printear el resultado
        /*
            Reader lector = new BufferedReader(new FileReader("archivo.txt"));
            Lexer lexer = new Lexer(lector);
            String resultado = "";
            while (true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    resultado += "FIN";
                    txtResultado.setText(resultado);
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
                    case left_par:
                    case right_par:
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
        
        
        */
    }
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
}
