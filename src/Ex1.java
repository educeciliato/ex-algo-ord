public class Ex1 {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
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
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            System.out.print("Passo " + (i + 1) + ": ");
            exibirVetor(arr);
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int chave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > chave) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = chave;

            System.out.print("Passo " + i + ": ");
            exibirVetor(arr);
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
        int[] numeros = { 3, 4, 9, 2, 5, 8, 2, 1, 7 };

        System.out.print("Array Original: ");
        exibirVetor(numeros);

        bubbleSort(numeros.clone());
        selectionSort(numeros.clone());
        insertionSort(numeros.clone());
    }
}
