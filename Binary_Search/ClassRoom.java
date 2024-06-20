import java.util.Arrays;
import java.util.Scanner;

public class ClassRoom {
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
            int lo = 0;
            int hi = arr[n - 1] - arr[0];
            for (int i = 1; i < n; i++) {
                lo = Math.min(lo, arr[i] - arr[i - 1]);
            }

            int ans = lo;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (check(arr, mid, k) == 1) {
                    ans = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            System.out.println(ans);
        }
        in.close();
    }

    private static int check(int[] arr, int x, int k) {
        int cnt = 1;
        int lastSeated = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[lastSeated] >= x) {
                cnt++;
                lastSeated = i;
            }
        }
        return cnt >= k ? 1 : 0;
    }
}
