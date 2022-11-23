/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compiler.semantic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author carlosalvarado
 */
public class Semantic_fun {
    public static HashMap<String, ArrayList<ValoresTabla_fun>> Tabla = new HashMap<String, ArrayList<ValoresTabla_fun>>();
    public static HashMap<String, ArrayList<ValoresTabla_fun>> Tabla_m = new HashMap<String, ArrayList<ValoresTabla_fun>>();
    public static String tabla = "";
    public static String tabla_m= "";
    public static int scope_global = 0;
    public static HashMap<String, String> BANDERAS = new HashMap<String, String>();
        
    public Semantic_fun(){
            BANDERAS.put("Type", "");
            BANDERAS.put("Error_repeticion", "");
            Tabla_m.put("DATA", null);
    }
    
    public void pushScope(int scope){
        if (Tabla.containsKey("Scope: " + scope)){

        }
        else{
            Tabla.put("Scope: " + scope, null);
        }
        
    }  
    
    public String tabla_print(){
        Tabla.clear();
        String a = tabla;
        tabla = "";
        return a;
        
    }
    public String tabla_print_m(){
        Tabla_m.clear();
        String a = tabla_m;
        tabla_m = "";
        return a;
        
    }

    public void popScope(int scope){
        String i = "Scope: " + scope;
        
        tabla = tabla + i;
        tabla = tabla + ("\nVar declarations: \n");
        if (Tabla.get(i) != null){
            
        
        for (int x = 0; x < Tabla.get(i).size(); x++) {
            tabla = tabla + ("------- \n");
            for (String y : Tabla.get(i).get(x).data.keySet()) {
                tabla = tabla + ( "   "+y + ": " + Tabla.get(i).get(x).data.get(y) + "\n");
            }
        }
        }
        tabla = tabla + ("\n----- fin: \n");
        Tabla.remove("Scope: " + scope);
         System.out.println("Borre el:  " + i);
    }
    public void pop_m(){
        String i = "DATA";
        
        tabla_m = tabla_m + i;
        tabla_m = tabla_m + ("\nVar declarations: \n");
        if (Tabla_m.get(i) != null){
            
        
        for (int x = 0; x < Tabla_m.get(i).size(); x++) {
            tabla_m = tabla_m + ("------- \n");
            for (String y : Tabla_m.get(i).get(x).data.keySet()) {
                tabla_m = tabla_m + ( "   "+y + ": " + Tabla_m.get(i).get(x).data.get(y) + "\n");
            }
        }
        }
        tabla_m = tabla_m + ("\n----- fin: \n");
        Tabla_m.remove("DATA");
        System.out.println("Borre el:  " + i);
    }
    public void insertSymbol(Nodo nuevoSymbol, int scope){
        HashMap<String, String> nuevo_symbol = new HashMap<>();
        nuevo_symbol.put("llamada", nuevoSymbol.getllamada());
        nuevo_symbol.put("type", nuevoSymbol.gettype());
        nuevo_symbol.put("id", nuevoSymbol.getIdentifier());
        nuevo_symbol.put("location", "" + nuevoSymbol.getLocation());
        nuevo_symbol.put("scope", "" + nuevoSymbol.getscope());
        nuevo_symbol.put("memoria", "" + nuevoSymbol.getmemoria());
        
        if (Tabla.get("Scope: " + scope) == null){
                System.out.println("Entre porque no hay lista, scope: " + scope);
                ValoresTabla_fun data = new ValoresTabla_fun();
                data.Adddata(nuevo_symbol);
                ArrayList<ValoresTabla_fun> lista = new ArrayList<>();
                lista.add(data);
                Tabla.replace("Scope: " + scope, lista);
        }
        else{
            System.out.println("Ya hay lista, solo agrego, scope: " + scope);
            ValoresTabla_fun data = new ValoresTabla_fun();
            data.Adddata(nuevo_symbol);
            Tabla.get("Scope: " + scope).add(data);
        }
        
    }
    public void insertSymbol_m(Nodo nuevoSymbol){
        HashMap<String, String> nuevo_symbol = new HashMap<>();
        nuevo_symbol.put("llamada", nuevoSymbol.getllamada());
        nuevo_symbol.put("type", nuevoSymbol.gettype());
        nuevo_symbol.put("id", nuevoSymbol.getIdentifier());
        nuevo_symbol.put("location", "" + nuevoSymbol.getLocation());
        nuevo_symbol.put("scope", "" + nuevoSymbol.getscope());
        nuevo_symbol.put("memoria", "" + nuevoSymbol.getmemoria());
        nuevo_symbol.put("Funcion", nuevoSymbol.getfuncion());
        
        
        if (Tabla_m.get("DATA") == null){
                System.out.println("Entre porque no hay lista");
                ValoresTabla_fun data = new ValoresTabla_fun();
                data.Adddata(nuevo_symbol);
                ArrayList<ValoresTabla_fun> lista = new ArrayList<>();
                lista.add(data);
                Tabla_m.replace("DATA", lista);
        }
        else{
            System.out.println("Ya hay lista, solo agrego");
            ValoresTabla_fun data = new ValoresTabla_fun();
            data.Adddata(nuevo_symbol);
            Tabla_m.get("DATA").add(data);
        }
        
    }
    
    
    public int lookup(Nodo symbol,int scope){
        int resultado = 2;
        // 0 error de casteo, retorna false
        // 1 lo encontro, retorna true
        // 2 no lo ha encontrado. igual retorno un false
        int resultado_r = 2;
        // recorrer el hasmap hasta ver si esta o no la variable.
        while(resultado == 2 && scope != 0){
            if (Tabla.get("Scope: " + scope) != null){
            for (int x = 0; x < Tabla.get("Scope: " + scope).size(); x++) {
                System.out.println("Entre");
                for (String y : Tabla.get("Scope: " + scope).get(x).data.keySet()) {
                     System.out.println( "   "+y + ": " + Tabla.get("Scope: " + scope).get(x).data.get(y));
                 }
                System.out.println("Soy: " + symbol.getIdentifier());
           
                if (Tabla.get("Scope: " + scope).get(x).data.containsValue(symbol.getIdentifier())){
                    System.out.println("Si existe, " + symbol.getIdentifier());
                    try{
                        if (Integer.valueOf(Tabla.get("Scope: " + scope).get(x).data.get("Location")) < Integer.valueOf(symbol.getLocation())){
                            //if (Tabla.get("Scope: " + scope).get(x).data.containsValue("int")){
                                try{
                                    
                                    resultado = 1;
                                    resultado_r = 1;
                                    break;
                                }
                                catch(NumberFormatException ex){
                                    resultado = 0;
                                    resultado_r = 0;
                                    break;
                                }
                            //}
                        }
                    }
                    catch(NumberFormatException ex){
                        // no puede castear a int la location
                        resultado = 0;
                        resultado_r = 0;
                        break;
                    }
                    
                }
                else{
                    resultado = 2;
                    resultado_r = 2;
                }
            }
            
            
            }
            scope = scope - 1;
            
        }
        return resultado_r;
    } 
}
class ValoresTabla_fun{
    public HashMap<String, String> data;

    public void Adddata(HashMap<String, String> valor){
        this.data = valor;
    }
}