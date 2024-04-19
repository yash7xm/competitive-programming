import java.util.Scanner;

public class Ambitious_Kid {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int el = in.nextInt();
            if (el < 0) {
                min = Math.min(min, -1 * el);
            } else {
                min = Math.min(min, el);
            }
        }

        System.out.println(min);
        in.close();
    }
}
