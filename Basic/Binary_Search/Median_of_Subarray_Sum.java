import java.util.Scanner;

public class Median_of_Subarray_Sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();

            long lo = 0;
            long hi = 0;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                lo = Math.min(arr[i], lo);
                hi += arr[i];
            }

            long ans = -1;
            long total = (n * (n + 1)) / 2;
            long k = (total + 1) / 2;

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

    private static int check(int[] arr, long mid, long k) {
        long cnt = 0;
        long curr = 0;
        int start = 0;
        int i = 0;

        while (i < arr.length) {
            curr += arr[i];
            while (start <= i && curr > mid) {
                curr -= arr[start];
                start++;
            }
            cnt += (i - start + 1);
            i++;
        }
        return cnt >= k ? 1 : 0;
    }
}
