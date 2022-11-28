/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compiler.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;

/**
 *
 * @author carlosalvarado
 */
public class Parser {
public static void main(String[] args/*, String ruta*/) throws Exception{
        String jflex = System.getProperty("user.dir");
        jflex = jflex + "/src/compiler/parser/LexerCup.flex";
        String cupruta = System.getProperty("user.dir");
        cupruta = cupruta + "/src/compiler/parser/Sintax.cup";
        String[] rutaS = {"-parser", "Sintax", cupruta};
        generar(jflex, rutaS);
        /*try{
            //Path to file
            String archivo = ruta;
            Reader lector = new BufferedReader(new FileReader(archivo));
            // Este lexer debe ser el nuevo, que se conecte con cup.
            Sintax analisis = new Sintax(new LexerCup(lector));
            try {
                analisis.parse();   
                System.out.println(graficarNodo(analisis.padre));
                //graficar(analisis.padre);
            }
            catch (Exception e){
                System.out.println(e);
            }
            
            
        }catch (FileNotFoundException ex) {
            System.out.println(ex);
        }*/
            
    }
public static void generar(String rutalexer, String[] rutaSintax) throws IOException, Exception{
        File archivo = new File(rutalexer);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaSintax); 
    }
public static String graficarNodo(Nodo nodo){
        String cadena = "";
        if (nodo != null){
            //System.out.println("Este es el padre: " + nodo.getNombre());
            //System.out.println("Estos son los hijos: " + nodo.getHijos());
            for(Nodo hijos : nodo.getHijos())
            {
                if (hijos != null){
                    cadena += "\"Numero: " + nodo.getNumNodo() + " Nombre: " + nodo.getNombre() + " Valor: -> " + nodo.getValor() + "\" Hijo: ->\"" + hijos.getNumNodo() + " Nombre hijo: " + hijos.getNombre() + " Valor hijo: -> " + hijos.getValor() + "\"\n";
                    cadena += graficarNodo(hijos);
                }
                else{
                    cadena += graficarNodo(hijos);
                }

            }
        }
        return cadena;
    }
public static void graficar(Nodo raiz){
        FileWriter archivo = null;
        PrintWriter pw = null;
        String cadena = graficarNodo(raiz);
        
        try{
            archivo = new FileWriter("arbol.dot");
            pw = new PrintWriter(archivo);
            pw.println("digraph G {node[shape=box, style=filled, color=blanchedalmond]; edge[color=chocolate3];rankdir=UD \n");
            pw.println(cadena);
            pw.println("\n}");
            archivo.close();
        }catch (IOException e) {
            System.out.println(e +" 1");
        }
        
        try {
            String cmd = "dot -Tpng arbol.dot -o arbol.png";
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ioe) {
            System.out.println(ioe +" 2");
        }
        
    }

    
}
