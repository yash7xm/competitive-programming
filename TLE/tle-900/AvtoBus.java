import java.io.*;
import java.util.*;

public class AvtoBus {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int t = in.nextInt();
		while (t-- > 0) {
			solve();
		}
		out.flush();
	}

	public static class Pair {
		long x, y, g;

		public Pair(long x, long y, long g) {
			this.x = x;
			this.y = y;
			this.g = g;
		}
	}

	public static void solve() {
		long n = in.nextLong();

		if ((n & 1) == 1 || n == 2) {
			out.println("-1");
		} else {
			long min = 0;

			long six = n / 6;
			if (n % 6 == 0) {
				min = six;
			} else {
				min = six + 1;
			}

			long max = 0;

			long four = n / 4;
			max = four;

			out.println(min + " " + max);
		}
	}

	public static Pair euclids(long a, long b) {
		if (b == 0) {
			return new Pair(1, 0, a);
		}

		Pair dash = euclids(b, a % b);

		return new Pair(dash.y, dash.x - (a / b) * dash.y, dash.g);
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