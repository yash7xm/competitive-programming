import java.util.Scanner;

public class Make_AP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            int ma = 0;
            int mb = 0;
            int mc = 0;

            if (((2 * b - c) != 0) && ((2 * b - c) % (a)) == 0) {
                ma = (2 * b - c) / a;
            }
            if (((2 * b - a) != 0) && ((2 * b - a) % (c)) == 0) {
                mc = (2 * b - a) / c;
            }
            if (((a + c) % (2 * b)) == 0) {
                mb = (a + c) / (2 * b);
            }

            if (ma > 0 || mb > 0 || mc > 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }
}
