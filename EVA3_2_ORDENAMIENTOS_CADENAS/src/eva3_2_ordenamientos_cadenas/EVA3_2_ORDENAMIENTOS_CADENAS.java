
package eva3_2_ordenamientos_cadenas;

public class EVA3_2_ORDENAMIENTOS_CADENAS {

    public static void main(String[] args) {
        //ini, fin y tiempo se utilizan para medir el tiempo de ejecución que tarda cada algoritmo
        long ini, fin, tiempo;
        String[] original = new String[10]; //Arreglo con letras aleatorias
        String[] copiaSelection = new String[10]; //Copias del arreglo para aplicar cada tipo de
        String[] copiaInsertion = new String[10]; //ordenamiento sin modificar el original
        String[] copiaBubbleSort = new String[10];

        llenar(original); // Llenar con letras aleatorias de A-Z

        System.out.println("Arreglo original:");
        imprimir(original);

        copiar(original, copiaSelection); //se copia el arreglo original a copiaSelection
        System.out.println("SELECTION SORT--------------------");
        ini = System.nanoTime(); //Se mide el tiempo de ejecución
        selectionSort(copiaSelection);
        imprimir(copiaSelection);
        fin = System.nanoTime();
        tiempo = fin - ini;
        System.out.println("Tiempo: " + tiempo); //se imprime el arreglo ordenado y el tiempo que tardo

        System.out.println("INSERTION SORT--------------------");
        copiar(original, copiaInsertion);//se copia el arreglo original a copiaInsertion
        ini = System.nanoTime();
        insertionSort(copiaInsertion);
        imprimir(copiaInsertion);
        fin = System.nanoTime();
        tiempo = fin - ini;
        System.out.println("Tiempo: " + tiempo);

        System.out.println("BUBBLE SORT--------------------");
        copiar(original, copiaBubbleSort);//se copia el arreglo original a copiaBubbleSort
        ini = System.nanoTime();
        bubbleSort(copiaBubbleSort);
        imprimir(copiaBubbleSort);
        fin = System.nanoTime();
        tiempo = fin - ini;
        System.out.println("Tiempo: " + tiempo);
    }
    //Método para llenar el arreglo
    public static void llenar(String[] arreglo) {//El método recibe como parametro un arreglo de string llamado arreglo
        //Recorremos el arreglo desde el primer hasta el ultimo indice
        for (int i = 0; i < arreglo.length; i++) { //Recorre i hasta el final de el arreglo, compara los valores desde la posicion actual hasta el final para encontrar el menor
            // Genera una letra aleatoria entre A y Z
            char letra = (char) ('A' + (int)(Math.random() * 26));
            arreglo[i] = String.valueOf(letra);
        }
    }
    //Método para imprimir el arreglo
    public static void imprimir(String[] arreglo) { 
        for (String elemento : arreglo) {
            System.out.print("[" + elemento + "]");
        }
        System.out.println();
    }
    //Método para copiar el arreglo
    public static void copiar(String[] arreglo, String[] copia) { 
        for (int i = 0; i < arreglo.length; i++) {
            copia[i] = arreglo[i];
        }
    }
    //Ordena un arreglo de Strings alfabéticamente usando el algoritmo de selección (Selection Sort).
    public static void selectionSort(String[] arreglo) {//Recibe como parametro un arreglo de cadenas String
    //El primer bucle for recorre cada elemento de el arreglo desde el primer indice 0 hasta el ultimo
    //i representa la primer posicion en donde se buscara el valor mas pequeño para colocar ahi
    //La idea es que en cada vuelta pongamos el valor más pequeño en la posición i
        for (int i = 0; i < arreglo.length; i++) { 
            int min = i;//variable min que guardará el índice del valor mínimo que encontremos
            for (int j = i + 1; j < arreglo.length; j++) { //Este busca el valor más pequeño en el resto del arreglo (desde i+1 hasta el final)
    //j recorre las posiciones que siguen a i para comparar sus valores con el actual mínimo
                if (arreglo[j].compareTo(arreglo[min]) < 0) { //Compara dos cadenas alfabéticamente: arreglo[j] con arreglo[min]
                    min = j;//Se actualiza min con el índice del nuevo valor mínimo encontrado
                    //Un número negativo si arreglo[j] va antes que arreglo[min]
                    //Cero si son iguales
                    //Un número positivo si arreglo[j] va después
                }
            } // Si el resultado es menor a 0, entonces arreglo[j] es más pequeño, y actualizamos min
            if (min != i) {
                String temp = arreglo[min];//Se guarda temporalmente el valor mas pequeño encontrado
                arreglo[min] = arreglo[i];//Colocamos el valor original de la posición i en la posición min
                arreglo[i] = temp; //colocamos el valor más pequeño (que guardamos en temp) en la posición i
            }
        }
    }
    //Recibe un arreglo de String llamdo arreglo
    public static void insertionSort(String[] arreglo) {
 //Comienza un bucle for que recorre el arreglo desde la posicion 1 hasta el final
        for (int i = 1; i < arreglo.length; i++) {
            String temp = arreglo[i];//Se guarda temporalmente el valor que esta en la posicion i
            int insP = i; //comienza siendo i, pero puede cambiar si hay elementos mayores a temp que deban moverse
            for (int prev = i - 1; prev >= 0; prev--) {
//Se crea un segundo bucle for que recorre la parte anterior a i en reversa de derecha a izquierda
//Compara el valor actual del arreglo (arreglo[prev]) con temp
                if (arreglo[prev].compareTo(temp) > 0) {//Un número positivo si arreglo[prev] es mayor alfabéticamente que temp
////Cero si son iguales, Negativo si es menor, Si es mayor, hay que mover ese valor una posición a la derecha para dejar espacio a temp
                    arreglo[insP] = arreglo[prev];//Se mueve el valor mayor (arreglo[prev]) a la posición insP
                    insP--;//Se reduce la posición de inserción porque temp tendrá que ir más a la izquierda
                } else {
                    break;//Si arreglo[prev] no es mayor a temp, se rompe el bucle: ya se encontró la posición correcta donde insertar
                }
            }
            arreglo[insP] = temp;//Finalmente, se inserta temp en su lugar correcto dentro de la parte ordenada del arreglo
        }
    }

    public static void bubbleSort(String[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j].compareTo(arreglo[j + 1]) > 0) {
                    String temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }
}



    
    

