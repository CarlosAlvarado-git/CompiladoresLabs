/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compiler.irt;

import compiler.irt.LexerCup;
import compiler.irt.Sintax;
import compiler.irt.IRT;
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
        generar(jflex, rutaS);
        String cupruta2 = System.getProperty("user.dir");
        cupruta2 = cupruta2 + "/src/compiler/irt/IRT.cup";
        String[] rutaS2 = {"-parser", "IRT", cupruta2};
        generar(jflex, rutaS2);*/
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
                    if(analisis.Lista_IRT.get(i).getNombre().equals("Operador")){
                        System.out.println(analisis.Lista_IRT.get(i).Operador());
                        }
                    else if(analisis.Lista_IRT.get(i).getNombre().equals("Asignacion")){
                        System.out.println(analisis.Lista_IRT.get(i).Asignacion());
                        }
                    else if(analisis.Lista_IRT.get(i).getNombre().equals("Metodo")){
                        System.out.println(analisis.Lista_IRT.get(i).Metodo());
                    
                    }
                    else {
                        System.out.println("No es nada");
                        }
                }
                lector.close();
                
                
                
            }
            catch (Exception e){
                System.out.println(e);
            }
            lector.close();
            lector = new BufferedReader(new FileReader(archivo));
            IRT analisis_irt = new IRT(new LexerCup(lector));
                
            try{
                
                analisis_irt.parse();
                System.out.println("\n\n\n\n------------- GENERACION DE IRT ------- con IRT.JAVA");
                System.out.println("El size es: " + analisis_irt.Lista_IRT.size());
                for (int i = 0; i < analisis_irt.Lista_IRT.size(); i++) {
                    System.out.println(analisis_irt.Lista_IRT.get(i).getNombre());
                    if(analisis_irt.Lista_IRT.get(i).getNombre().equals("Operador")){
                        System.out.println(analisis_irt.Lista_IRT.get(i).Operador());
                        }
                    else if(analisis_irt.Lista_IRT.get(i).getNombre().equals("Asignacion")){
                        System.out.println(analisis_irt.Lista_IRT.get(i).Asignacion());
                        }
                    else if(analisis_irt.Lista_IRT.get(i).getNombre().equals("Metodo")){
                        System.out.println(analisis_irt.Lista_IRT.get(i).Metodo());
                    
                    }
                    else {
                        System.out.println("No es nada");
                        }
                  }
                
            }
            catch (Exception e){
                System.out.println("error desde el catch");
                System.out.println(e);
            }
            
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