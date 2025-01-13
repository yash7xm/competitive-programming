import java.util.Scanner;

public class Chess_For_Three {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int p1 = in.nextInt();
            int p2 = in.nextInt();
            int p3 = in.nextInt();

            int ans = 0;

            if ((p1 + p2 + p3) % 2 != 0) {
                ans = -1;
            } else if ((p1 + p2) <= p3) {
                ans = p1 + p2;
            } else if ((p1 + p2) > p3) {
                ans = (p1 + p2 + p3) / 2;
            }

            System.out.println(ans);
        }
        in.close();
    }
}
