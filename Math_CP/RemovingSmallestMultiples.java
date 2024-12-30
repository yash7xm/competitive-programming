package Math_CP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RemovingSmallestMultiples {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String T = in.next();

            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j += i) {
                    if (T.charAt(j - 1) == '1') {
                        break;
                    } else {
                        dp[j] = Integer.min(dp[j], i);
                    }
                }
            }

            long res = 0;
            for (int i = 1; i <= n; i++) {
                if (dp[i] != Integer.MAX_VALUE) {
                    res += dp[i];
                }
            }

            out.println(res);
            out.flush();
        }
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
    }
}
