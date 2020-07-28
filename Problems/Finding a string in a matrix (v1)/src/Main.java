import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> array = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pattern = scanner.next();
        int rows = scanner.nextInt();
        int chars = scanner.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            sb.append(scanner.next());
        }

        String text = sb.toString();

        if (!"".equals(pattern)) {
            containsPattern(text, pattern);
        } else {
            array.add(0);
        }

        System.out.println(array.size());

        for (int x : array) {
            System.out.println(x / chars + " " + x % chars);
        }

    }

    public static void containsPattern(String text, String pattern) {

        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
            boolean patternIsFound = true;

            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    patternIsFound = false;
                    break;
                }
            }

            if (patternIsFound) {
                array.add(i);
            }
        }
    }
}
