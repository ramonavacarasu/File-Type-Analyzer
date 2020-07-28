import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pattern = scanner.next();
        if (scanner.hasNext()) {
            String text = scanner.next();
            if (containsPattern(text, pattern)) {
                System.out.println(text.indexOf(pattern));
            } else {
                System.out.println(-1);
            }
        } else {
            System.out.println(0);
        }


    }

    public static boolean containsPattern(String text, String pattern) {
        if (text.length() < pattern.length()) {
            return false;
        }

        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
            boolean patternIsFound = true;

            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    patternIsFound = false;
                    break;
                }
            }

            if (patternIsFound) {
                return true;
            }
        }

        return false;
    }
}