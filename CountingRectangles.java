import java.io.*;
import java.util.*;

public class CountingRectangles {

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
		int q = in.nextInt();

		long[][] arr = new long[1001][1001];
		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();

			arr[x][y] += x * y;
		}

		long[][] dp = new long[1001][1001];
		for (int i = 1; i <= 1000; i++) {
			for (int j = 1; j <= 1000; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
			}
		}

		for (int i = 0; i < q; i++) {
			int x1 = in.nextInt() + 1;
			int y1 = in.nextInt() + 1;
			int x2 = in.nextInt() - 1;
			int y2 = in.nextInt() - 1;

			long res = 0;
			res = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
			out.println(res);
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