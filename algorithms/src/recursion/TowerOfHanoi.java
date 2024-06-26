package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class TowerOfHanoi {

    public static StringBuilder out = new StringBuilder();
    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();
    public static int steps = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int disks = Integer.parseInt(reader.readLine());

        for (int i = disks; i >= 1; i--) {
            source.push(i);
        }

        printRods();
        solve(disks, source, destination, spare);
        System.out.println(out);

    }

    private static void solve(int disks, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {

        if (disks == 1) {

            destination.push(source.pop());

            out.append("Step #")
                    .append(steps)
                    .append(": Moved disk")
                    .append(System.lineSeparator());

            steps++;
            printRods();

        } else {

            solve(disks - 1, source, spare, destination);
            solve(1, source, destination, spare);
            solve(disks - 1, spare, destination, source);
        }


    }

    private static void printRods() {

        out.append(String.format("Source: %s%nDestination: %s%nSpare: %s%n%n",
                        formatRod(source),
                        formatRod(destination),
                        formatRod(spare)))
                .append(System.lineSeparator());
    }

    private static String formatRod(Deque<Integer> stack) {

        return stack.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
