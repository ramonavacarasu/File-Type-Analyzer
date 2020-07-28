import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();


    }

    public int[] prefixFunction(String s) {
        int n = s.length();
        int[] pi = new  int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];

            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                pi[i] = j;
            }

        }
        return pi;
    }
}