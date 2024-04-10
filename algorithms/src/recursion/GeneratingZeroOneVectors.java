package recursion;

import java.util.Scanner;

public class GeneratingZeroOneVectors {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();

        Integer[] memory = new Integer[arraySize];

        fillVector(memory, 0);

    }

    private static void fillVector(Integer[] memory, int index) {

        if (index >= memory.length) {
            print(memory);
            return;
        }

        for (int i = 0; i <= 1; i++) {
            memory[index] = i;
            fillVector(memory, index + 1);
        }
    }

    private static void print(Integer[] memory) {

        for (Integer i : memory) {
            System.out.print(i);
        }

        System.out.println();
    }
}

