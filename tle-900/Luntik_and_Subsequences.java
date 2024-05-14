import java.util.Scanner;

public class Luntik_and_Subsequences {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int ones = 0;
            int zeroes = 0;
            for (int i = 0; i < n; i++) {
                int el = in.nextInt();
                if (el == 0) {
                    zeroes++;
                } else if (el == 1) {
                    ones++;
                }
            }

            System.out.println((long) Math.pow(2, zeroes) * ones);

        }
        in.close();
    }
}
