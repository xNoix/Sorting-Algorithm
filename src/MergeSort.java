
public class MergeSort {

    private static void printArray(int[] array) {
        for (int i: array ) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    static int comparatives = 0;

    public static void sort(int arr[]){
        sort(arr, 0, arr.length - 1 );
    }
    public static void sort(int arr[], int left, int right){
        if(left < right){
            //Encuentra el punto medio del vector.
            int middle = (left + right) / 2;

            //Divide la primera y segunda mitad (llamada recursiva).
            sort(arr, left, middle);
            sort(arr, middle+1, right);

            //Une las mitades.
            merge(arr, left, middle, right);
        }
    }

    public static void merge(int arr[], int left, int middle, int right) {
        //Encuentra el tamaño de los sub-vectores para unirlos.
        int n1 = middle - left + 1;
        int n2 = right - middle;

        //Vectores temporales.
        int leftArray[] = new int [n1];
        int rightArray[] = new int [n2];

        //Copia los datos a los arrays temporales.
        for (int i=0; i < n1; i++) {
            leftArray[i] = arr[left+i];
        }
        for (int j=0; j < n2; j++) {
            rightArray[j] = arr[middle + j + 1];
        }
        /* Une los vectorestemporales. */

        //Índices inicial del primer y segundo sub-vector.
        int i = 0, j = 0;

        //Índice inicial del sub-vector arr[].
        int k = left;

        //Ordenamiento.
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
                comparatives++;
            } else {
                arr[k] = rightArray[j];
                j++;
                comparatives++;
            }
            comparatives+=2;
            k++;
        }//Fin del while.

        /* Si quedan elementos por ordenar */
        //Copiar los elementos restantes de leftArray[].
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
            comparatives++;
        }
        //Copiar los elementos restantes de rightArray[].
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
            comparatives++;
        }
    }

    public static void main(String[] args) {
        int [] array1 = {79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
        int [] array2 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79};
        int [] array3 = {40,44,62,79,17,31,12,7,60,54,24,1,22,26,61,2,66,25,58,72,74,46,6,57,37,29,53,48,63,47,39,23,56,75,35,19,34,64,4,69,41,13,73,55,43,27,20,28,65,67,50,49,3,9,52};
       System.out.println("Array inicial: ");
        printArray(array1);

        sort(array1);
        System.out.println("Array ordenado: ");
        printArray(array1);
        System.out.println("Para dijitos n igual : " + array1.length );
        System.out.println("El numero de comparaciones fue: " + comparatives);
    }
}

