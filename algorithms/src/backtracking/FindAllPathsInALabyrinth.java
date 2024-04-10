package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllPathsInALabyrinth {

    static List<Character> path = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixRow = Integer.parseInt(scanner.nextLine());
        int matrixCol = Integer.parseInt(scanner.nextLine());

        char[][] labyrinth = new char[matrixRow][matrixCol];

        for (int row = 0; row < labyrinth.length; row++) {

            char[] singleRow = scanner.nextLine().toCharArray();

            for (int col = 0; col < matrixCol; col++) {

                labyrinth[row][col] = singleRow[col];
            }
        }

        findPath(labyrinth, 0, 0, ' ');

    }

    private static void findPath(char[][] labyrinth, int row, int col, char direction) {

        if (!isInBounds(labyrinth, row, col) || labyrinth[row][col] == 'V' || labyrinth[row][col] == '*') {
            return;
        }

        path.add(direction);

        if (labyrinth[row][col] == 'e') {
            printPath();
            path.remove(path.size() - 1);
            return;
        }

        labyrinth[row][col] = 'V';

        findPath(labyrinth, row + 1, col, 'D');
        findPath(labyrinth, row - 1, col, 'U');
        findPath(labyrinth, row, col + 1, 'R');
        findPath(labyrinth, row, col - 1, 'L');

        labyrinth[row][col] = '-';

        path.remove(path.size() - 1);
    }

    private static void printPath() {

        for (int i = 1; i < path.size() ; i++) {
            System.out.print(path.get(i));
        }
        System.out.println();
    }

    private static boolean isInBounds(char[][] labyrinth, int row, int col) {
        return row < labyrinth.length && row >= 0 && col < labyrinth[row].length && col >= 0;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}

