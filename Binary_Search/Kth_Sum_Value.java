import java.util.Arrays;
import java.util.Scanner;

public class Kth_Sum_Value {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            long k = in.nextLong();

            int[] arr = new int[n];
            int[] brr = new int[m];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < m; i++) {
                brr[i] = in.nextInt();
            }

            if (n > m) {
                int temp = n;
                n = m;
                m = temp;

                int[] tempArr = brr;
                brr = arr;
                arr = tempArr;
            }

            Arrays.sort(arr);
            Arrays.sort(brr);

            long lo = arr[0] + brr[0];
            long hi = arr[n - 1] + brr[m - 1];
            long ans = hi;

            while (lo <= hi) {
                long mid = lo + (hi - lo) / 2;
                if (check(arr, brr, mid, k) == 1) {
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

    private static int check(int[] arr, int[] brr, long x, long k) {
        long cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt += upperBound(brr, x - arr[i]);
        }
        return cnt >= k ? 1 : 0;
    }

    private static int upperBound(int[] brr, long x) {
        int n = brr.length;
        int lo = 0;
        int hi = n - 1;
        int ans = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (brr[mid] > x) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}
