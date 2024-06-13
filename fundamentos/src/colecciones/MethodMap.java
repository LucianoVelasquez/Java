package colecciones;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MethodMap {

    /** 
     * Orden de los Elementos: No garantiza
     * <p>
     * Uso principal: Rendimiento rápido sin necesidad de orden
     */
    public void testeandoHashMap(){
        Map<String,String> animales = new HashMap<>();

        animales.put("Perro", "Andy");
        animales.put("Perro2", "Andy2");
        animales.put("Gato", "Michi");
        animales.put("Gato2", "Muchi2");

        System.out.println("\nLista de Animales en HashMap: "+animales);

        animales.forEach((t, u) -> {
            System.out.println("Clave: "+t+" "+"Valor: "+u);
        });
    }

    /** 
     * Orden de los Elementos: Orden de inserción
     * <p>
     * Uso principal: Mantener el orden de inserción
     */
    public void testeandoLinkedHashMap(){
        Map<String,String> animales = new LinkedHashMap<>();

        
        animales.put("Perro", "Andy");
        animales.put("Perro2", "Andy2");
        animales.put("Gato", "Michi");
        animales.put("Gato2", "Muchi2");

        System.out.println("\nLista de Animales en LinkedHashMap: "+animales);

        animales.forEach((t, u) -> {
            System.out.println("Clave: "+t+" "+"Valor: "+u);
        });
    }

    /** 
     * Orden de los Elementos: Orden natural o Comparator (Alfabeticamente, > a <)
     * <p>
     * Uso principal: Necesidad de un mapa ordenado por claves
     */
    public void testeandoTreeMap(){
        Map<String,String> animales = new TreeMap<>();

        animales.put("Perro", "Andy");
        animales.put("Perro2", "Andy2");
        animales.put("Gato", "Michi");
        animales.put("Gato2", "Muchi2");

        System.out.println("\nLista de Animales en TreeMap: "+animales);

        animales.forEach((t, u) -> {
            System.out.println("Clave: "+t+" "+"Valor: "+u);
        });
    }


}
