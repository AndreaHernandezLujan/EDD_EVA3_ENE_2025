
package eva3_4_busqueda_binaria;

import java.util.Scanner;

public class EVA3_4_BUSQUEDA_BINARIA {

    public static void main(String[] args) {
        int[] original = new int[10];
        int[] copiaSelection = new int[10];
        llenar(original);

        // Copiar a copiaSelection
        for (int i = 0; i < original.length; i++) {
            copiaSelection[i] = original[i];
        }

        System.out.println("Arreglo original (sin ordenar):");
        imprimir(original);

        Scanner captu = new Scanner(System.in);
        System.out.println("Valor a buscar:");
        int valor = captu.nextInt();

        selectionSort(copiaSelection); // Ordenar para búsqueda binaria

        System.out.println("Arreglo ordenado:");
        imprimir(copiaSelection);

        int resultado = busquedaBinaria(copiaSelection, valor);
        if (resultado == -1) {
            System.out.println("Valor no encontrado.");
        } else {
            // Buscar la posición en el arreglo original
            int posicionOriginal = -1;
            for (int i = 0; i < original.length; i++) {
                if (original[i] == valor) {
                    posicionOriginal = i;
                    break;
                }
            }
            System.out.println("Valor encontrado en el arreglo ordenado en la posición: " + resultado);
            System.out.println("Valor encontrado en el arreglo original en la posición: " + posicionOriginal);
        }
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

    public static void selectionSort(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            int min = i;
            for (int j = i; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arreglo[min];
                arreglo[min] = arreglo[i];
                arreglo[i] = temp;
            }
        }
    }

    public static int busquedaBinaria(int[] arreglo, int valorBus) {
        return busquedaBinariaRecu(arreglo, valorBus, 0, arreglo.length - 1);
    }

    private static int busquedaBinariaRecu(int[] arreglo, int valorBus, int ini, int fin) {
        if (ini > fin) return -1;

        int mid = ini + ((fin - ini) / 2);

        if (valorBus > arreglo[mid])
            return busquedaBinariaRecu(arreglo, valorBus, mid + 1, fin);
        else if (valorBus < arreglo[mid])
            return busquedaBinariaRecu(arreglo, valorBus, ini, mid - 1);
        else
            return mid;
    }
}
