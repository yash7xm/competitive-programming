import java.util.Scanner;
import java.awt.Point;
import java.util.HashSet;

public class Forked {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int xk = in.nextInt();
            int yk = in.nextInt();
            int xq = in.nextInt();
            int yq = in.nextInt();

            int[][] k = new int[8][8];
            int[][] q = new int[8][8];

            fill(k, a, b, xk, yk);
            fill(q, a, b, xq, yq);

            int res = (findIntersection(k, q));
            System.out.println(res);
        }
        in.close();
    }

    public static int findIntersection(int[][] k, int[][] q) {
        HashSet<Point> set = new HashSet<>();

        for (int i = 0; i < 8; i++) {
            int kx = k[i][0];
            int ky = k[i][1];
            for (int j = 0; j < 8; j++) {
                if (q[j][0] == kx && q[j][1] == ky) {
                    set.add(new Point(kx, ky));
                }
            }
        }

        return set.size();
    }

    public static void fill(int[][] arr, int a, int b, int x, int y) {
        arr[0][0] = x + a;
        arr[0][1] = y + b;

        arr[1][0] = x + a;
        arr[1][1] = y - b;

        arr[2][0] = x - a;
        arr[2][1] = y + b;

        arr[3][0] = x - a;
        arr[3][1] = y - b;

        arr[4][0] = x + b;
        arr[4][1] = y + a;

        arr[5][0] = x + b;
        arr[5][1] = y - a;

        arr[6][0] = x - b;
        arr[6][1] = y + a;

        arr[7][0] = x - b;
        arr[7][1] = y - a;
    }
}
