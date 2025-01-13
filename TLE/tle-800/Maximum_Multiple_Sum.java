import java.util.Scanner;

public class Maximum_Multiple_Sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();

            int max = Integer.MIN_VALUE;
            int res = 1;

            for (int i = 2; i <= n; i++) {
                int sum = 0;
                for (int j = 1; j * i <= n; j++) {
                    sum += j * i;
                }

                if (sum > max) {
                    max = sum;
                    res = i;
                }
                max = Math.max(max, sum);
            }

            System.out.println(res);
        }
        in.close();
    }
}
