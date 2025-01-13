import java.util.Scanner;

public class Odd_Divisor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            long n = in.nextLong();

            if ((n & (n - 1)) != 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }
}
