/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author carlosalvarado
 */
public class Principal {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String ruta = "/Users/carlosalvarado/NetBeansProjects/AnalizadorLexico/src/codigo/Lexer.flex";
        generarLexer(ruta);
        BufferedReader leer_archivo;
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("- ");
            String comando = sc.nextLine();

            //System.out.println(comando);
            comando = comando.replaceAll(" ", "");

            int j = comando.indexOf("java");
            int c = comando.indexOf("Compiler");

            if (j == 0 && c == 4) {
                //System.out.println("Si escricio java Compiler");
                int nada = comando.length();
                if (nada == 12) {
                    System.out.println("Con el comando java Compiler -h \nSe despliega un meno de ayuda.\n");

                }
                else{
                    int find_menos = comando.indexOf("-");
                    String archivo = comando.substring(12, find_menos);
                    System.out.println("El archivo es: " + archivo);
                    if (archivo.equals("")){
                        System.out.println("Se despliega el menu de ayuda!");
                        //ver si es h, sino decir que esta incorrecto el comando, falta el archivo!
                    }
                    else{
                        //leer archivo
                        try{
                            leer_archivo = new BufferedReader(new FileReader(archivo));
                            //System.out.println(leer_archivo.readLine());
                            String linea;
                            
                            while ((linea = leer_archivo.readLine()) != null){
                              Lexer lexer = new Lexer(leer_archivo);
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
                                    }
                                }  
                            }   
                        } catch(FileNotFoundException e){
                            e.printStackTrace();
                        }
                    }
                }

            }
            else if (comando.equals("exit")){
                break;
            }
            else{
                System.out.println("No escribio correctamente el comando");
            }
            
        }
        
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
                }
        
        */
    }
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }

    private static void elseif(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
