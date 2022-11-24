/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compiler.semantic;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import compiler.semantic.Sintax;

/**
 *
 * @author p1jav
 */
public class Semantic {
    
    
    public static void main(String[] args, String ruta) throws Exception{
        /*String jflex = System.getProperty("user.dir");
        jflex = jflex + "/src/compiler/semantic/LexerCup.flex";
        String cupruta = System.getProperty("user.dir");
        cupruta = cupruta + "/src/compiler/semantic/Sintax.cup";
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
                /*TYPE.put("Espero","0");
                TYPE.put("Type","");
                TYPE.put("Espero_corchete","0");
                TYPE.put("Assing_up","0");
                TYPE.put("For", "0");
                TYPE.put("For look", "0");
                TYPE.put("For look data", "0");*/
                //System.out.println(graficarNodo(analisis.padre));
                //scope_global = 1;
                //recorrerTabla(analisis.padre);
                //System.out.println("-------- Aquí viene la tabla de símbolo");
                //System.out.println(tabla);
                
                
                /*for (String i : Tabla.keySet()) {
                    System.out.println(i);
                    System.out.println("Var declarations: \n");
                    for (int x = 0; x < Tabla.get(i).size(); x++) {
                        System.out.println("-------");
                        for (String y : Tabla.get(i).get(x).data.keySet()) {
                            System.out.println( "   "+y + ": " + Tabla.get(i).get(x).data.get(y));
                        }
                    }
                }*/
                //System.out.println(tabla);
                
                //tabla = "";
                //Tabla.clear();
                System.out.println("------------- TABLA GENERAL");
                analisis.TABLA.popScope(1);
                analisis.TABLA.pop_m();
                System.out.println("La tabla: \n" + analisis.TABLA.tabla_print());
                
                
                System.out.println("------------- TABLA PARAMETROS");
                System.out.println("La tabla: \n" + analisis.TABLA.tabla_print_m());
            }
            catch (Exception e){
                System.out.println(e);
            }
            
            
        }catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
            
    }
    public static void generar(String rutalexer, String[] rutaSintax) throws IOException, Exception{
        File archivo = new File(rutalexer);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaSintax); 
    }
}
