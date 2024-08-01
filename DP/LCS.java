package DP;

import java.util.*;
import java.io.*;

public class LCS {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        String s = in.next();
        String t = in.next();

        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < dp.length - 2; i++) {
            for (int j = 0; j < dp[0].length - 2; j++) {
                if (s.charAt(i) == t.charAt(j)) {

                }
            }
        }

        int i = 0;
        int j = 0;

        while (true) {
            if (res.length() == dp[0][0])
                break;

            if (i < s.length() && j < t.length() && (s.charAt(i) == t.charAt(j))) {
                res.append(s.charAt(i));
                i++;
                j++;
            } else {
                if (i < s.length() && j < t.length() && dp[i + 1][j] >= dp[i][j + 1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }

        out.println(res.toString());

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
