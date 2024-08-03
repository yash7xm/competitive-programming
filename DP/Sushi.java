package DP;

import java.util.*;
import java.io.*;

public class Sushi {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt();
        double[][][] dp = new double[n + 2][n + 2][n + 2];

        int C1 = 0, C2 = 0, C3 = 0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (x == 1)
                C1++;
            if (x == 2)
                C2++;
            if (x == 3)
                C3++;
        }

        for (int c3 = 0; c3 <= n; c3++) {
            for (int c2 = 0; c2 <= n; c2++) {
                for (int c1 = 0; c1 <= n; c1++) {
                    int c0 = n - c1 - c2 - c3;
                    if (c0 == n) {
                        dp[c1][c2][c3] = 0;
                        continue;
                    }

                    double EB = 0, EC = 0, ED = 0, EA = 0;
                    double pb = (double) c3 / n;
                    double pc = (double) c2 / n;
                    double pd = (double) c1 / n;

                    if (c3 > 0) {
                        EB = dp[c1][c2 + 1][c3 - 1];
                    }
                    if (c2 > 0) {
                        EC = dp[c1 + 1][c2 - 1][c3];
                    }
                    if (c1 > 0) {
                        ED = dp[c1 - 1][c2][c3];
                    }
                    EA = (1 + EB * pb + EC * pc + ED * pd) / (1 - (double) c0 / n);
                    dp[c1][c2][c3] = EA;
                }
            }
        }

        out.println(dp[C1][C2][C3]);

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
