import java.util.Scanner;

public class Vasilije_in_Cacak {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            long n = in.nextLong();
            long k = in.nextLong();
            long x = in.nextLong();

            long min = (k * (k + 1)) / 2;
            long max = ((n * (n + 1)) / 2) - (((n - k) * (n - k + 1)) / 2);

            if (x >= min && x <= max) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }
}
