import java.util.Scanner;

public class Inc_Dec_Copy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n + 1];

            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            for (int i = 0; i <= n; i++) {
                b[i] = in.nextInt();
            }

            int min = Integer.MAX_VALUE;
            long res = 1;
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                res += Math.abs(a[i] - b[i]);
                int num1 = Math.min(a[i], b[i]);
                int num2 = Math.max(a[i], b[i]);
                if (b[n] >= num1 && b[n] <= num2) {
                    flag = true;
                }
                min = Math.min(min, Math.abs(num2 - b[n]));
                min = Math.min(min, Math.abs(num1 - b[n]));
            }

            if (!flag)
                res += min;

            System.out.println(res);
        }
        in.close();
    }
}
