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
    public Asignacion Asig;
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
       public void Crear_Asignacion(String Oper, String Valor, String result){
           this.Asig = new Asignacion(Oper, Valor, result);
        }
       public String Asignacion(){
           String resultado =  this.Asig.getAsignacion();
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
class condicion_if{}
class condicion_for{}
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