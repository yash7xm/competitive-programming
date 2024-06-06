import java.util.Scanner;

public class Guess_the_Maximum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n - 1; i++) {
                int max = Math.max(arr[i], arr[i+1]);
                res = Math.min(max, res);
            }

            System.out.println(res - 1);
        }
        in.close();
    }
}
