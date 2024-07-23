import java.util.Scanner;

public class Minimum_LCM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();

            int max = Integer.MIN_VALUE;
            int[] res = new int[2];

            for (int i = 1; i <= n / 2; i++) {
                int g = gcd(i, n - i);
                if (g > max) {
                    max = g;
                    res[0] = i;
                    res[1] = n - i;
                }
            }

            System.out.println(res[0] + " " + res[1]);
        }
        in.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
