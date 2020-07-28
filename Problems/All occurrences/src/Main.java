import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Integer> array = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String patern = scanner.nextLine();
        String text = scanner.nextLine();

        if (!"".equals(patern)) {
            containsPattern(text, patern);
        } else {
            array.add(0);
        }

        System.out.println(array.size());
        for (int x : array) {
            System.out.print(x + " ");
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