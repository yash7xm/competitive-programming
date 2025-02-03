import java.io.*;
import java.util.*;

public class ModularExponentiation {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		long n = in.nextLong();
		long m = in.nextLong();

		long res = exp(2L, n);
		if (res == 0) {
			out.println(m);
		} else {
			out.println(m % res);
		}
	}

	public static long exp(long a, long b) {
		long res = 1;
		while (b > 0) {
			if ((b & 1) == 1) {
				res = res * a;
			}

			a = a * a;
			b >>= 1;
		}
		return res;
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