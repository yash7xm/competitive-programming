import java.io.*;
import java.util.*;

public class RuleOfLeague {

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
		int x = in.nextInt();
		int y = in.nextInt();

		if ((x != 0 && y != 0) || (x == 0 && y == 0)) {
			out.println("-1");
			return;
		}

		int num = x == 0 ? y : x;

		if ((n - 1) % num != 0) {
			out.println("-1");
			return;
		}

		int curr = 1;
		int cnt = 0;
		for (int i = 2; i <= n; i++) {
			out.print(curr + " ");
			cnt = (cnt + 1) % num;
			if (cnt == 0) {
				curr = i + 1;
			}
		}
		out.println();
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