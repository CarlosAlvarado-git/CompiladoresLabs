/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author p1jav
 */
import compiler.scanner.Scanner_;
import compiler.parser.Parser;
import compiler.semantic.Semantic;
import compiler.irt.IRT_C;
import compiler.ast.Ast;
//import compiler.semantic.Semantic;
import java.util.Scanner;

public class Compiler {
    
    public static void main(String[] args) throws Exception{
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
                                        //tag = tag.substring(6, tag.length());
                                        String ruta = "";
                                        //System.out.println(tag);
                                        String vacio = tag.substring(6,tag.length());
                                        if(vacio == ""){
                                            ruta = System.getProperty("user.dir");
                                            ruta = ruta + "/src/" + archivo;
                                            //Ruta al archivo
                                            ruta = System.getProperty("user.dir");
                                            ruta = ruta + "/src/" + archivo;
                                            //Semantic
                                            IRT_C irt_ = new IRT_C();
                                            irt_.main(null,ruta);   
                                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                            System.out.println("stage: scanning");
                                            System.out.println("stage: parsing");
                                            System.out.println("stage: ast");
                                            System.out.println("stage: semantic");
                                            System.out.println("stage: irt");
                                            System.out.println("Irt completado");
                                        }
                                        else{
                                        switch (vacio){
                                            
                                            case "scan":
                                                //Ruta al archivo
                                                ruta = System.getProperty("user.dir");
                                                ruta = ruta + "/src/" + archivo;
                                                //Scanner
                                                Scanner_ scan = new Scanner_();
                                                //System.out.println("Entre a scan");
                                                scan.main(null,ruta);
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                System.out.println("stage: scanning");
                                                System.out.println("Scanning completado");
                                                break;
                                            case "parse":
                                                ruta = System.getProperty("user.dir");
                                                ruta = ruta + "/src/" + archivo;
                                                //Scanner
                                                Parser parse = new Parser();
                                                parse.main(null,ruta);
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                System.out.println("stage: scanning");
                                                System.out.println("stage: parsing");
                                                System.out.println("Parsing completado");
                                                break;
                                            case "ast":
                                                ruta = System.getProperty("user.dir");
                                                ruta = ruta + "/src/" + archivo;
                                                //Scanner
                                                Ast ast = new Ast();
                                                ast.main(null,ruta);
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                System.out.println("stage: scanning");
                                                System.out.println("stage: parsing");
                                                System.out.println("stage: ast");
                                                System.out.println("Ast completado");
                                                break;
                                            case "semantic":
                                                ruta = System.getProperty("user.dir");
                                                ruta = ruta + "/src/" + archivo;
                                                //Semantic
                                                Semantic semantic = new Semantic();
                                                semantic.main(null,ruta);
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                System.out.println("stage: scanning");
                                                System.out.println("stage: parsing");
                                                System.out.println("stage: ast");
                                                System.out.println("stage: semantic");
                                                System.out.println("semantic completado");
                                                break;
                                            case "irt":
                                                ruta = System.getProperty("user.dir");
                                                ruta = ruta + "/src/" + archivo;
                                                //Semantic
                                                IRT_C irt = new IRT_C();
                                                irt.main(null,ruta);   
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                System.out.println("stage: scanning");
                                                System.out.println("stage: parsing");
                                                System.out.println("stage: ast");
                                                System.out.println("stage: semantic");
                                                System.out.println("stage: irt");
                                                System.out.println("Irt completado");
                                                break;
                                            case "codegen":
                                                break;
                                            default:
                                            break;
                                        }
                                        }
                                        
                                        break;
                                    case "o":
                                        break;
                                    case "opt":
                                        break;
                                    case "debug":
                                        tag = tag.substring(5, tag.length());
                                        ruta = "";
                                        //System.out.println(tag);
                                         for (int x = 0; x < tag.length(); x++){
                                             int dos_puntos = tag.indexOf(":", x);
                                             int verificacion = tag.indexOf(":");
                                             int verificacion2 = tag.substring(x,tag.length()).indexOf(":");
                                            
                                             if (dos_puntos != -1 || verificacion == -1 || verificacion2 == -1){
                                                 String tag_n = "";
                                                 if(verificacion == -1){
                                                     tag_n = tag;
                                                 }
                                                 else if(verificacion2 == -1){
                                                     tag_n = tag.substring(x,tag.length());
                                                 }
                                                 else{
                                                     tag_n = tag.substring(x, dos_puntos); 
                                                 }
                                                   
                                            switch (tag_n){
                                                case "scan":
                                                    //Ruta al archivo
                                                    ruta = System.getProperty("user.dir");
                                                    ruta = ruta + "/src/" + archivo;
                                                    //Scanner
                                                    Scanner_ scan = new Scanner_();
                                                    System.out.println("Debugging: scan");
                                                    scan.main(null,ruta);
                                                    System.out.println("Scanning completado");
                                                    break;
                                                case "parse":
                                                    ruta = System.getProperty("user.dir");
                                                    ruta = ruta + "/src/" + archivo;
                                                    //Scanner
                                                    Parser parse = new Parser();
                                                    System.out.println("Debugging: Parse");
                                                    parse.main(null,ruta);
                                                    System.out.println("Parsing completado");
                                                    break;
                                                case "ast":
                                                    ruta = System.getProperty("user.dir");
                                                    ruta = ruta + "/src/" + archivo;
                                                    //Scanner
                                                    Ast ast = new Ast();
                                                    System.out.println("Debugging: Parse");
                                                    ast.main(null,ruta);
                                                    System.out.println("Ast completado");
                                                    break;
                                                case "semantic":
                                                    ruta = System.getProperty("user.dir");
                                                    ruta = ruta + "/src/" + archivo;
                                                    //Semantic
                                                    Semantic semantic = new Semantic();
                                                    System.out.println("Debugging: Semantic");
                                                    semantic.main(null,ruta);
                                                    System.out.println("semantic completado");
                                                    break;
                                                case "irt":
                                                    ruta = System.getProperty("user.dir");
                                                    ruta = ruta + "/src/" + archivo;
                                                    //Semantic
                                                    IRT_C irt = new IRT_C();
                                                    System.out.println("Debugging: Irt");
                                                    irt.main(null,ruta);   
                                                    System.out.println("Irt completado");
                                                    break;
                                                case "codegen":
                                                    break;
                                            }
                                        }
                                        if(verificacion == -1){
                                                 x = tag.length();
                                         }
                                        else if(verificacion2 == -1){
                                             x = tag.length();
                                        
                                        }
                                        else{
                                              x = dos_puntos;
                                        }
                                      
                                    }
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
