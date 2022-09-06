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
        String[] tages = {"o", "target", "opt", "debug"};
        
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
                    System.out.println("Con el comando java Compiler -h \nSe despliega un menu de ayuda.\n");
                }
                else{
                    int find_menos = comando.indexOf("-");
                    String archivo = comando.substring(12, find_menos);
                    //System.out.println("El archivo es: " + archivo);
                    // javaCompilerarchivo.txt-targetscan
                    if (archivo.equals("")){
                        
                        System.out.println("""
                                           Especificación general:
                                                - java Compiler <filename> [option] 
                                           
                                           [option]:
                                                -o <outname>: escribe el nombre del archivo final.
                                                -target <stage>: ejecución hasta la etapa indicada.
                                                                 (scan, parse, ast, semantic, irt, codegen)
                                                                 si <stage> es vación, por defecto se llegará a codegen.
                                                -opt <opt_stage>: optimización hasta la etapa marcada en: -target, puede 
                                                                  ser de tipo constant, algebraic.
                                                -debug <stage>: se hace un debbugin hasta la etapa especificada 
                                                                por ejemplo: scan:parser:ast
                                           """);
                        //ver si es h, sino decir que esta incorrecto el comando, falta el archivo!
                    }
                    else{
                        String tag = comando.substring(find_menos+1, comando.length());
                        //targetscan
                        //System.out.println(tag);
                        for (int i = 0; i < tages.length; i++) {
                            int val = tag.indexOf(tages[i]);
                            if (val == 0) {
                                switch (tages[i]){
                                    case "target":
                                        tag = tag.substring(6, tag.length());
                                        //System.out.println(tag);
                                        switch (tag){
                                            case "scan":
                                                //Ruta al archivo
                                                String ruta = System.getProperty("user.dir");
                                                ruta = ruta + "/" + archivo;
                                                //Scanner
                                                Scanner_ scan = new Scanner_();
                                                scan.main(null,ruta);
                                                break;
                                            case "parse":
                                                break;
                                            case "ast":
                                                break;
                                            case "semantic":
                                                break;
                                            case "irt":
                                                break;
                                            case "codegen":
                                                break;
                                            
                                            
                                        }
                                        
                                        break;
                                    case "o":
                                        break;
                                    case "opt":
                                        break;
                                    case "debug":
                                        break;
                                    default:
                                        break;
                                }
                            }
                            
                        }
                        
                    }
                }
                
            }
            else if (comando.equals("exit")){
                break;
            }
            else{
                System.out.println("No escribio correctamente el comando\n");
                System.out.println("Con el comando java Compiler -h \nSe despliega un menu de ayuda.\n");
            }
        }
            

    }
}
