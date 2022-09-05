/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author p1jav
 */
import compiler.scanner.Scanner_;
import java.util.Scanner;

public class Compiler {
    
    public static void main(String[] args){
        //Ruta al archivo
        String ruta = "G:\\Mi unidad\\semestre VI\\Compiladores\\git\\CompiladoresLabs\\grupo3\\class\\src\\compiler\\scanner\\entrada.txt";
        
        //Scanner
        Scanner_ scan = new Scanner_();
        scan.main(null,ruta);
        
        //inicio del codigo
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("- ");
            String comando = sc.nextLine();

            //System.out.println(comando);
            comando = comando.replaceAll(" ", "");

            int j = comando.indexOf("java");
            int c = comando.indexOf("Compiler");
            
            if (j == 0 && c == 4){
                int nada = comando.length();
                if (nada == 12) {
                    System.out.println("Con el comando java Compiler -h \nSe despliega un meno de ayuda.\n");
                }
                else{
                    int find_menos = comando.indexOf("-");
                    String archivo = comando.substring(12, find_menos);
                    //System.out.println("El archivo es: " + archivo);
                    // javaCompilerarchivo.txt-targetscan
                    
                    
                    if (archivo.equals("")){
                        String tag = comando.substring(find_menos, comando.length());
                        
                        System.out.println("Se despliega el menu de ayuda!");
                        //ver si es h, sino decir que esta incorrecto el comando, falta el archivo!
                    }
                }
                
            }
            else if (comando.equals("exit")){
                break;
            }
            else{
                System.out.println("No escribio correctamente el comando");
            }
        }
            

    }
}
