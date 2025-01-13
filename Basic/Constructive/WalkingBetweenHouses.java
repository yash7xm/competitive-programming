import java.util.Scanner;
import java.util.Arrays;

public class WalkingBetweenHouses {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long k = in.nextLong();
        long s = in.nextLong();

        long[] arr = new long[(int) k];
        Arrays.fill(arr, 1);
        long maxBound = k * (n - 1);
        if (s < k || s > maxBound) {
            System.out.println("NO");
            in.close();
            return;
        } else {
            for (int i = 0; i < k; i++) {
                if (s - (k - i - 1) <= (n - 1)) {
                    arr[i] = s - (k - i - 1);
                    break;
                } else {
                    arr[i] = n - 1;
                    s -= n - 1;
                }
            }
        }

        System.out.println("YES");
        long start = 1;
        long[] ans = new long[(int) k];
        for (int i = 0; i < k; i++) {
            if (start + arr[i] <= n) {
                ans[i] = start + arr[i];
                start = ans[i];
            } else {
                ans[i] = start - arr[i];
                start = ans[i];
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

        in.close();
    }
}
