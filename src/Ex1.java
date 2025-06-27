import java.util.*;

public class Ex1 {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        System.out.println("Passos do Bubble Sort:");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("Passo " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        System.out.println("Passos do Selection Sort:");
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            System.out.println("Passo " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        System.out.println("Passos do Insertion Sort:");
        for (int i = 1; i < n; i++) {
            int chave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > chave) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = chave;
            System.out.println("Passo " + i + ": " + Arrays.toString(arr));
        }
    }

    public static void mergeSort(int[] arr) {
        System.out.println("Passos do Merge Sort:");
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private static void mergeSortHelper(int[] arr, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            mergeSortHelper(arr, esquerda, meio);
            mergeSortHelper(arr, meio + 1, direita);
            merge(arr, esquerda, meio, direita);
        }
    }

    private static void merge(int[] arr, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, esquerda, L, 0, n1);
        System.arraycopy(arr, meio + 1, R, 0, n2);
        int i = 0, j = 0;
        int k = esquerda;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
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
        System.out.println("Mesclando: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] numeros = { 3, 4, 9, 2, 5, 8, 2, 1, 7 };

        System.out.println("Array Original: " + Arrays.toString(numeros));

        int[] bubbleArr = numeros.clone();
        bubbleSort(bubbleArr);

        int[] selectionArr = numeros.clone();
        selectionSort(selectionArr);

        int[] insertionArr = numeros.clone();
        insertionSort(insertionArr);

        int[] mergeArr = numeros.clone();
        mergeSort(mergeArr);
    }
}
