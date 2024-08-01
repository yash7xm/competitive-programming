package DP;

import java.util.*;
import java.io.*;

public class Knapsack2 {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt();
        int W = in.nextInt();

        int[] wt = new int[n];
        int[] vals = new int[n];

        int maxVal = 0;

        for (int i = 0; i < n; i++) {
            wt[i] = in.nextInt();
            vals[i] = in.nextInt();
            maxVal += vals[i];
        }

        long[] dp = new long[maxVal + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int v = maxVal; v >= vals[i]; v--) {
                if (dp[v - vals[i]] != Long.MAX_VALUE) {
                    dp[v] = Math.min(dp[v], dp[v - vals[i]] + wt[i]);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] <= W) {
                res = i;
            }
        }

        out.println(res);

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
