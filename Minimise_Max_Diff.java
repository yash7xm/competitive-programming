import java.util.Scanner;

public class Minimise_Max_Diff {
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

            int lo = 1;
            int hi = 0;
            int ans = 0;

            for (int i = 1; i < n; i++) {
                hi = Math.max(hi, arr[i] - arr[i - 1]);
            }

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
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

    private static int check(int[] arr, int x, int k) {
        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            int d = arr[i] - arr[i - 1];
            cnt += ((d + x - 1) / x) - 1;
        }
        return cnt <= k ? 1 : 0;
    }
}
