import java.util.Arrays;
import java.util.Scanner;

public class Balanced_Round {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            Arrays.sort(arr);

            int len = 1;
            int res = -1;

            for (int i = 1; i < n; i++) {
                if (arr[i] - arr[i - 1] <= k) {
                    len++;
                } else {
                    res = Math.max(len, res);
                    len = 1;
                }
            }

            res = Math.max(len, res);

            System.out.println(n - res);
        }
        in.close();
    }
}
