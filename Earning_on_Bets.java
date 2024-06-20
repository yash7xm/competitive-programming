import java.util.Scanner;

public class Earning_on_Bets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];

            long hi = (long) 1e9;

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            long[] ans = new long[n];

            if (check(arr, ans, hi) == 1) {
                for (int i = 0; i < n; i++) {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
        in.close();
    }

    private static int check(int[] arr, long[] ans, long mid) {
        long sumLeft = mid;
        for (int i = 0; i < arr.length; i++) {
            if (((mid / arr[i]) + 1) <= sumLeft) {
                ans[i] = (mid / arr[i]) + 1;
                sumLeft -= ans[i];
            } else {
                break;
            }
        }
        return sumLeft <= 0 ? 1 : 0;
    }
}
