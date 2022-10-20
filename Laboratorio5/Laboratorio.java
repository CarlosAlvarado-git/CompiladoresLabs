import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.ArrayList;

import javax.print.attribute.HashAttributeSet;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class Laboratorio {
    int numero_stack = 0;

    public void recorrer(Root head, Stack<HashMap> stack_scope, int direccion) {

        int varDec = head.block.varDeclaration.size();
        HashMap<String, HashMap> tabla_scope = new HashMap<String, HashMap>();
        for (int indiceVar = 0; indiceVar < varDec; indiceVar = indiceVar + 1) {
            HashMap<String, String> tabla_simbolos = new HashMap<String, String>();
            tabla_simbolos.put("ID", String.valueOf(head.block.varDeclaration.get(indiceVar).name.hashCode()));
            if (tabla_scope.containsKey(head.block.varDeclaration.get(indiceVar).name)) {
                System.out.println("================================ Error ===============================\n");
                System.out.println(
                        "Duplicación en la declaración de variable: " + head.block.varDeclaration.get(indiceVar).name
                                + "\n");
            }
            tabla_scope.put(head.block.varDeclaration.get(indiceVar).name, tabla_simbolos);
            tabla_simbolos.put("identifier", head.block.varDeclaration.get(indiceVar).name);
            tabla_simbolos.put("type", head.block.varDeclaration.get(indiceVar).type);
            tabla_simbolos.put("Scope", String.valueOf(stack_scope.size()));
            tabla_simbolos.put("Location", head.block.varDeclaration.get(indiceVar).location);
        }
        stack_scope.add(tabla_scope);

        for (int varUs = 0; varUs < head.block.varUsage.size(); varUs = varUs + 1) {
            String variableU = head.block.varUsage.get(varUs).name;
            Boolean bandera = false;
            if (stack_scope.get(stack_scope.size() - 1).containsKey(variableU)) {
                bandera = true;
            } else {
                // System.out.println("Variable no está en el mismo scope");
                for (int indice_stack = 0; indice_stack < stack_scope.size() - 1; indice_stack = indice_stack + 1) {
                    if (stack_scope.get(indice_stack).containsKey(variableU)) {
                        bandera = true;
                    }
                }
            }
            if (bandera == false) {
                System.out.println("================================ Error ===============================\n");
                System.out.println("Variable " + variableU + " no declarada\n");
            }
        }

        int numero_scope = 0;
        if (head.block.blocks.isEmpty()) {
            numero_stack = numero_stack + 1;
            System.out.println(
                    "======================== Stack numero: " + String.valueOf(numero_stack) + " ====================");
            for (int recorrido = 0; recorrido < stack_scope.size(); recorrido = recorrido + 1) {
                int keys = stack_scope.get(recorrido).keySet().toArray().length;
                System.out.println("\nScope numero: " + String.valueOf(recorrido) + "\n");
                for (int key = 0; key < keys; key = key + 1) {

                    System.out.println(
                            stack_scope.get(recorrido).get(stack_scope.get(recorrido).keySet().toArray()[key]));
                }
            }
            System.out.println("\n");
        }

        int largo = head.block.blocks.size();

        for (int i = 0; i <= largo; i = i + 1) {
            if (direccion < i) {
                stack_scope.pop();
            }
            if (i != largo) {
                recorrer(head.block.blocks.get(i), stack_scope, i);
            }

        }

    }

    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(new FileReader("entrada.json"));
            String json = obj.toJSONString();
            // System.out.println(json);
            ObjectMapper mapper = new ObjectMapper();
            Root r = mapper.readValue(json, Root.class);
            // System.out.println(r.block.getClass());
            ListIterator<Root> namesIterator = r.block.blocks.listIterator();
            // System.out.println(namesIterator);
            // System.out.println(r.block.varDeclaration.get(0).type);
            // System.out.println(r.block.varDeclaration.get(0).name);
            // System.out.println(r.block.blocks.get(0).block.varDeclaration.get(1).type);
            Laboratorio lab = new Laboratorio();
            Stack<HashMap> stack_scope = new Stack<>();
            lab.recorrer(r, stack_scope, 0);
            // System.out.println(stack_scope);

            // for (int recorrido = 0; recorrido < stack_scope.size(); recorrido = recorrido
            // + 1) {
            // int keys = stack_scope.get(recorrido).keySet().toArray().length;
            // for (int key = 0; key < keys; key = key + 1) {
            // System.out.println(
            // stack_scope.get(recorrido).get(stack_scope.get(recorrido).keySet().toArray()[key]));
            // }
            // }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}

class Block {
    public ArrayList<VarDeclaration> varDeclaration;
    public ArrayList<VarUsage> varUsage;
    public ArrayList<Root> blocks;
}

class Root {
    public Block block;
}

class VarDeclaration {
    public String type;
    public String name;
    public String location;
}

class VarUsage {
    public String name;
    public String value;
    public String location;
}