import java.io.*;
import java.util.*;

public class EhabTheXorcist {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		long u = in.nextLong();
		long v = in.nextLong();

		if (u % 2 != v % 2 || u > v) {
			out.println(-1);
			return;
		}

		if (u == v) {
			if (u == 0) {
				out.println(0);
			} else {
				out.println(1);
				out.println(u);
			}
			return;
		}

		long x = (v - u) / 2;

		if ((u & x) != 0) {
			out.println(3);
			out.println(u + " " + x + " " + x);
		} else {
			out.println(2);
			out.println((u ^ x) + " " + x);
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