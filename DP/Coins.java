package DP;

import java.util.*;
import java.io.*;

public class Coins {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt();
        double[] p = new double[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextDouble();
        }

        double[] dp = new double[n + 1];
        dp[0] = 1.0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j > 0; j--) {
                dp[j] = dp[j] * (1 - p[i]) + dp[j - 1] * p[i];
            }
            dp[0] *= (1 - p[i]);
        }

        double result = 0.0;
        for (int j = (n / 2) + 1; j <= n; j++) {
            result += dp[j];
        }

        out.println(result);

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
