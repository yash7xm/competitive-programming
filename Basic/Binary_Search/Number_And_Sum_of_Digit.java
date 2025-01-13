import java.util.Scanner;

public class Number_And_Sum_of_Digit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            long s = in.nextLong();

            long lo = 1;
            long hi = n;
            long ans = n + 1;
            while (lo <= hi) {
                long mid = lo + (hi - lo) / 2;
                long temp = mid;
                long sum = 0;
                while (temp > 0) {
                    sum += temp % 10;
                    temp /= 10;
                }

                if (mid - sum >= s) {
                    ans = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            System.out.println(n - ans + 1);
        }
        in.close();
    }
}
