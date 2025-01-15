import java.io.*;
import java.util.*;

public class CountingTest {

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
		String s = in.next();

		int[][] dp = new int[26][n + 1];
		for (int j = 1; j <= n; j++) {
			char ch = s.charAt(j - 1);
			for (int i = 0; i < 26; i++) {
				dp[i][j] = dp[i][j - 1];
			}
			dp[ch - 'a'][j]++;
		}

		for (int i = 0; i < q; i++) {
			long l = in.nextLong();
			long r = in.nextLong();
			char c = in.next().charAt(0);

			int idx = c - 'a';

			long leftBlock = (l - 1) / n;
			long rightBlock = (r - 1) / n;

			long count = 0;

			if (rightBlock > leftBlock) {
				count += (rightBlock - leftBlock - 1) * dp[idx][n];
			}

			int startIdx = (int) ((l - 1) % n + 1);
			count += dp[idx][n] - dp[idx][startIdx - 1];

			int endIdx = (int) ((r - 1) % n + 1);
			count += dp[idx][endIdx];

			if (leftBlock == rightBlock) {
				count = dp[idx][endIdx] - dp[idx][startIdx - 1];
			}

			out.println(count);
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
