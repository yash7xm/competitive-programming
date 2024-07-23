import java.util.Scanner;

public class Beautiful_Array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long k = in.nextLong();
            long b = in.nextLong();
            long s = in.nextLong();

            if (b > s / k) {
                System.out.println(-1);
            } else if (b == s / k) {
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(0 + " ");
                }
                System.out.print(s);
                System.out.println();
            } else {
                long[] arr = new long[n];
                for (int i = 0; i < n; i++) {
                    if (i == 0) {
                        arr[i] = (b * k) + (k - 1);
                    } else {
                        if (s >= k - 1) {
                            arr[i] = k - 1;
                        } else {
                            arr[i] = s;
                        }
                    }
                    s -= arr[i];
                    if (s <= 0)
                        break;
                }
                if (s != 0) {
                    System.out.println(-1);
                } else {
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                }
            }
        }
        in.close();
    }
}
