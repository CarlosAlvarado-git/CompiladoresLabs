/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compiler.irt;

import java.util.ArrayList;

/**
 *
 * @author carlosalvarado
 */
public class Nodo_irt {
    public Operacion op;
    public Condicion co;
    public Asignacion Asig;
    public IF_nodo if_nodo;
    public FOR_nodo for_nodo;
    public method_call method_call_nodo;
    public method_decl method_nodo;
    public parametros parametros_nodo;
    public Negacion negacion_nodo;
    private String Nombre;
    private ELSE_nodo else_nodo;
    private END_IF_nodo end_if;
    private Continue_nodo conti_node;
    private Creacion_var crear_var;
    public Nodo_irt(String Nombre){
        this.Nombre = Nombre;
    
    }
    public String getNombre(){
        return this.Nombre;
        }
       public void Crear_variable(String id, String memoria){
           this.crear_var = new Creacion_var(id, memoria);
       }
       public String Variable(){
           String result = "";
           result = this.crear_var.getCreacion();
           return result;
        }
       public void Crear_operacion(String Oper, String Var1, String Var2){
           this.op = new Operacion(Oper, Var1, Var2);
        }
       public String Operador(){
           String resultado =  this.op.getOperacion();
           return resultado; 
        }
       public void Crear_condicion(String Oper, String Var1, String Var2){
           this.co = new Condicion(Oper, Var1, Var2);
        }
       public String Condicion(){
           String resultado =  this.co.getCondicion();
           return resultado; 
        }
       public void Crear_Asignacion(String Oper, String Valor, String result){
           this.Asig = new Asignacion(Oper, Valor, result);
        }
       public String Asignacion(){
           String resultado =  this.Asig.getAsignacion();
           return resultado; 
        }
       public void Crear_IF(String ifs){ 
            this.if_nodo = new IF_nodo(ifs);
       }
       public String IF_C(){
           String resultado = this.if_nodo.getIf();
           return resultado;
        }
       public void Crear_FOR(String ifs){ 
            this.for_nodo = new FOR_nodo(ifs);
       }
       public String FOR_C(){
           String resultado = this.for_nodo.getFor();
           return resultado;
        }
       public void Crear_Continue(Nodo_irt ope, Nodo_irt jumpe){ 
            this.conti_node = new Continue_nodo(ope, jumpe);
       }
       public String Continue_c(){
           String resultado = this.conti_node.getContinue_nodo();
           return resultado;
        }
       public void Crear_ELSE(String els){ 
            this.else_nodo = new ELSE_nodo(els);
       }
       public String ELSE_C(){
           String resultado = this.else_nodo.getELSE();
           return resultado;
        }
       public void Crear_END_IF(String end){ 
            this.end_if = new END_IF_nodo(end);
       }
       public String END_IF_C(){
           String resultado = this.end_if.getEND_IF();
           return resultado;
        }
       
       public void Crear_method(String f, String param){
           this.method_call_nodo = new method_call(f, param); 
       }
       public String Metodo(){
           String resultado = this.method_call_nodo.getMethod();
           return resultado;
       }
       public void Crear_metodo(String f, String param){
           this.method_nodo = new method_decl(f, param); 
       }
       public String Metodo_(){
           String resultado = this.method_nodo.getMethod();
           return resultado;
       }
       public void Crear_parametros(){
           this.parametros_nodo = new parametros();
        }
       public String getParametros(){
           String resultado = "";
           //System.out.println("Desde getParametros: "+ this.parametros_nodo);
            if (this.parametros_nodo != null){
                   //System.out.println("ENTRE GETPARAMETROS");
                 resultado = this.parametros_nodo.getParame();}
            else 
                 resultado = "";
            return resultado;
        }
       public void Crear_negacion(String v){
           this.negacion_nodo = new Negacion(v);
        }
       public String getNegacion(){
           String resultado = this.negacion_nodo.getNegacion();
           return resultado;
       }
       
       
    
}

class Operacion{
      private String Oper;
      private String Var1;
      private String Var2;
      private String Registro;
      public Operacion(String Oper, String Var1, String Var2){
            this.Oper = Oper;
            this.Var1 = Var1;
            this.Var2 =  Var2;
      }
      public void setRegistro(String R){
          this.Registro = R;
        }
      public String getOper(){
          return this.Oper;
        }
    public String getVar1(){
          return this.Var1;
        }
    public String getVar2(){
          return this.Var2;
        }
    public String getRegistro(){
          return this.Registro;
        }
    public String getOperacion(){
           String resultado = "\n -------- \n";
           resultado = resultado+ " Operador: " + this.getOper() + ". \n";
           resultado = resultado+ " Var 1: " + this.getVar1() + ". \n";
           resultado = resultado+ " Var 2: " + this.getVar2() + ". \n";
           if (this.getRegistro().indexOf('$') != -1)
            resultado = resultado+ " Registro: " + this.getRegistro() + ". \n";
           else
            resultado = resultado+ " Variable: " + this.getRegistro() + ". \n";
           return resultado; 
        }
}
class Condicion{
      private String Oper;
      private String Var1;
      private String Var2;
      private String Registro;
      public Condicion(String Oper, String Var1, String Var2){
            this.Oper = Oper;
            this.Var1 = Var1;
            this.Var2 =  Var2;
      }
      public void setRegistro(String R){
          this.Registro = R;
        }
      public String getOper(){
          return this.Oper;
        }
    public String getVar1(){
          return this.Var1;
        }
    public String getVar2(){
          return this.Var2;
        }
    public String getRegistro(){
          return this.Registro;
        }
    public String getCondicion(){
           String resultado = "\n -------- \n";
           resultado = resultado+ " Operador: " + this.getOper() + ". \n";
           resultado = resultado+ " Var 1: " + this.getVar1() + ". \n";
           resultado = resultado+ " Var 2: " + this.getVar2() + ". \n";
           resultado = resultado+ " Registro: " + this.getRegistro() + ". \n";
           return resultado; 
        }
}

class Creacion_var{
    private String id;
    private String memoria;
    public Creacion_var(String id, String memoria){
            this.id = id;
            this.memoria = memoria;
        }

    public String getCreacion(){
        String result = "";
        result = result + "id: " + this.id + "\n";
        result = result + "memora: " + this.memoria + "\n";
        return result;
        }


}


class Asignacion{
    private String Oper;
    private String Valor;
    private String VResultado;
    public Asignacion(String Oper, String Valor, String result){
            this.Oper = Oper;
            this.Valor = Valor;
            this.VResultado = result;
      }
    public String getOper(){
          return this.Oper;
        }
    public String getValor(){
          return this.Valor;
        }
    public String getVResultado(){
          return this.VResultado;
        }
    public String getAsignacion(){
           String resultado = "\n -------- \n";
           resultado = resultado+ " Operador: " + this.getOper() + ". \n";
           resultado = resultado+ " Var 1: " + this.getValor() + ". \n";
           resultado = resultado+ " VResultado: " + this.getVResultado() + ". \n";
           return resultado; 
        }
}
class IF_nodo{
    private String tag_if;
    private String condicione;
    public IF_nodo(String tag){
        this.tag_if = tag;
    
        }
    // funcion que recibe condicion.
    public void getCondicion(String con){
        this.condicione = con;
        }
        
    public String getIf(){
        String result = "";
            result = result + "tag: "  + this.tag_if + "\n ";
          //System.out.println("Desde getMethod: "+ this.parametros);
          if (this.condicione != null){
            result = result + "Registro condicion resultado: " + this.condicione + "\n";
          }
          return result;
        }
    
}
class ELSE_nodo{
    private String tag_else;
    public ELSE_nodo(String tag){
        this.tag_else = tag;
    
        }
        
    public String getELSE(){
        String result = "";
            result = result + "tag: "  + this.tag_else + "\n ";
          
          return result;
        }
    
}
class END_IF_nodo{
    private String tag_end;
    public END_IF_nodo(String tag){
        this.tag_end = tag;
    
        }
        
    public String getEND_IF(){
        String result = "";
            result = result + "tag: "  + this.tag_end + "\n ";
          
          return result;
        }
    
}
class FOR_nodo{
    private String tag_for;
    public FOR_nodo(String tf){
        this.tag_for = tf;
    
        }
    public String getFor(){
        String result = "";
            result = result + "tag: "  + this.tag_for + "\n ";
          return result;
        }
}
// ESTE lo usamos con los method deccl, pero lo pasaremos a los method call
class method_call{
      private String funcion;
      private String parametros;
      public method_call(String f, String param){
          this.funcion = f;
          this.parametros = param;
      
        }
      // print method_call
      public String getMethod(){
          String result = "";
          result = result + "tag: "  + this.funcion + "\n ";
          //System.out.println("Desde getMethod: "+ this.parametros);
          if (this.parametros != null){
            result = result + " push parametros: " + this.parametros + "\n";
          }
          return result;
      }
}
// para los method decla, hacemos lo mismo, PERO ! YA VEMOS LA MEMORIA ! 
class method_decl{
      private String funcion;
      private String parametros;
      private int memoria;
      public method_decl(String f, String param){
          this.funcion = f;
          this.parametros = param;
      
        }
      public void getMemoria(int m){
          this.memoria = m;
        }
      
      // print method_call
      public String getMethod(){
          String result = "";
          result = result + "tag: "  + this.funcion + "\n ";
          //System.out.println("Desde getMethod: "+ this.parametros);
          if (this.parametros != null){
            result = result + "parametros: " + this.parametros + "\n";
          }
          return result;
      }
}
class parametros{
    private ArrayList<String> parame = new ArrayList<>();
    public parametros(){
        
        }
    
    public void addParame(String dato){
        if(this.parame != null){
            this.parame.add(dato);
        }
    }
    
    public String getParame(){
        String result = "(";
        if(this.parame != null){
            for (int i = 0; i < this.parame.size(); i++) {
                if (this.parame.size() > 1 && i != (this.parame.size() - 1))
                    result = result + this.parame.get(i) + ",";
                else
                   result = result + this.parame.get(i); 
              }
            result = result + ")";
            
        }
        return result;
    
    }
    public void Clear_parame(){
            this.parame.clear();
        }
}
   
class Negacion{
    private String valor;
    private String VRegistro;
    
    public Negacion(String v){
            this.valor = v;
        }
    public void setRegistro(String R){
          this.VRegistro = R;
        }
    public String getNegacion(){
           String r = "\n";
           r = r + "Valor: " + this.valor + "\n";
           r = r + "VRegistro: " + this.VRegistro;
           return r;
    }

}
class Continue_nodo{
        private Nodo_irt ope;
        private Nodo_irt jumpe;
    public Continue_nodo(Nodo_irt o, Nodo_irt j){
            this.ope = o;
            this.jumpe = j;
    
        }
    public String getContinue_nodo(){
        String result = "";
        result = result + this.ope.op.getOperacion();
        result = result + this.jumpe.for_nodo.getFor();
        return result;
            
    }
}
// assignacion
// ir a tag de inicio
// tag: antes
// operacion: n++
// (inicio) pregunta de la condicion

// 