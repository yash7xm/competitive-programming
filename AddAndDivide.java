import java.io.*;
import java.util.*;

public class AddAndDivide {

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
		int a = in.nextInt();
		int b = in.nextInt();
		int res = 31;

		for (int i = (b == 1 ? 1 : 0); i <= 30; i++) {
			int n = a;
			int r = 0;
			while (n > 0) {
				n = n / (b + i);
				r++;
			}
			res = Math.min(res, r + i);
		}

		out.println(res);
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