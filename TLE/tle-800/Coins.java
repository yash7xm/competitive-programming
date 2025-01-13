import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            long n = in.nextLong();
            long k = in.nextLong();

            if (n % 2 == 0 || n % k == 0)
                System.out.println("YES");
            else if (k % 2 != 0)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
        in.close();
    }
}
