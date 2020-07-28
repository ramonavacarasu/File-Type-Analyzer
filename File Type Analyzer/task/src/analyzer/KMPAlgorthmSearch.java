package analyzer;

public class KMPAlgorthmSearch {

    public static boolean KMPSearch(String text, String pattern) {

        int[] prefixFunc = prefixFunction(pattern);

        boolean foundPattern = true;
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = prefixFunc[j - 1];
                foundPattern = false;
            }

            if (text.charAt(i) == pattern.charAt(j)) {
                j += 1;
            }

            if (j == pattern.length()) {
                foundPattern = true;
                break;
            }
        }

        return foundPattern;
    }

    public static int[] prefixFunction(String str) {

        int[] prefixFunc = new int[str.length()];

        for (int i = 1; i < str.length(); i++) {

            int j = prefixFunc[i - 1];

            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = prefixFunc[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                j += 1;
            }

            prefixFunc[i] = j;
        }

        return prefixFunc;
    }
}
