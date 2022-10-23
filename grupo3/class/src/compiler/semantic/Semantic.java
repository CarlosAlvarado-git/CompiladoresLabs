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
    public static HashMap<String, String> TYPE = new HashMap<String, String>();
    public static Nodo type = new Nodo("type");
    public static int scope_global = 0;
    public static Nodo nombre_loock_up ;
    
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
        for (int x = 0; x < Tabla.get(i).size(); x++) {
            tabla = tabla + ("------- \n");
            for (String y : Tabla.get(i).get(x).data.keySet()) {
                tabla = tabla + ( "   "+y + ": " + Tabla.get(i).get(x).data.get(y) + "\n");
            }
        }
        tabla = tabla + ("\n----- fin: \n");
        Tabla.remove("Scope: " + scope);
         System.out.println("Borre el:  " + i);
    }

    public static void insertSymbol(Nodo nuevoSymbol, int scope){
        if ("0".equals(TYPE.get("Espero")) == true){
            HashMap<String, String> nuevo_symbol = new HashMap<>();
            nuevo_symbol.put("Indentifier","");
            nuevo_symbol.put("Type",nuevoSymbol.getValor());
            nuevo_symbol.put("Scope",scope + "");
            nuevo_symbol.put("Location","");
            nuevo_symbol.put("Memoria", "");
            if (Tabla.get("Scope: " + scope) == null){
            System.out.println("Entre porque no hay lista, scope: " + scope);
            ValoresTabla data = new ValoresTabla();
            data.Adddata(nuevo_symbol);
            ArrayList<ValoresTabla> lista = new ArrayList<>();
            lista.add(data);
            Tabla.replace("Scope: " + scope, lista);
            }
            else{
                System.out.println("Ya hay lista, solo agrego, scope: " + scope);
                ValoresTabla data = new ValoresTabla();
                data.Adddata(nuevo_symbol);
                Tabla.get("Scope: " + scope).add(data);
            }
        }
        else{
            if("1".equals(TYPE.get("Espero_corchete"))){
                int ultimo = Tabla.get("Scope: " + scope).size() - 1;
                Tabla.get("Scope: " + scope).get(ultimo).data.replace("Memoria", nuevoSymbol.getValor());
            }
            else{
            int ultimo = Tabla.get("Scope: " + scope).size() - 1;
            Tabla.get("Scope: " + scope).get(ultimo).data.replace("Indentifier", nuevoSymbol.getIdentifier());
            Tabla.get("Scope: " + scope).get(ultimo).data.replace("Location", nuevoSymbol.getLocation() + "");
            }
        }
        
        
        
    }

    public static boolean lookup(Nodo symbol,int scope){
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
           
                if (Tabla.get("Scope: " + scope).get(x).data.containsValue(symbol.getIdentifier())){
                    //System.out.println("Si existe, " + symbol.getidentifier());
                    try{
                        if (Integer.valueOf(Tabla.get("Scope: " + scope).get(x).data.get("Location")) < Integer.valueOf(symbol.getLocation())){
                            //if (Tabla.get("Scope: " + scope).get(x).data.containsValue("int")){
                                try{
                                    //System.out.println("si existe en el scope, " + scope + ", el simbolo: " + symbol.getidentifier());
                                    
                                    String.valueOf(symbol.getIdentifier());
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
            scope = scope - 1;
        }
        return resultado_r;
    }
    
    
    public static void recorrerTabla(Nodo nodo){
        
        if (scope_global == 1){
            pushScope(scope_global);
        } 
        for(Nodo hijos : nodo.getHijos())
        {
            if (hijos != null){
                switch (hijos.getNombre()) {
                    case "type":
                        System.out.println("-------- type   " + "Padre: " + nodo.getNombre() + " soy: " + hijos.getNombre());
                        insertSymbol(hijos.getHijos().get(0), scope_global);
                        TYPE.replace("Espero","1");
                        TYPE.replace("Type", hijos.getHijos().get(0).getValor());
                        recorrerTabla(hijos);
                        System.out.println("Regreso de recorrerTabla, caso de type, caso de id, scope es: " + scope_global);
                        break; 
                    case "void":
                    System.out.println("-------- void   " + "Padre: " + nodo.getNombre() + " soy: " + hijos.getNombre());
                    insertSymbol(hijos, scope_global);
                    TYPE.replace("Espero","1");
                    //TYPE.replace("Type", hijos.getHijos().get(0).getValor());
                    recorrerTabla(hijos);
                    System.out.println("Regreso de recorrerTabla, caso de void, caso de id, scope es: " + scope_global);
                    break; 
                    case "id":
                        if (nodo.getNombre().equals("location") == false && nodo.getNombre().equals("method_name") == false){
                            System.out.println("-------- id   " + "Padre: " + nodo.getNombre() + " soy: " + hijos.getNombre() + ", el scope: " +scope_global);
                            insertSymbol(hijos, scope_global);
                            TYPE.replace("Espero","0");
                            
                        }
                        
                        if(nodo.getNombre().equals("location") == true){
                            nombre_loock_up = hijos;
                        }
                        /*
                        else {
                            // lookup
                            System.out.println("-------- id/lookup   " + "Padre: " + nodo.getNombre() + " soy: " + hijos.getNombre()+ ", el scope: " +scope_global);
                        }*/
                        recorrerTabla(hijos);
                        System.out.println("Regreso de recorrerTabla, caso de id, scope es: " + scope_global);
                        break;
                    case "Corche_A":
                        if(nodo.getNombre().equals("field_name") == true){
                            TYPE.replace("Espero_corchete","1");
                            recorrerTabla(hijos);
                        }
                        else{
                            
                            recorrerTabla(hijos);
                        }
                        break;
                    case "int_literal":
                        if(nodo.getNombre().equals("field_name") == true){
                            insertSymbol(hijos.getHijos().get(0),scope_global);
                            TYPE.replace("Espero_corchete","0");
                            recorrerTabla(hijos);
                        }
                        else{
                            recorrerTabla(hijos);
                        }
                        break;
                    case "block":
                        
                            if (nodo.getNombre().equals("statement")) {
                                    System.out.println("-------- Soy el block | mi padre es: " + nodo.getNombre() + "cree un nuevo scope: " + (scope_global));
                                    scope_global = scope_global +1;
                                    pushScope(scope_global);
                                    recorrerTabla(hijos);
                            }
                            else{
                                recorrerTabla(hijos);
                            }
                        
                            
                            
                            System.out.println("Regreso de recorrerTabla, caso de block, scope es: " + scope_global);
                        break;
                    case "Llave_C":
                            System.out.println("-------- Soy el { | mi padre es: " + nodo.getNombre() + "borré el scope: " + (scope_global));
                            popScope(scope_global);
                            TYPE.replace("Espero","0");
                            TYPE.replace("Type", "");
                            type.setValor("");
                            //recorrerTabla(hijos, scope);
                            scope_global = scope_global - 1;
                            System.out.println("Regreso de recorrerTabla, caso de llave c, scope es: " + scope_global);
                        break;
                    case "Punto_coma":
                        System.out.println("-------- Punto_coma   " + "Padre: " + nodo.getNombre() + " soy: " + hijos.getNombre());
                        TYPE.replace("Espero","0");
                        TYPE.replace("Type", "");
                        type.setValor("");
                        recorrerTabla(hijos);
                        System.out.println("Regreso de recorrerTabla, caso de punto y coma, scope es: " + scope_global);
                        break;
                    case "assign_op":
                        System.out.println("=============look_up==============");
                        System.out.println(lookup(nombre_loock_up, scope_global));
                        nombre_loock_up = hijos;
                        //Tenemos que llamar a la funcion look_up y ver si el id ya fue declarado.
                        
                    default:
                        if ("0".equals(TYPE.get("Espero")) && ("".equals(TYPE.get("Type")) == false) && (nodo.getNombre().equals("field decl") == true || nodo.getNombre().equals("field_decl_coma_field") == true || nodo.getNombre().equals("var_decl") == true || nodo.getNombre().equals("var_decl_coma_id") == true)){
                            System.out.println("-------- Espero: 0 Type: no vacio:   " + nodo.getNombre() + " soy: " + hijos.getNombre());
                            type.setValor(TYPE.get("Type"));
                            insertSymbol(type,scope_global);
                            TYPE.replace("Espero","1");
                            recorrerTabla(hijos);
                            System.out.println("Regreso de recorrerTabla, caso 0 y type no vacio, scope es: " + scope_global);
                        }
                        /*else if ("1".equals(TYPE.get("Espero")) && ("".equals(TYPE.get("Type")) == false) && (nodo.getNombre().equals("method_decl") == true)){
                            System.out.println("-------- Espero: 1 Type: no vacio:   " + nodo.getNombre() + " soy: " + hijos.getNombre());
                            insertSymbol(hijos,scope);
                            TYPE.replace("Espero","0");
                            TYPE.replace("Type", "");
                            type.setValor("");
                            }*/
                        else if ( hijos.getNombre().equals("LEFT_PAR") && nodo.getNombre().equals("method_decl")){
                            System.out.println("-------- Soy el parentesis (:  | mi padre es: " + nodo.getNombre() + " cree un nuevo scope: " + (scope_global + 1));
                            pushScope(scope_global+1);
                            recorrerTabla(hijos);
                            scope_global = scope_global + 1;
                            System.out.println("Regreso de recorrerTabla, caso parentesisi, scope es: " + scope_global);
                        }
                        else
                        {System.out.println("-------- ningun caso: soy:  "+ hijos.getNombre() + " mi padre: " + nodo.getNombre());
                        recorrerTabla(hijos);
                        System.out.println("Regreso de recorrerTabla, no cumpli ningun caso, scope es: " + scope_global);
                                }
                        break;
                }
            }

        }// si soy block y soy hijo de statment, creo un nuevo scope. // entonces, cuando sea llave_c popscope()
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
                TYPE.put("Espero","0");
                TYPE.put("Type","");
                TYPE.put("Espero_corchete","0");
                System.out.println(graficarNodo(analisis.padre));
                scope_global = 1;
                recorrerTabla(analisis.padre);
                System.out.println("-------- Aquí viene la tabla de símbolo");
                //System.out.println(tabla);
                
                /*
                for (String i : Tabla.keySet()) {
                    System.out.println(i);
                    System.out.println("Var declarations: \n");
                    for (int x = 0; x < Tabla.get(i).size(); x++) {
                        System.out.println("-------");
                        for (String y : Tabla.get(i).get(x).data.keySet()) {
                            System.out.println( "   "+y + ": " + Tabla.get(i).get(x).data.get(y));
                        }
                    }
                }*/
                System.out.println(tabla);
                
                
                Tabla.clear();
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
