import java.io.*;
import java.util.*;

public class BeautyOfTheMountains {
	
	static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int t = in.nextInt();
		while (t-- > 0) {
			solve();
		}
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();

		int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
            }
        }

        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.next();
        }

        int[][] pref = new int[n + 1][m + 1];
        long diff = 0;

        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < m; j++) {
                if (s[i].charAt(j) == '1') {
                    cur += 1;
                    diff += a[i][j];
                } else {
                    diff -= a[i][j];
                }
                pref[i + 1][j + 1] = pref[i][j + 1] + cur;
            }
        }

        if (diff == 0) {
            out.println("YES");
            return;
        }

        long g = 0;

        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= m - k; j++) {
                long f = pref[i + k][j + k] - pref[i + k][j] - pref[i][j + k] + pref[i][j];
                f = Math.abs(k * k - 2 * f);
                g = gcd(g, f);
            }
        }

        if (g == 0 || diff % g != 0) {
            out.println("NO");
        } else {
            out.println("YES");
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

	// FastReader for faster input
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
