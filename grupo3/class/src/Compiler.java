/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author p1jav
 */
import compiler.scanner.Scanner;

public class Compiler {
    
    public static void main(String[] args){
        //Ruta al archivo
        String ruta = "G:\\Mi unidad\\semestre VI\\Compiladores\\git\\CompiladoresLabs\\grupo3\\class\\src\\compiler\\scanner\\entrada.txt";
        
        //Scanner
        Scanner scan = new Scanner();
        scan.main(null,ruta);
    }
}
