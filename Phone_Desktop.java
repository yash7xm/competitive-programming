import java.util.Scanner;

public class Phone_Desktop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();

            int n = 0;

            n = (int) Math.ceil((double) y / 2);

            int rem = 0;
            if ((y % 2) == 1) {
                rem = ((7 * (y / 2)) + 11);
            } else {
                rem = (7 * (y / 2));
            }

            if (x <= rem) {
                System.out.println(n);
            } else {
                int num = x - rem;
                int extra = (int) Math.ceil((double) num / 15);
                n += extra;
                System.out.println(n);
            }

        }
        in.close();
    }
}
