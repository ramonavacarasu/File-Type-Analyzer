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

        int i = 0;
        while (i < text.length() - pattern.length() + 1) {
            boolean patternIsFound = true;

            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    patternIsFound = false;
                    i++;
                    break;
                }
            }

            if (patternIsFound) {
                array.add(i);
                i += pattern.length();
            }
        }
    }
}