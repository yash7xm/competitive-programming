import java.util.Scanner;

public class Magnitude {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int mod = 998244353;
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            long c1 = 0;
            long c2 = 0;
            int abs = 0;
            int nrm = 0;
            if (arr[0] >= 0) {
                c1 = arr[0];
                c2 = arr[0];
                abs = 1;
                nrm = 1;
            } else {
                c1 = arr[0];
                c2 = -arr[0];
                abs = 1;
                nrm = 0;
            }
            long[] a = new long[4];
            for (int i = 1; i < n; i++) {
                a[0] = Math.abs(arr[i] + c1);
                a[1] = arr[i] + c1;

                a[2] = Math.abs(arr[i] + c2);
                a[3] = arr[i] + c2;

                long max = Long.MIN_VALUE;
                long min = Long.MAX_VALUE;
                for (int j = 0; j < 4; j++) {
                    max = Math.max(a[j], max);
                    min = Math.min(a[j], min);
                }

                c1 = max;
                c2 = min;

                if (a[0] == c1 || a[2] == c1) {
                    abs++;
                }
                if (a[1] == c1 || a[3] == c1) {
                    nrm++;
                }

                System.out.println("abs-> " + abs + "nrm-> " + nrm);

            }

            System.out.println((abs * nrm) % mod);
        }
        in.close();
    }
}
