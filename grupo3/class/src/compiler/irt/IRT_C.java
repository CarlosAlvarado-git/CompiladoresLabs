/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compiler.irt;

import compiler.irt.LexerCup;
import compiler.irt.Sintax;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import compiler.irt.Nodo_irt;
import java.util.HashSet;
import java.util.ArrayList;

/**
 *
 * @author p1jav
 */
public class IRT_C {
    public static void main(String[] args, String ruta) throws Exception{
        /*String jflex = System.getProperty("user.dir");
        jflex = jflex + "/src/compiler/irt/LexerCup.flex";
        String cupruta = System.getProperty("user.dir");
        cupruta = cupruta + "/src/compiler/irt/Sintax.cup";
        String[] rutaS = {"-parser", "Sintax", cupruta};
        generar(jflex, rutaS);*/
        try{
            //Path to file
            String archivo = ruta;
            Reader lector = new BufferedReader(new FileReader(archivo));
            // Este lexer debe ser el nuevo, que se conecte con cup.
            Sintax analisis = new Sintax(new LexerCup(lector));
            
            try {
                analisis.parse();
                System.out.println("------------- TABLA GENERAL");
                analisis.TABLA.popScope(1);
                analisis.TABLA.pop_m();
                System.out.println("La tabla: \n" + analisis.TABLA.tabla_print());
                System.out.println("------------- TABLA PARAMETROS");
                System.out.println("La tabla: \n" + analisis.TABLA.tabla_print_m());
                System.out.println("\n\n\n\n------------- GENERACION DE IRT");
                System.out.println("El size es: " + analisis.Lista_IRT.size());
                for (int i = 0; i < analisis.Lista_IRT.size(); i++) {
                    System.out.println(analisis.Lista_IRT.get(i).getNombre());
                    switch (analisis.Lista_IRT.get(i).getNombre()) {
                        case "Operador":
                            System.out.println(analisis.Lista_IRT.get(i).Operador());
                            break;
                        case "Asignacion":
                            System.out.println(analisis.Lista_IRT.get(i).Asignacion());
                            break;
                        case "Method_call":
                            System.out.println(analisis.Lista_IRT.get(i).Metodo());
                            break;
                        case "Metodo":
                            System.out.println(analisis.Lista_IRT.get(i).Metodo_());
                            break;
                        case "IF":
                            System.out.println(analisis.Lista_IRT.get(i).IF_C());
                            break;
                        case "ELSE":
                            System.out.println(analisis.Lista_IRT.get(i).ELSE_C());
                            break;
                        case "END_IF":
                            System.out.println(analisis.Lista_IRT.get(i).END_IF_C());
                            break;
                        case "Condicion":
                            System.out.println(analisis.Lista_IRT.get(i).Condicion());
                            break;
                        case "FOR":
                            System.out.println(analisis.Lista_IRT.get(i).FOR_C());
                            break;
                        case "Operacion_FOR":
                            System.out.println(analisis.Lista_IRT.get(i).Operador());
                            break;
                        case "Jump_FOR":
                            System.out.println(analisis.Lista_IRT.get(i).FOR_C());
                            break;
                        case "Break_FOR":
                            System.out.println(analisis.Lista_IRT.get(i).FOR_C());
                            break;
                        case "End_FOR":
                            System.out.println(analisis.Lista_IRT.get(i).FOR_C());
                            break;
                        case "Continue_For":
                            System.out.println(analisis.Lista_IRT.get(i).Continue_c());
                        break;
                        default:
                            System.out.println("No es nada");
                            break;
                    }
                }
                lector.close();
                
                
                
            }
            catch (Exception e){
                System.out.println(e);
            }
            lector.close();
            
            
        }catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        /*ArrayList<Nodo_irt> Lista_IRT = new ArrayList<>();
        Nodo_irt operacion = new Nodo_irt("Operador");
        operacion.Crear_operacion("Mas", "a", "b");
        // Stack para manejos de resgistros $t
        operacion.op.setRegistro("$t0"); // si puse $t0 es porque no hay nada en el stack
        
        Nodo_irt asignacion = new Nodo_irt("Asignacion");
        asignacion.Crear_Asignacion("ASSIGN", "$t0", "a"); // puse $t porque es resultado de una operacion. 
        Lista_IRT.add(operacion);
        Lista_IRT.add(asignacion);
        //Lista_IRT.get(Lista_IRT.size() - 1).getNombre().equals("IF") ==> 
            //Lista_IRT.get(Lista_IRT.size() - 1).IF_IRT.addTrue(asignacion);
               
        for (int i = 0; i < Lista_IRT.size(); i++) {
            System.out.println(Lista_IRT.get(i).getNombre());
            if(Lista_IRT.get(i).getNombre().equals("Operador")){
                System.out.println(Lista_IRT.get(i).Operador());
                }
            else if(Lista_IRT.get(i).getNombre().equals("Asignacion")){
                System.out.println(Lista_IRT.get(i).Asignacion());
                }
            else {
                System.out.println("No es nada");
                }
          }*/
        
            
    }
    public static void generar(String rutalexer, String[] rutaSintax) throws IOException, Exception{
        File archivo = new File(rutalexer);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaSintax); 
    }
    
}