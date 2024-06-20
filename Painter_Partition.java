import java.util.Scanner;

public class Painter_Partition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            long lo = 1;
            long hi = 0;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                hi += arr[i];
            }

            long ans = 1;

            while (lo <= hi) {
                long mid = lo + (hi - lo) / 2;
                if (check(arr, mid, k) == 1) {
                    ans = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            System.out.println(ans);
        }
        in.close();
    }

    private static int check(int[] arr, long x, int k) {
        long rem = 0;
        int needed = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= rem) {
                rem -= arr[i];
            } else {
                needed++;
                if (needed > k)
                    return 0;
                rem = x;
                if (rem >= arr[i]) {
                    rem = x - arr[i];
                } else {
                    return 0;
                }
            }
        }
        return 1;
    }
}
