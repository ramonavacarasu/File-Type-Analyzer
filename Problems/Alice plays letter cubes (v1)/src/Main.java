
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        //int k = scanner.nextInt();

        //for (int i = 0; i < k; i++)  {
        //    String newInput = scanner.next() + input;

            Set<String> set = new HashSet<>();

            for (int j = 0; j <= input.length(); j++) {
                for (int l = 0; l <= j; l++) {
                    //if (!input.contains(newInput.substring(l, j))) {
                        set.add(input.substring(l, j));
                    //}
                }
            }

            System.out.print(set.size() + 1 + " ");

            //System.out.println(set);
        //}
    }   
}