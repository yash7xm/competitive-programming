import java.util.Scanner;

public class GCD_sequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int breakIdx = 1;
            for (int i = 0; i < n - 2; i++) {
                if (gcd(arr[i], arr[i + 1]) > gcd(arr[i + 1], arr[i + 2])) {
                    breakIdx = i + 1;
                    break;
                }
            }

            boolean res = false;
            if (!res)
                res = check(arr, breakIdx);
            if (!res)
                res = check(arr, breakIdx - 1);
            if (!res)
                res = check(arr, breakIdx + 1);

            if (res) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private static boolean check(int[] arr, int k) {
        int[] a = new int[arr.length - 1];
        int j = 0;
        for (int i = 0; i < k; i++, j++) {
            a[j] = arr[i];
        }
        for (int i = k + 1; i < arr.length; i++, j++) {
            a[j] = arr[i];
        }

        for (int i = 0; i < a.length - 2; i++) {
            if (gcd(a[i], a[i + 1]) > gcd(a[i + 1], a[i + 2])) {
                return false;
            }
        }
        return true;
    }
}
