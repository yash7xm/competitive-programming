import java.util.Scanner;

public class Consecutive_one {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] arr = new int[n];
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                p[i] = arr[i];
                if (i > 0)
                    p[i] += p[i - 1];
            }

            int lo = 1;
            int hi = n;
            int ans = 0;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (check(p, mid, k) == 1) {
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

    private static int check(int[] p, int x, int k) {
        int n = p.length;
        for (int i = 0; i < n - x + 1; i++) {
            int l = i;
            int r = i + x - 1;
            int numZero = x - (p[r] - (l > 0 ? p[l - 1] : 0));
            if (numZero <= k)
                return 1;
        }
        return 0;
    }
}
