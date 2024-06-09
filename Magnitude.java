import java.util.Scanner;

public class Magnitude {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            long c1 = 0;
            long c2 = 0;
            if (arr[0] >= 0) {
                c1 = arr[0];
                c2 = arr[0];
            } else {
                c1 = arr[0];
                c2 = -arr[0];
            }
            long[] a = new long[4];
            for (int i = 1; i < n; i++) {
                a[0] = Math.abs(arr[i] + c1);
                a[1] = Math.abs(arr[i] + c2);
                a[2] = arr[i] + c1;
                a[3] = arr[i] + c2;

                long max = Long.MIN_VALUE;
                long min = Long.MAX_VALUE;
                for (int j = 0; j < 4; j++) {
                    max = Math.max(a[j], max);
                    min = Math.min(a[j], min);
                }

                System.out.println("c1 -> " + c1 + " " + "c2 -> " + c2);

                c1 = max;
                c2 = min;
            }

            System.out.println(Math.max(c1, c2));
        }
        in.close();
    }
}
