import java.util.*;

public class Ex7 {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.print("Passo " + (i + 1) + ": ");
            exibirVetor(arr);
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
            System.out.print("Passo " + (i + 1) + ": ");
            exibirVetor(arr);
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            System.out.print("Passo " + i + ": ");
            exibirVetor(arr);
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left);
            mergeSort(right);

            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                arr[k++] = (left[i] >= right[j]) ? left[i++] : right[j++];
            }
            while (i < left.length)
                arr[k++] = left[i++];
            while (j < right.length)
                arr[k++] = right[j++];
        }
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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número de pontuações:");
        int n = scanner.nextInt();
        int[] pontuacoes = new int[n];

        System.out.println("Digite as pontuações, uma por uma:");
        for (int i = 0; i < n; i++) {
            pontuacoes[i] = scanner.nextInt();
        }

        System.out.print("Pontuações Originais: ");
        exibirVetor(pontuacoes);

        int[] bubblePontuacoes = pontuacoes.clone();
        System.out.println("\nUsando Bubble Sort:");
        bubbleSort(bubblePontuacoes);
        System.out.print("Pontuações Ordenadas: ");
        exibirVetor(bubblePontuacoes);
        System.out.println("Pontuação Mais Alta: " + bubblePontuacoes[0]);

        int[] selectionPontuacoes = pontuacoes.clone();
        System.out.println("\nUsando Selection Sort:");
        selectionSort(selectionPontuacoes);
        System.out.print("Pontuações Ordenadas: ");
        exibirVetor(selectionPontuacoes);
        System.out.println("Pontuação Mais Alta: " + selectionPontuacoes[0]);

        int[] insertionPontuacoes = pontuacoes.clone();
        System.out.println("\nUsando Insertion Sort:");
        insertionSort(insertionPontuacoes);
        System.out.print("Pontuações Ordenadas: ");
        exibirVetor(insertionPontuacoes);
        System.out.println("Pontuação Mais Alta: " + insertionPontuacoes[0]);

        int[] mergePontuacoes = pontuacoes.clone();
        mergeSort(mergePontuacoes);
        System.out.println("\nUsando Merge Sort:");
        System.out.print("Pontuações Ordenadas: ");
        exibirVetor(mergePontuacoes);
        System.out.println("Pontuação Mais Alta: " + mergePontuacoes[0]);

        scanner.close();
    }
}
