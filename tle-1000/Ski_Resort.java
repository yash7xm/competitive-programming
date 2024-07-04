import java.util.Scanner;

public class Ski_Resort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int q = in.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            long ans = 0;
            int len = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i] <= q) {
                    len++;
                } else {
                    if (len >= k) {
                        ans += (long) (len - k + 1) * (len - k + 2) / 2;
                    }
                    len = 0;
                }
            }

            if (len >= k) {
                ans += (long) (len - k + 1) * (len - k + 2) / 2;
            }

            System.out.println(ans);
        }

        in.close();
    }
}
