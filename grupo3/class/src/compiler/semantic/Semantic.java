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

/**
 *
 * @author p1jav
 */
public class Semantic {
    public static HashMap<String, ArrayList<ValoresTabla>> Tabla = new HashMap<String, ArrayList<ValoresTabla>>();
    public static boolean error = false;
    public static String error_message = "";
    public static String tabla = "";
    public static void pushScope(int scope){
        if (Tabla.containsKey("Scope: " + scope)){

        }
        else{
            Tabla.put("Scope: " + scope, null);
        }
        
    }  

    public static void popScope(int scope){
        String i = "Scope: " + scope;
        // System.out.println(i);
        tabla = tabla + i;
        tabla = tabla + ("\nVar declarations: \n");
        for (int x = 0; x < Tabla.get(i).size(); x++) {
            tabla = tabla + ("------- \n");
            for (String y : Tabla.get(i).get(x).data.keySet()) {
                tabla = tabla + ( "   "+y + ": " + Tabla.get(i).get(x).data.get(y) + "\n");
            }
        }
        tabla = tabla + ("\n----- fin: \n");
        Tabla.remove("Scope: " + scope);
    }

    public static void insertSymbol(VarDeclaration nuevoSymbol, int scope){
        HashMap<String, String> nuevo_symbol = new HashMap<String, String>();
        nuevo_symbol.put("Indentifier",nuevoSymbol.getidentifier());
        nuevo_symbol.put("Type",nuevoSymbol.gettype());
        nuevo_symbol.put("Location",nuevoSymbol.getlocation());
        if (Tabla.get("Scope: " + scope) == null){
            //System.out.println("Entre porque no hay lista");
            ValoresTabla data = new ValoresTabla();
            data.Adddata(nuevo_symbol);
            ArrayList<ValoresTabla> lista = new ArrayList<ValoresTabla>();
            lista.add(data);
            Tabla.replace("Scope: " + scope, lista);
        }
        else{
            //System.out.println("Ya hay lista, solo agrego");
            ValoresTabla data = new ValoresTabla();
            data.Adddata(nuevo_symbol);
            Tabla.get("Scope: " + scope).add(data);
        }
        
    }

    public static boolean lookup(VarUsage symbol,int scope){
        int resultado = 2;
        // 0 error de casteo, retorna false
        // 1 lo encontro, retorna true
        // 2 no lo ha encontrado. igual retorno un false
        boolean resultado_r = false;
        // recorrer el hasmap hasta ver si esta o no la variable.
        while(resultado == 2 && scope != 0){
            //System.out.println("Scope, " + scope);
            for (int x = 0; x < Tabla.get("Scope: " + scope).size(); x++) {
                // for (String y : Tabla.get("Scope: " + scope).get(x).data.keySet()) {
                //     System.out.println( "   "+y + ": " + Tabla.get("Scope: " + scope).get(x).data.get(y));
                // }
                if (Tabla.get("Scope: " + scope).get(x).data.containsValue(symbol.getidentifier())){
                    //System.out.println("Si existe, " + symbol.getidentifier());
                    try{
                        if (Integer.valueOf(Tabla.get("Scope: " + scope).get(x).data.get("Location")) < Integer.valueOf(symbol.getlocation())){
                            if (Tabla.get("Scope: " + scope).get(x).data.containsValue("int")){
                                try{
                                    //System.out.println("si existe en el scope, " + scope + ", el simbolo: " + symbol.getidentifier());
                                    Integer.valueOf(symbol.getvalue());
                                    resultado = 1;
                                    resultado_r = true;
                                    break;
                                }
                                catch(NumberFormatException ex){
                                    resultado = 0;
                                    resultado_r = false;
                                    break;
                                }
                            }
                        }
                    }
                    catch(NumberFormatException ex){
                        // no puede castear a int la location
                        resultado = 0;
                        resultado_r = false;
                        break;
                    }
                    
                }
                else{
                    resultado = 2;
                }
            }
            scope = scope - 1;
        }
        return resultado_r;
    }
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
                System.out.println(graficarNodo(analisis.padre));
                //graficar(analisis.padre);
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
}
class ValoresTabla{
    public HashMap<String, String> data;

    public void Adddata(HashMap<String, String> valor){
        this.data = valor;
    }
}
