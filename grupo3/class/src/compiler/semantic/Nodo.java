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
