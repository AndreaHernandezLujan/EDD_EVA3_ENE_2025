
package eva3_3__collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;


public class EVA3_3__COLLECTIONS {

    
    public static void main(String[] args) {
       
        
    LinkedList<Integer> lista = new LinkedList<>();
    lista.add(100); //Objeto de tipo Integer
    lista.add(500);
    lista.add(300);
    lista.add(600);
    lista.add(800);
    System.out.println(lista);
    
    
    Comparator c = new Comparator() { //Comparador
        
    //DEBEMOS DETERMINAR EL CRITERIO DE ORDENAMIENTO 
        //VALOR NEGATIVO SI o1 < o2
        // CERO SI  o1 = o2
        //VALOR POSITIVO SI o1 > o2
        @Override
        public int compare(Object o1, Object o2) {
        Integer val1 = (Integer)o1;
        Integer val2 = (Integer)02;
        return val1 - val2;
        }
    };
    lista.sort(c);
    System.out.println(lista);
    
    ArrayList<String> cadenas = new ArrayList<>();
    cadenas.add("Lunes");
    cadenas.add("Martes");
    cadenas.add("Miercoles");
    cadenas.add("Jueves");
    System.out.println(cadenas);
    
    Comparator cade = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
        String cade1 = (String)o1;
        String cade2 = (String)o2;
        return cade1.compareTo(cade2) * -1;
        }
    };
            cadenas.sort(cade);
            System.out.println(cadenas);
    }
    
}
