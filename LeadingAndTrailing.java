import java.io.*;
import java.util.*;

public class LeadingAndTrailing {

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
		long n = in.nextLong();
		long k = in.nextLong();

		double f = k * Math.log10(n);
		double fractionalPart = f - Math.floor(f);
		long firstThree = (long) (Math.pow(10, fractionalPart) * 100);
		long lastThree = exp(n, k, 1000);

		out.printf("%03d...%03d\n", firstThree, lastThree);
	}

	public static long exp(long a, long b, long mod) {
		long res = 1;
		a %= mod;
		while (b > 0) {
			if ((b & 1) == 1) {
				res = res * a % mod;
			}
			a = a * a % mod;
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