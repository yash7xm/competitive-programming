import java.util.Arrays;
import java.util.Scanner;

public class ThePartyAndSweets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }

        long[] brr = new long[m];
        long sum = 0;
        for (int i = 0; i < m; i++) {
            brr[i] = in.nextLong();
            sum += brr[i];
        }

        Arrays.sort(arr);
        Arrays.sort(brr);

        long res = 0;
        boolean flag = false;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] <= brr[0]) {
                if (i == n - 1) {
                    if (arr[i] < brr[0]) {
                        res += sum - brr[0] + arr[i];
                    } else {
                        res += sum;
                        flag = true;
                    }
                } else {
                    if (!flag) {
                        res += brr[0] + (m - 1) * arr[i];
                        flag = true;
                    } else {
                        res += arr[i] * m;
                    }
                }
            } else {
                res = -1;
                break;
            }
        }

        if (!flag)
            res = -1;
        System.out.println(res);
        in.close();
    }
}
