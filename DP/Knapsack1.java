package DP;

import java.util.*;
import java.io.*;

public class Knapsack1 {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt();
        int maxw = in.nextInt();

        int[] w = new int[n];
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
            v[i] = in.nextInt();
        }

        long[][] dp = new long[n + 1][maxw + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxw; j++) {
                long ifTaken = 0;
                if (j >= w[i - 1]) {
                    ifTaken = dp[i - 1][j - w[i - 1]] + v[i - 1];
                }
                dp[i][j] = Math.max(dp[i - 1][j], ifTaken);
            }
        }

        out.println(dp[n][maxw]);

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
