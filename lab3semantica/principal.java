import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;  
import com.fasterxml.jackson.databind.ObjectMapper; 

public class principal {  
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

    public static void creartabla(Block blocke, int scope){
        if (blocke.varDeclaration == null){
           //System.out.println("es null el blocke");
        }
        else{
            if (error == false){
                // System.out.println("blocke no es null");
                // System.out.println("(pushScope), " + scope);
                pushScope(scope);
                 // creo un scope (pushScope)
                if (blocke.varDeclaration.isEmpty() == false){
                    // recorro varDeclaration.
                    //System.out.println("Si tiene varDeclaration");
                    for (int i = 0; i < blocke.varDeclaration.size(); i++) {
                        // meto las variables (insertSymbol)
                        insertSymbol(blocke.varDeclaration.get(i), scope);
                    }
                }
                if (blocke.varUsage.isEmpty() == false){
                    // recorro varUsage.
                    // utilizo lookup
                    // verifico si el resultado es true o false.
                    //System.out.println("Si tiene varUsage, en scope: " + scope);
                    for (int i = 0; i < blocke.varUsage.size(); i++) {
                        if(error == false){
                            if (lookup(blocke.varUsage.get(i), scope) != true){
                                error_message = "Se encontró un en: " + blocke.varUsage.get(i).getidentifier() +
                                                    ", con valor: " + blocke.varUsage.get(i).getvalue() + ", en location: " +
                                                    blocke.varUsage.get(i).getlocation() + " scope: " + scope;
                                error = true;
                            }
                            else{
                                //System.out.println("Todo bien");
                            }
                        }
                        
                    }
                }
                if (blocke.block.isEmpty() == false && error == false){
                    // recorro block. 
                    // llamo a la funcion nuevamente para 
                    // continuar con los demas blockes
                    // al regresar, hago popScope
                    //System.out.println("Si tiene mas blockes");
                    for (int i = 0; i < blocke.block.size(); i++) {
                        creartabla(blocke.block.get(i), (scope+1));
                        
                    }
                    popScope(scope);
                    
                }
            }
            else{

            }
            
        }

    }
      
    // main() method start  
    public static void main(String args[]){       
        ObjectMapper mapper = new ObjectMapper();  
        try{ 
            Root ruta = mapper.readValue(new File("prueba.json"), Root.class);  
            creartabla(ruta.block, 1);
            if (error == false){
                // System.out.println("\n\n\n TABLA: \n");
                // for (String i : Tabla.keySet()) {
                //     System.out.println(i);
                //     System.out.println("Var declarations: \n");
                //     for (int x = 0; x < Tabla.get(i).size(); x++) {
                //         System.out.println("-------");
                //         for (String y : Tabla.get(i).get(x).data.keySet()) {
                //             System.out.println( "   "+y + ": " + Tabla.get(i).get(x).data.get(y));
                //         }
                //     }
                // }
                System.out.println("\n\n\n TABLA: \n");
                System.out.println(tabla);
                // for (String i : Tabla.keySet()) {
                //     tabla = tabla + i;
                //     tabla = tabla + ("\nVar declarations: \n");
                //     for (int x = 0; x < Tabla.get(i).size(); x++) {
                //         tabla = tabla + ("------- \n");
                //         for (String y : Tabla.get(i).get(x).data.keySet()) {
                //             tabla = tabla + ( "   "+y + ": " + Tabla.get(i).get(x).data.get(y) + "\n");
                //         }
                //     }
                // }
                // tabla = tabla + ("\n----- fin: \n");
            }
            else{
                System.out.println(error_message);
            }
            
        }catch (JsonParseException e) {  
            e.printStackTrace();  
        }catch (JsonMappingException e) {  
            e.printStackTrace();   
        }catch (IOException e) {  
            e.printStackTrace();   
        }  
    }  
}   


class Block{
    public ArrayList<VarDeclaration> varDeclaration;
    public ArrayList<VarUsage> varUsage;
    public ArrayList<Block> block;
}

class Root{
    public Block block;
}

class VarDeclaration{
    public String type;
    public String identifier;
    public String location;

    public String gettype(){
        return this.type;
    }
    public String getidentifier(){
        return this.identifier;
    }
    public String getlocation(){
        return this.location;
    }
}

class VarUsage{
    public String identifier;
    public String value;
    public String location;

    public String getidentifier(){
        return this.identifier;
    }
    public String getvalue(){
        return this.value;
    }
    public String getlocation(){
        return this.location;
    }
}

class ValoresTabla{
    public HashMap<String, String> data;

    public void Adddata(HashMap<String, String> valor){
        this.data = valor;
    }
}