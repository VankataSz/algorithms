package recursion;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseArray {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = reader.readLine().split("\\s+");

        reverseArray(array, array.length - 1);
    }

    private static void reverseArray(String[] array, int i) {

        if (i < 0) {
            return;
        }

        System.out.print(array[i] + " ");
        reverseArray(array, i - 1);
    }
}
