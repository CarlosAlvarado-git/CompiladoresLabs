/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.semantic;

import java.util.ArrayList;

/**
 *
 * @author Oscar
 */


public class Nodo {
    private String nombre;
    // valores de la tabla
    private String llamada; // ==>columna llamada
    private String type; // columna type
    private String Identifier; // ==> columna id 
    private String valor; // ==> columna valor
    private int Location; // yyline? ==> columna location
    private int scope; // ==> columna scope
    private int memoria; // ==> columna memoria
    private String funcion; //==> solo para las variables de parámetros
    
    //============
    private int numNodo; 
    private ArrayList<Nodo> hijos; 
                
    
    public Nodo(String nombre)
    {
        setNombre(nombre);
        this.hijos = new ArrayList<>();
        //setValor("");
        setNumNodo(0);
    }
    
    public String getfuncion() {
        return this.funcion;
    }
    public void setfuncion(String funcion) {
        this.funcion = funcion;
    }
    
    public String getllamada() {
        return this.llamada;
    }
    public void setllamada(String llamada) {
        this.llamada = llamada;
    }
    
    public String gettype() {
        return this.type;
    }
    
    public void settype(String type) {
        this.type = type;
    }
    
    public String getIdentifier() {
        return this.Identifier;
    }
    
    public void setIdentifier(String id) {
        this.Identifier = id;
    }
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public int getLocation() {
        return this.Location;
    }
    public void setLocation(int location) {
        this.Location = location;
    }

    public int getscope() {
        return this.scope;
    }
    
    public void setscope(int scope) {
        this.scope = scope;
    }
    
    public int getmemoria() {
        return this.memoria;
    }
    
    public void setmemoria(int memoria) {
        this.memoria = memoria;
    }
    
    //=====================
    
   
    public void addHijo(Nodo hijo)
    {
        this.hijos.add(hijo);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Nodo> getHijos() {
        return this.hijos;
    }

    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }

    
    

     

    public int getNumNodo() {
        return this.numNodo;
    }


    public void setNumNodo(int numNodo) {
        this.numNodo = numNodo;
    }
}
