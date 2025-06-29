import java.util.Scanner;

public class Ex3 {

    public static void bubbleSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            String temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(String[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            String chave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(chave) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = chave;
        }
    }

    public static void mergeSort(String[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private static void mergeSortHelper(String[] arr, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            mergeSortHelper(arr, esquerda, meio);
            mergeSortHelper(arr, meio + 1, direita);
            merge(arr, esquerda, meio, direita);
        }
    }

    private static void merge(String[] arr, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        String[] L = new String[n1];
        String[] R = new String[n2];

        System.arraycopy(arr, esquerda, L, 0, n1);
        System.arraycopy(arr, meio + 1, R, 0, n2);

        int i = 0, j = 0, k = esquerda;

        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    public static void exibirVetor(String[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a quantidade de strings: ");
        int n = Integer.parseInt(sc.nextLine());

        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite a string #" + (i + 1) + ": ");
            strings[i] = sc.nextLine();
        }

        System.out.print("\nVetor de Strings Original: ");
        exibirVetor(strings);

        String[] bubbleStr = strings.clone();
        bubbleSort(bubbleStr);
        System.out.print("Bubble Sort Strings: ");
        exibirVetor(bubbleStr);

        String[] selectionStr = strings.clone();
        selectionSort(selectionStr);
        System.out.print("Selection Sort Strings: ");
        exibirVetor(selectionStr);

        String[] insertionStr = strings.clone();
        insertionSort(insertionStr);
        System.out.print("Insertion Sort Strings: ");
        exibirVetor(insertionStr);

        String[] mergeStr = strings.clone();
        mergeSort(mergeStr);
        System.out.print("Merge Sort Strings: ");
        exibirVetor(mergeStr);

        sc.close();
    }
}
