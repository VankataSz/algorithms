package recursion;

import java.util.Scanner;

public class RecursiveDrawing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfRows = Integer.parseInt(scanner.nextLine());

        drawFigure(numberOfRows);

    }

    private static void drawFigure(int numberOfRows) {

        if (numberOfRows == 0) {
            return;
        }

        for (int i = 0; i < numberOfRows; i++) {
            System.out.print("*");
        }

        System.out.println();

        drawFigure(numberOfRows - 1);

        for (int i = 0; i < numberOfRows; i++) {

            System.out.print("#");

        }

        System.out.println();

    }
}
