import colecciones.MethodList;
import colecciones.MethodMap;
import colecciones.MethodSet;

public class App {
    public static void main(String[] args) throws Exception {

        MethodSet testSet = new MethodSet();
        testSet.testeandoHashSet();
        testSet.testeandoLinkedHashSet();
        testSet.testeandoTreeSet();

        MethodList testList = new MethodList();
        testList.testeandoArrayList();
        testList.testeandoLinkedList();
        testList.testeandoStack();

        MethodMap testMap = new MethodMap();
        testMap.testeandoHashMap();
        testMap.testeandoLinkedHashMap();
        testMap.testeandoTreeMap();

        
    }
}
