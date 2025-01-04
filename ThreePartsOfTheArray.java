import java.util.Scanner;

public class ThreePartsOfTheArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        long[] p = new long[n];
        for (int i = 0; i < n; i++) {
            p[i] = arr[i];
            if (i != 0) {
                p[i] += p[i - 1];
            }
        }

        long[] s = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            s[i] = arr[i];
            if (i != n - 1) {
                s[i] += s[i + 1];
            }
        }

        long res = 0;
        int i = 0, j = n - 1;
        while (i < j) {
            if (p[i] == s[j]) {
                res = Math.max(res, p[i]);
                i++;
                j--;
            } else if (p[i] < s[j]) {
                i++;
            } else {
                j--;
            }
        }

        System.out.println(res);
        in.close();
    }
}
