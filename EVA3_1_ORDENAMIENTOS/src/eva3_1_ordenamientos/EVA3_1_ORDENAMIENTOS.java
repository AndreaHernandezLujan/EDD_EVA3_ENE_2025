
package eva3_1_ordenamientos;

public class EVA3_1_ORDENAMIENTOS {

    public static void main(String[] args) {

        long ini, fin, tiempo;
        int[] original = new int[10];
        int[] copiaSelection = new int[10];
        int[] copiaInsertion = new int[10];
        int[] copiaBubbleSort = new int[10];
        int[] copiaQuickSort = new int[10];
        int[] copiaMergeSort = new int[10];
        llenar(original);//LLENA CON VALORES ALEATORIOS ENTRE 0 Y 99
        System.out.println("Arreglo original:");
        imprimir(original); //IMPRIME LOS DATOS ALMACENADOS EN EL ARREGLO
        copiar(original, copiaSelection);//CREA UN DUPLICADO DE LOS DATOS EN EUN ARREGLO

        System.out.println("SELECTION SORT--------------------");
        ini = System.nanoTime();//HORA LOCAL EN NANOSEGUNDOS
        selectionSort(copiaSelection);
        System.out.println("Copia del arreglo:");
        imprimir(copiaSelection);
        fin = System.nanoTime();//HORA LOCAL EN NANOSEGUNDOS
        tiempo = (fin - ini);
        System.out.println("Tiempo: " + tiempo);

        System.out.println("INSERTION SORT--------------------");
        copiar(original, copiaInsertion);
        ini = System.nanoTime();
        insertionSort(copiaInsertion);
        System.out.println("Copia del arreglo (Insertion Sort):");
        imprimir(copiaInsertion);
        fin = System.nanoTime();
        tiempo = (fin - ini);
        System.out.println("Tiempo: " + tiempo);

        System.out.println("BUBBLE SORT--------------------");
        copiar(original, copiaBubbleSort);
        ini = System.nanoTime();
        bubbleSort(copiaBubbleSort);
        System.out.println("Copia del arreglo (BubbleSort):");
        imprimir(copiaBubbleSort);
        fin = System.nanoTime();
        tiempo = (fin - ini);
        System.out.println("Tiempo: " + tiempo);

        System.out.println("QuickSort--------------------");
        copiar(original, copiaQuickSort);
        ini = System.nanoTime();
        quicksort(copiaQuickSort);
        System.out.println("Copia del arreglo (QuickSort):");
        imprimir(copiaQuickSort);
        fin = System.nanoTime();
        tiempo = (fin - ini);
        System.out.println("Tiempo: " + tiempo);
        
        System.out.println("MERGE SORT--------------------");
        copiar(original, copiaMergeSort);
        ini = System.nanoTime();
        mergeSort(copiaMergeSort);
        System.out.println("Copia del arreglo (MergeSort):");
        imprimir(copiaMergeSort);
        fin = System.nanoTime();
        tiempo = (fin - ini);
        System.out.println("Tiempo: " + tiempo);

        
        

    }

    public static void llenar(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random() * 100);

        }
    }

    public static void imprimir(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }

    public static void copiar(int[] arreglo, int[] copia) {
        for (int i = 0; i < arreglo.length; i++) {
            copia[i] = arreglo[i];
        }

    }

    //SELECTION SORT
    // O (N2)--> COMPARACIONES
    // O (N)--> INTERCAMBIOS
    public static void selectionSort(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) { //PASADAS
            int min = i;
            for (int j = i; j < arreglo.length; j++) { //COMPARACIONES
                if (arreglo[j] < arreglo[min]) {
                    min = j; //min es minimo
                } //Buscas, encuentras el mas pequeño e intercambias
            }
            if (min != i) { //intercambias -->swap
                int temp = arreglo[min];
                arreglo[min] = arreglo[i];
                arreglo[i] = temp;

            }

        }
    }

    //INSERTION SORT O(N2)
    public static void insertionSort(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            int temp = arreglo[i]; // valor a ordenar
            int insP = i; // posición donde podría insertarse

            for (int prev = i - 1; prev >= 0; prev--) { // prev: posición anterior
                if (arreglo[prev] > temp) { //Si el anterior arreglo[prev] es mayor que temp Swap
                    arreglo[insP] = arreglo[prev]; // mover el elemento a la derecha
                    insP--; // actualizar la posición de inserción
                } else {//DETENER EL SEGUNDO FOR
                    break; // ya encontró su lugar, no necesita seguir comparando
                }
            }
            //no se puede insertar dentro del for porque se tiene que terminar su ciclo
            arreglo[insP] = temp; // insertar temp en su posición correcta
        }
    }

    public static void bubbleSort(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < (arreglo.length - 1); j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }

            }

        }
    }
//quicksort

    public static void quicksort(int[] arreglo) {
        quicksortRecu(arreglo, 0, arreglo.length - 1);

    }
//ALGORITMO RECURSIVO

    public static void quicksortRecu(int[] arreglo, int ini, int fin) {
//ELEGIR PIVOTE --> PARA NUESTRO EJEMPLO, PRIMER ELEMENTO
//MOVER LOS INDICES
//ENCONTAR VALORES E INTERCAMBIAR
//SE CRUZAN?
//SI --> INTERCAMBIAR PIVOTE, TERMINAR
//SI --> REPETIR DESDE MOVER INDICES
//LLAMADA RECURSIVA A CADA PARTE DEL ARREGLO
//A LADO IZQ Y DER DEL PIVOTE

        if (ini < fin) {
            int pivote = arreglo[ini];
            int i = ini + 1;
            int j = fin;

            while (i <= j) {
                while (i <= fin && arreglo[i] <= pivote) {
                    i++;
                }
                while (j >= ini && arreglo[j] > pivote) {
                    j--;
                }
                if (i < j) {
                    int temp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temp;
                }
            }

            // Intercambiar el pivote con el elemento en j
            arreglo[ini] = arreglo[j];
            arreglo[j] = pivote;

            // Llamadas recursivas para cada mitad
            quicksortRecu(arreglo, ini, j - 1); // izquierda
            quicksortRecu(arreglo, j + 1, fin); // derecha
        }
    }
    
    public static void mergeSort(int[] arreglo) {
    mergeSortRecu(arreglo, 0, arreglo.length - 1);
}

public static void mergeSortRecu(int[] arreglo, int ini, int fin) {
    if (ini < fin) {
        int medio = (ini + fin) / 2;
        // Ordenar cada mitad
        mergeSortRecu(arreglo, ini, medio);
        mergeSortRecu(arreglo, medio + 1, fin);
        // Combinar ambas mitades
        merge(arreglo, ini, medio, fin);
    }
}

public static void merge(int[] arreglo, int ini, int medio, int fin) {
    // Tamaños de los arreglos temporales
    int tama1 = medio - ini + 1;
    int tama2 = fin - medio;

    // Crear arreglos temporales
    int[] izquierda = new int[tama1];
    int[] derecha = new int[tama2];

    // Copiar datos a los arreglos temporales
    for (int i = 0; i < tama1; i++)
        izquierda[i] = arreglo[ini + i];
    for (int j = 0; j < tama2; j++)
        derecha[j] = arreglo[medio + 1 + j];

   
    int i = 0, j = 0;
    int k = ini;
    while (i < tama1 && j < tama2) {
        if (izquierda[i] <= derecha[j]) {
            arreglo[k] = izquierda[i];
            i++;
        } else {
            arreglo[k] = derecha[j];
            j++;
        }
        k++;
    }

  
    while (i < tama1) {
        arreglo[k] = izquierda[i];
        i++;
        k++;
    }

    while (j < tama2) {
        arreglo[k] = derecha[j];
        j++;
        k++;
    }
}


}
    



