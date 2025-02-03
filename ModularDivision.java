import java.io.*;
import java.util.*;

public class ModularDivision {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		long a = in.nextLong();
		long b = in.nextLong();
		long n = in.nextLong();

		out.println((a * exp(b, n - 2, n)) % n) ;
	}

	public static long exp(long a, long b, long n) {
		long res = 1;
		a %= n;
		while (b > 0) {
			if ((b & 1) == 1) {
				res = res * a % n;
			}
			a = a * a % n;
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