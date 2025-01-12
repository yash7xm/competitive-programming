import java.util.Scanner;

public class TwoFrogs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();

            int x = a > b ? a - b : b - a;

            if (x % 2 != 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
        in.close();
    }
}
