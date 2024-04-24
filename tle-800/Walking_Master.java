import java.util.Scanner;

public class Walking_Master {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();

            if (d > b) {
                int h = d - b;
                int incA = a + h;
                if (c <= incA) {
                    int ans = h + incA - c;
                    System.out.println(ans);
                } else {
                    System.out.println(-1);
                }
            } else if (d == b && c <= a) {
                System.out.println(a - c);
            } else {
                System.out.println(-1);
            }
        }
        in.close();
    }
}
