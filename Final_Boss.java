import java.util.Scanner;

public class Final_Boss {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int h = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            int[] c = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                c[i] = in.nextInt();
            }

            long lo = 1;
            long hi = 1;
            if (h % arr[0] == 0) {
                hi = (1 + (long) (((long) (h / arr[0])) - 1) * c[0]);
            } else {
                hi = (1 + (long) (((h / arr[0]))) * c[0]);
            }
            long ans = hi;

            while (lo <= hi) {
                long mid = lo + (hi - lo) / 2;
                if (check(arr, c, mid, h) == 1) {
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

    private static int check(int[] a, int[] c, long mid, int h) {
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (mid % c[i] == 0) {
                sum += (mid / c[i]) * a[i];
            } else {
                sum += ((mid / c[i]) + 1) * a[i];
            }
            if (sum >= h)
                return 1;
        }
        return 0;
    }
}
