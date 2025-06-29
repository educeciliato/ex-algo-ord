public class Ex2 {
    public static void bubbleSortDecrescente(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSortDecrescente(int[] arr) {
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

    public static void insertionSortDecrescente(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int chave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < chave) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = chave;
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
        int[] numeros = { 3, 0, -2, 5, 8 };

        System.out.print("Array Original: ");
        exibirVetor(numeros);

        int[] arr1 = numeros.clone();
        bubbleSortDecrescente(arr1);
        System.out.print("Bubble Sort Decrescente: ");
        exibirVetor(arr1);

        int[] arr2 = numeros.clone();
        selectionSortDecrescente(arr2);
        System.out.print("Selection Sort Decrescente: ");
        exibirVetor(arr2);

        int[] arr3 = numeros.clone();
        insertionSortDecrescente(arr3);
        System.out.print("Insertion Sort Decrescente: ");
        exibirVetor(arr3);
    }
}
