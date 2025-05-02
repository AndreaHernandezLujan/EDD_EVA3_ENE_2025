
package eva3_1_ordenamientos;

public class EVA3_1_ORDENAMIENTOS {

    public static void main(String[] args) {
        
        long ini, fin, tiempo;
        int[] original = new int[10];
        int[] copiaSelection = new int[10];
        int[] copiaInsertion = new int[10];
        int[] copiaBubbleSort = new int[10];
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

public static void bubbleSort(int[]arreglo){
    for (int i = 0; i < arreglo.length; i++) {
        for (int j = 0; j < (arreglo.length -1); j++) {
            if(arreglo[j] > arreglo[j + 1]){
            int temp = arreglo[j];
            arreglo[j]= arreglo [j +1];
            arreglo[j +1]= temp;
            }
            
        }
        
    }
}
}



