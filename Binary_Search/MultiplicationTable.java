import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long lo = 1;
        long hi = (long) n * n;
        long ans = hi;
        long k = (long) ((hi) / 2) + 1;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (check(n, mid, k) == 1) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(ans);
        in.close();
    }

    private static int check(int n, long x, long k) {
        long cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += upperBound(n, x / i);
        }
        return cnt >= k ? 1 : 0;
    }

    private static int upperBound(int n, long x) {
        int lo = 1;
        int hi = n;
        int ans = n + 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid > x) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans - 1;
    }
}
