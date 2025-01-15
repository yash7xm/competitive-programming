import java.io.*;
import java.util.*;

public class ForestQueries1 {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		int q = in.nextInt();
		int[][] arr = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			String row = in.next();
			for (int j = 1; j <= n; j++) {
				if (row.charAt(j - 1) == '.') {
					arr[i][j] = 0;
				} else {
					arr[i][j] = 1;
				}
			}
		}

		long[][] dp = new long[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
			}
		}

		for (int i = 0; i < q; i++) {
			int a1 = in.nextInt();
			int b1 = in.nextInt();
			int a2 = in.nextInt();
			int b2 = in.nextInt();

			long res = 0;
			res = dp[a2][b2] - dp[a2][b1 - 1] - dp[a1 - 1][b2] + dp[a1 - 1][b1 - 1];
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