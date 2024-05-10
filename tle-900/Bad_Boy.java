import java.util.Scanner;

public class Bad_Boy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int i = in.nextInt();
            int j = in.nextInt();
            int x1 = -1;
            int x2 = -1;
            int x3 = -1;
            int x4 = -1;

            x1 = 1;
            x2 = 1;
            x3 = n;
            x4 = m;

            System.out.println(x1 + " " + x2 + " " + x3 + " " + x4);
            System.out.println(i + " " + j); // not part of solution
        }
        in.close();
    }
}
