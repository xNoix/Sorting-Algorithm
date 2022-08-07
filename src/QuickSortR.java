import java.util.Random;

public class QuickSortR {

    static int comparatives = 0;
    private static void printArray(int[] array) {
        for (int i: array ) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void quickSortR(int [] A){
        quickSortR(A, 0, A.length - 1 );
    }
    private static void quickSortR(int [] A, int start, int end) {

        if (start >= end) return;

        int pivotIndex = new Random().nextInt(end - start) + start;
        int pivot = A[pivotIndex];
        Swap(A, pivotIndex, end);

        int leftP = partition(A, start, end, pivot);

        quickSortR(A, start, leftP - 1);
        quickSortR(A, leftP + 1, end);
    }
    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer < rightPointer) {

            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
                comparatives+= 2;
            }

            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
                comparatives+= 2;
            }

            Swap(array, leftPointer, rightPointer);
        }

        if(array[leftPointer] > array[highIndex]) {
            Swap(array, leftPointer, highIndex);
            comparatives++;
        }
        else {
            leftPointer = highIndex;
            comparatives++;
        }

        return leftPointer;
    }
    private static void Swap(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }

    public static void main(String[] args) {
        int [] array1 = {79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
        int [] array2 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79};
        int [] array3 = {0,59,36,10,71,77,78,51,21,18,42,5,16,15,33,76,32,38,70,11,30,45,14,8,68,40,44,62,79,17,31,12,7,60,54,24,1,22,26,61,2,66,25,58,72,74,46,6,57,37,29,53,48,63,47,39,23,56,75,35,19,34,64,4,69,41,13,73,55,43,27,20,28,65,67,50,49,3,9,52};
        System.out.println("Array inicial: ");
        printArray(array3);

        quickSortR(array3);
        System.out.println("Array ordenado: ");
        printArray(array3);
        System.out.println("Para dijitos n igual : " + array3.length );
        System.out.println("El numero de comparaciones fue: " + comparatives);
    }
}
