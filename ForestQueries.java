import java.util.Scanner;

public class ForestQueries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();

        int[][] tree = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < n; j++) {
                char ch = s.charAt(j);
                if (ch == '.')
                    tree[i][j] = 0;
                else
                    tree[i][j] = 1;
            }
        }

        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == n - 1 && j == n - 1) {
                    dp[i][j] = tree[i][j];
                } else if (i == n - 1) {
                    dp[i][j] = dp[i][j + 1] + tree[i][j];
                } else if (j == n - 1) {
                    dp[i][j] = dp[i + 1][j] + tree[i][j];
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1] - dp[i + 1][j + 1] + tree[i][j];
                }
            }
        }

        for (int i = 0; i < q; i++) {
            int y1 = in.nextInt();
            int x1 = in.nextInt();
            int y2 = in.nextInt();
            int x2 = in.nextInt();

            x1--;
            y1--;
            int res = 0;

            res += dp[y1][x1];
            if (y2 < n) {
                res -= dp[y2][x1];
            }
            if (x2 < n) {
                res -= dp[y1][x2];
            }
            if (x2 < n && y2 < n) {
                res += dp[y2][x2];
            }

            System.out.println(res);
        }

        in.close();
    }
}
