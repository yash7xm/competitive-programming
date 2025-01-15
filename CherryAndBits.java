import java.io.*;
import java.util.*;

public class CherryAndBits {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] arr = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String row = in.next();
			for (int j = 1; j <= m; j++) {
				arr[i][j] = row.charAt(j - 1) - '0';
			}
		}

		long[][] pref = new long[n + 2][m + 2];
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();

			pref[x1][y1]++;
			pref[x2 + 1][y2 + 1]++;
			pref[x1][y2 + 1]--;
			pref[x2 + 1][y1]--;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				pref[i][j] += pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1];
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (pref[i][j] % 2 == 1) {
					out.print(arr[i][j] == 0 ? "1 " : "0 ");
				} else {
					out.print(arr[i][j] + " ");
				}
			}
			out.println();
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