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
    public parametros parametros_nodo;
    public Negacion negacion_nodo;
    private String Nombre;
    public Nodo_irt(String Nombre){
        this.Nombre = Nombre;
    
    }
    public String getNombre(){
        return this.Nombre;
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
       public void Crear_IF(){ this.if_nodo = new IF_nodo();}
       public void Crear_FOR(){ this.for_nodo = new FOR_nodo();}
       
       public void Crear_method(String f, String param){
           this.method_call_nodo = new method_call(f, param); 
       }
       public String Metodo(){
           String resultado = this.method_call_nodo.getMethod();
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
           resultado = resultado+ " Registro: " + this.getRegistro() + ". \n";
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
    private ArrayList<Nodo_irt> parte_true = new ArrayList<>();
    private ArrayList<Nodo_irt> parte_false = new ArrayList<>();
    private Nodo_irt condicione;
    public IF_nodo(){
        
    
        }
    // funcion que recibe condicion.
    public void getCondicion(Nodo_irt con){
        this.condicione = con;
        }
    // agregar a parte true
    public void addTrue(Nodo_irt nuevo){
        this.parte_true.add(nuevo);
        }
    // agregar a parte false
    public void addFalse(Nodo_irt nuevo){
        this.parte_false.add(nuevo);
        }
    
}
class FOR_nodo{
    private ArrayList<Nodo_irt> parte_true = new ArrayList<>();
    private Nodo_irt condicione;
    public FOR_nodo(){
        
    
        }
    // funcion que recibe condicion.
    public void getCondicion(Nodo_irt con){
        this.condicione = con;
        }
    // agregar a parte true
    public void addTrue(Nodo_irt nuevo){
        this.parte_true.add(nuevo);
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
            result = result + " parametros: " + this.parametros + "\n";
          }
          return result;
      }
}
// para los method decla, hacemos lo mismo, PERO ! YA VEMOS LA MEMORIA ! 

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
