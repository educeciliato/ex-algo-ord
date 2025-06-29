import java.util.Scanner;

public class Ex4 {

    public static void bubbleSortParcial(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSortParcial(int[] arr, int n) {
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
        }
    }

    public static void insertionSortParcial(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int chave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > chave) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = chave;
        }
    }

    public static void mergeSortParcial(int[] arr, int left, int right) {
        if (left < right) {
            int meio = left + (right - left) / 2;
            mergeSortParcial(arr, left, meio);
            mergeSortParcial(arr, meio + 1, right);
            mergeParcial(arr, left, meio, right);
        }
    }

    private static void mergeParcial(int[] arr, int left, int meio, int right) {
        int n1 = meio - left + 1;
        int n2 = right - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, meio + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];

    }

    public static void exibirVetor(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a quantidade de números do vetor: ");
        int tamanho = sc.nextInt();

        int[] vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            vetor[i] = sc.nextInt();
        }

        System.out.print("Digite o valor de N (quantos primeiros elementos ordenar): ");
        int N = sc.nextInt();

        if (N > tamanho || N < 1) {
            System.out.println("Valor inválido para N.");
            sc.close();
            return;
        }

        int[] bubbleArr = vetor.clone();
        int[] selectionArr = vetor.clone();
        int[] insertionArr = vetor.clone();
        int[] mergeArr = vetor.clone();

        bubbleSortParcial(bubbleArr, N);
        System.out.print("Bubble Sort Parcial: ");
        exibirVetor(bubbleArr);

        selectionSortParcial(selectionArr, N);
        System.out.print("Selection Sort Parcial: ");
        exibirVetor(selectionArr);

        insertionSortParcial(insertionArr, N);
        System.out.print("Insertion Sort Parcial: ");
        exibirVetor(insertionArr);

        mergeSortParcial(mergeArr, 0, N - 1);
        System.out.print("Merge Sort Parcial: ");
        exibirVetor(mergeArr);

        sc.close();
    }
}
