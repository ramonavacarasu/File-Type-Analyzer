import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> array = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pattern = scanner.nextLine();
        String text = scanner.nextLine();

        if (!"".equals(pattern)) {
            containsPattern(text, pattern);
        } else {
            array.add(0);
        }

        System.out.println(array.size());
        for (int x : array) {
            System.out.print(x + " ");
        }
    }

    public static void containsPattern(String text, String pattern) {

        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                array.add(i - j + 1);
                j = 0;
            }
        }
    }

}