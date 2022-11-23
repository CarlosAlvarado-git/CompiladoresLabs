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
    public static HashMap<String, ArrayList<ValoresTabla>> Tabla = new HashMap<String, ArrayList<ValoresTabla>>();
    public static String tabla = "";
    public static int scope_global = 0;
    
    
    public static void pushScope(int scope){
        if (Tabla.containsKey("Scope: " + scope)){

        }
        else{
            Tabla.put("Scope: " + scope, null);
        }
        
    }  

    public static void popScope(int scope){
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
    public static void insertSymbol(Nodo nuevoSymbol, int scope){
        
    }
    
        public static boolean lookup(Nodo symbol,int scope, int vengodeassig){
        int resultado = 2;
        // 0 error de casteo, retorna false
        // 1 lo encontro, retorna true
        // 2 no lo ha encontrado. igual retorno un false
        boolean resultado_r = false;
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
                                    resultado_r = true;
                                    break;
                                }
                                catch(NumberFormatException ex){
                                    resultado = 0;
                                    resultado_r = false;
                                    break;
                                }
                            //}
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
            
            
            }
            scope = scope - 1;
            
        }
        return resultado_r;
    }
    
    
    
    
    
    
    
    
}
class ValoresTabla{
    public HashMap<String, String> data;

    public void Adddata(HashMap<String, String> valor){
        this.data = valor;
    }
}