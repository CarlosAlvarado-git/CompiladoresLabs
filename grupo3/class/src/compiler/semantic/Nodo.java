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
    private ArrayList<Nodo> hijos;
    private String valor;
    private int numNodo;
    // Para todos los Id's 
    // para guardar algo en la tabla, tenemos que ser hijos de un field_decl | var_decl
    // si soy hijo y me llamo type, entonces, llamo a insertarSymbol | sino, significa que soy 
    private String ID;//yytext
    private String Type; //ver al "hermano" anterior. 
    private String Location; // yyline? 
    // dos bandes: 
        // type: decir que estoy esperando un type. Se activa cuando soy un type OR todos acquellos que se generan con coma. Y nomás meta el id, se desactiva.  
        // location: se activa cuando sea un location. Se desactiva cuando sea el id. 
        
    // nomas creamos el method declaration: creamos un nuevo scope para sus var declaration.
    //bandera: 
        // void: lo mismo que el type, solo que para funciones. para meterlo al scope. TABLA. luego se quita. 
    // nomas ceramos el scope en la TABLA, debemos crear su "scope" para la TABLA PARAMETROS, guardo el key en una variable
        // si encuentro ( activo bandera de: inician parámetros. 
        // si encuentro ) desacativo bandera parametros. 
    // SI ESTA ACTIVO bandera parametros, y la key que tengo guardad es un main. ERROR. 
    
    // con el IF:
        // si soy un statement y MI HIJO ES IF, activo bandera de IF
            // TENGO 3 POSIBLES RESULTADOS DESPUES DE UN IF:
                // si soy: LOCATION O METHODCALL: es hacer un lookup, GUARDAR EL TYPE
                // si soy un literal: GUARDAR que literal soy.
        // si viene un !
            // activo bandera de exlacion
                // debe de ser un bool lo que me "devuela" la expresion. SINO ERROR
        // ⟨arith op⟩s and ⟨rel op⟩s SI ENCUENTRO UNO en el if,
            // bandera: ver si al menos uno de dos de expresion o al menos que alguno me devuelva int. int_literal
                
    
    public Nodo(String nombre)
    {
        setNombre(nombre);
        this.hijos = new ArrayList<>();
        //setValor("");
        setNumNodo(0);
    }
    /*
    public String getID() {
        return this.ID;
    }
    public String setID(String id) {
        this.ID = id;
    }
    public String getType() {
        return this.Type;
    }
    public String setType(String type) {
        this.Type = type;
    }
    public String getLocation() {
        return this.Location;
    }
    public String setLocation(String location) {
        this.Location = location;
    }
    */
    
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

    
    public String getValor() {
        return valor;
    }


    public void setValor(String valor) {
        this.valor = valor;
    }


    public int getNumNodo() {
        return this.numNodo;
    }


    public void setNumNodo(int numNodo) {
        this.numNodo = numNodo;
    }
}
