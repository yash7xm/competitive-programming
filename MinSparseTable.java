import java.io.*;
import java.util.*;

class MinSparseTable {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int[] log2;
    static int[][] dp;

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    static void solve() {
        int n = in.nextInt();
        int q = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = in.nextInt();

        // Precompute log2 values
        log2 = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log2[i] = log2[i / 2] + 1;
        }

        int maxLog = log2[n];
        dp = new int[maxLog + 1][n];

        // Initialize dp[0][i]
        for (int i = 0; i < n; i++) {
            dp[0][i] = arr[i];
        }

        // Build sparse table
        for (int p = 1; p <= maxLog; p++) {
            for (int i = 0; i + (1 << p) <= n; i++) {
                dp[p][i] = Math.min(dp[p - 1][i], dp[p - 1][i + (1 << (p - 1))]);
            }
        }

        // Process queries
        while (q-- > 0) {
            int l = in.nextInt() - 1; // convert to 0-based indexing
            int r = in.nextInt() - 1;

            int len = r - l + 1;
            int p = log2[len];
            int answer = Math.min(dp[p][l], dp[p][r - (1 << p) + 1]);

            out.println(answer);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
    }
}
