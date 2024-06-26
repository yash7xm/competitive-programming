import java.util.Scanner;

public class Boring_Day {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int l = in.nextInt();
            int r = in.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int lo = 0;
            int hi = n;
            int ans = lo;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (check(arr, mid, l, r) == 1) {
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

    private static int check(int[] arr, int k, int l, int r) {
        int roundsWon = 0;
        int sum = 0;
        int start = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            while (sum > r && start <= i) {
                sum -= arr[start];
                start++;
            }

            if (sum >= l && sum <= r) {
                sum = 0;
                roundsWon++;
                start = i + 1;
            }
        }

        if (roundsWon >= k)
            return 1;
        return 0;
    }
}
