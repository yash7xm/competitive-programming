import java.io.*;
import java.util.*;

public class MakeItZero {

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
		for (int i = 0; i < n; i++) {
			in.nextInt();
		}

		if ((n & 1) == 1) {
			out.println("4");
			out.println(1 + " " + (n - 1));
			out.println(1 + " " + (n - 1));
			out.println((n - 1) + " " + (n));
			out.println((n - 1) + " " + (n));
		} else {
			out.println("2");
			out.println(1 + " " + (n));
			out.println(1 + " " + (n));
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