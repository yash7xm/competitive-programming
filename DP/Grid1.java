package DP;

import java.util.*;
import java.io.*;

public class Grid1 {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        int mod = 1000000007;

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            for (int j = 0; j < m; j++) {
                char ch = line.charAt(j);
                if (ch == '.') {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = 1;
                }
            }
        }

        int[][] dp = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] == 1)
                    continue;
                if (i == n - 1 && j == m - 1) {
                    dp[i][j] = 1;
                } else if (i == n - 1) {
                    dp[i][j] = dp[i][j + 1] % mod;
                } else if (j == m - 1) {
                    dp[i][j] = dp[i + 1][j] % mod;
                } else {
                    dp[i][j] = (dp[i + 1][j] + dp[i][j + 1]) % mod;
                }
            }
        }

        out.println(dp[0][0]);

        out.flush();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
