import java.util.Scanner;

public class Permutation_Swap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int a = Math.abs(arr[0] - 1);
            for (int i = 2; i <= n; i++) {
                int b = Math.abs(arr[i - 1] - i);
                a = gcd(a, b);
            }

            System.out.println(a);
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
