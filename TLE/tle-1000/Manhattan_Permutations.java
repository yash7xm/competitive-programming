import java.util.Scanner;

public class Manhattan_Permutations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long k = in.nextLong();

            if (n % 2 == 0) {
                if (k > 2 * ((n / 2) * (n / 2))) {
                    System.out.println("NO");
                }
            } else if (n % 2 == 1) {
                if (k > 2 * ((n / 2) * ((n / 2) + 1))) {
                    System.out.println("NO");
                }
            }
        }
        in.close();
    }
}
