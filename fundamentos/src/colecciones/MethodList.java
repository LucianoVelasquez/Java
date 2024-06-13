package colecciones;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MethodList {

    /** 
     *Orden de inserció
     *<p>
     *Acceso rápido por índice
     *<p>
     *Permite Null
    */
    public void testeandoArrayList(){
        /* 
        * Orden de inserción
        *<p>
        * Acceso rápido por índice
        *<p> 
        * Permite Null
        */
        List<String> heroes = new ArrayList<>();

        heroes.addAll(List.of("\nSpiderman","Batmman","Robbin","Sherlock Homes","Iroman"));

        System.out.println("\nLista de heros en ArrayList: "+heroes);

        if(heroes.add("Iroman")){
            System.out.println("Spiderman se aggrego correctamente en ArrayList:" +heroes);
        }
    }

    /** 
        * Todo lo anterior.
        *<p>
        * Es una lista doblemente enlasada.
        *<p>
        * Ificiente en inserciones/eliminaciones en extremos 

     */
    public void testeandoLinkedList(){
        List<String> heroes = new LinkedList<>();

        heroes.addAll(List.of("\nSpiderman","Batmman","Robbin","Sherlock Homes","Iroman"));

        System.out.println("\nLista de heros en LinkedList: "+heroes);

        if(heroes.add("Iroman")){
            System.out.println("Spiderman se aggrego correctamente en LinkedList:" +heroes);
        }

        heroes.removeFirst();
        System.out.println("Se elimino el primer registro: "+heroes);
    }

    /** 
     * Opera como LIFO, (Ultimo en entrar, primero en salir) 
    */
    public void testeandoStack(){
        List<String> heroes = new Stack<>();

        heroes.addAll(List.of("\nSpiderman","Batmman","Robbin","Sherlock Homes","Iroman"));

        System.out.println("\nLista de heros en Stack: "+heroes);

        if(heroes.add("Iroman")){
            System.out.println("Spiderman se aggrego correctamente en Stack:" +heroes);
        }

    }
}
