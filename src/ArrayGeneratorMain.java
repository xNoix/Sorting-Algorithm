import java.util.Random;

public class ArrayGeneratorMain {

    public static void main(String[] args) {

        int[] c = new int[60];

        for (int j = 0; j < 60; j++) {
            Random random = new Random();
            c[j] = random.nextInt(Integer.MAX_VALUE);
        }

        System.out.println(c);
    }

    private static void printArray(int[] array) {
        for (int i: array ) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
