import java.util.*;

public class Ex2 {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int chave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < chave) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = chave;
        }
    }

    public static void mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private static void mergeSortHelper(int[] arr, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            mergeSortHelper(arr, esquerda, meio);
            mergeSortHelper(arr, meio + 1, direita);

            mergeDecrescente(arr, esquerda, meio, direita);
        }
    }

    private static void mergeDecrescente(int[] arr, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, esquerda, L, 0, n1);
        System.arraycopy(arr, meio + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = esquerda;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] numeros = { 3, 0, -2, 5, 8 };

        System.out.println("Array Original: " + Arrays.toString(numeros));

        int[] bubbleArr = numeros.clone();
        bubbleSort(bubbleArr);
        System.out.println("Bubble Sort Decrescente: " + Arrays.toString(bubbleArr));

        int[] selectionArr = numeros.clone();
        selectionSort(selectionArr);
        System.out.println("Selection Sort Decrescente: " + Arrays.toString(selectionArr));

        int[] insertionArr = numeros.clone();
        insertionSort(insertionArr);
        System.out.println("Insertion Sort Decrescente: " + Arrays.toString(insertionArr));

        int[] mergeArr = numeros.clone();
        mergeSort(mergeArr);
        System.out.println("Merge Sort Decrescente: " + Arrays.toString(mergeArr));
    }
}
