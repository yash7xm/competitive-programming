import java.util.Scanner;

public class Strange_Partition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            long x = in.nextLong();
            long maxSum = 0;
            long minSum = 0;

            for (int i = 0; i < n; i++) {
                long el = in.nextLong();
                minSum += el;
                maxSum += (long) Math.ceil(el * 1.0 / x * 1.0);
            }

            minSum = (long) Math.ceil(minSum * 1.0 / x * 1.0);

            System.out.println(minSum + " " + maxSum);
        }
        in.close();
    }
}
