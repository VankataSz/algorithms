package recursion;

import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int factorialInputNumber = scanner.nextInt();

        long result = calculateFactorial(factorialInputNumber);

        System.out.println(result);

    }

    private static long calculateFactorial(int factorialInputNumber) {

            if(factorialInputNumber == 1) {
                return 1;
            }

            return factorialInputNumber * calculateFactorial(factorialInputNumber -1);
    }
}
