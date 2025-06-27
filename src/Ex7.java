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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número de pontuações:");
        int n = scanner.nextInt();
        int[] pontuacoes = new int[n];

        System.out.println("Digite as pontuações, uma por uma:");
        for (int i = 0; i < n; i++) {
            pontuacoes[i] = scanner.nextInt();
        }

        System.out.println("Pontuações Originais: " + Arrays.toString(pontuacoes));

        int[] bubblePontuacoes = pontuacoes.clone();
        bubbleSort(bubblePontuacoes);
        System.out.println("\nUsando Bubble Sort:");
        System.out.println("Pontuações Ordenadas: " + Arrays.toString(bubblePontuacoes));
        System.out.println("Pontuação Mais Alta: " + bubblePontuacoes[0]);

        int[] selectionPontuacoes = pontuacoes.clone();
        selectionSort(selectionPontuacoes);
        System.out.println("\nUsando Selection Sort:");
        System.out.println("Pontuações Ordenadas: " + Arrays.toString(selectionPontuacoes));
        System.out.println("Pontuação Mais Alta: " + selectionPontuacoes[0]);

        int[] insertionPontuacoes = pontuacoes.clone();
        insertionSort(insertionPontuacoes);
        System.out.println("\nUsando Insertion Sort:");
        System.out.println("Pontuações Ordenadas: " + Arrays.toString(insertionPontuacoes));
        System.out.println("Pontuação Mais Alta: " + insertionPontuacoes[0]);

        int[] mergePontuacoes = pontuacoes.clone();
        mergeSort(mergePontuacoes);
        System.out.println("\nUsando Merge Sort:");
        System.out.println("Pontuações Ordenadas: " + Arrays.toString(mergePontuacoes));
        System.out.println("Pontuação Mais Alta: " + mergePontuacoes[0]);

        scanner.close();
    }
}
