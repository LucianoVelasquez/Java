package colecciones;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class MethodSet {

    /** 
    * No permite elementos duplicados y no garantiza un orden espefifico. 
    <p>
    * Rendimiento rápido sin necesidad de orden
    <p>
    * Permite Null.
    */
    public void testeandoHashSet(){
        Set<String> heros = new HashSet<>();

        heros.addAll(Set.of("Spiderman","Hulk","Iroman","Barman","CatWoman"));

        //Muestra los nombres sin ningun orden.
        System.out.println("\nLista de heros con HashSet: "+heros);

        if(heros.add("Iroman")){
            System.out.println("\nIroman se agrego correctamente");
        }else{
            System.out.println("Iroman no se agrego correctamente en HashSet, ya existe.");
        }

    }

    /** 
        * Necesidad de un conjunto ordenado.
        <p>
        * Ordena de mayor a menor | alfabeticamente | Comparator.
        <p>
        * No permite Null.
     */
    public void testeandoTreeSet(){
        Set<String> heros = new TreeSet<>();

        heros.addAll(Set.of("Spiderman","Hulk","Iroman","Barman","CatWoman"));

        //Muestra los nombres de alfabeticamente gracias al Tree.
        System.out.println("\nLista de heros con TreeSet: "+heros);

        if(heros.add("Iroman")){
            System.out.println("\nIroman se agrego correctamente");
        }else{
            System.out.println("Iroman no se agrego correctamente en TreeSet, ya existe.");
        }
    }

    /** 
        * Mantiene el orden de insercion.
        <p>
        * Si permite nulls. 
     */
    public void testeandoLinkedHashSet(){
        Set<String> heros =  new LinkedHashSet<>();

        heros.addAll(Set.of("Spiderman","Hulk","Iroman","Barman","CatWoman"));

        //Muestra los nombres en orden de inserccion.
        System.out.println("\nLista de heros con LinkedHashSet: "+heros);

        if(heros.add("Iroman")){
            System.out.println("\nIroman se agrego correctamente");
        }else{
            System.out.println("Iroman no se agrego correctamente en LinkedHashSet, ya existe.");
        }
    }

}
