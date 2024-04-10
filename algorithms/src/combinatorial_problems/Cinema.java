package combinatorial_problems;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Cinema {

    public static String[] seats;
    public static String[] combinations;
    public static List<String> peopleNames;
    public static boolean[] used;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        peopleNames = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        seats = new String[peopleNames.size()];

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("generate")) {

            String[] tokens = inputLine.split(" - ");
            String name = tokens[0];
            int position = Integer.parseInt(tokens[1]) - 1;

            seats[position] = name;
            peopleNames.remove(name);

            inputLine = scanner.nextLine();
        }

        combinations = new String[peopleNames.size()];
        used = new boolean[peopleNames.size()];

        permute(0);

    }

    private static void permute(int index) {

        if (index == combinations.length) {

            print();

        } else {
            for (int i = 0; i < peopleNames.size(); i++) {
                if (!used[i]) {
                    used[i] = true;
                    combinations[index] = peopleNames.get(i);
                    permute(index + 1);
                    used[i] = false;
                }
            }
        }

    }

    private static void print() {

        int index = 0;

        String[] out = new String[seats.length];

        for (int i = 0; i < out.length; i++) {

            if (seats[i] != null) {
                out[i] = seats[i];
            } else {
                out[i] = combinations[index++];
            }
        }
        System.out.println(String.join(" ", out));
    }
}
