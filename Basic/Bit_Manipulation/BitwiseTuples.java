import java.io.*;
import java.util.*;

public class BitwiseTuples {

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
		long m = in.nextLong();

		int mod = (int) 1e9 + 7;

		long ans = binaryExp(2L, n, mod) - 1;
		ans = binaryExp(ans, m, mod);

		out.println(ans);
	}

	public static long binaryExp(long a, long b, int mod) {
		long res = 1;
		b = b % mod;
		while (b > 0) {
			if ((b & 1) == 1) {
				res = (res * a) % mod;
			}
			a = (a * a) % mod;
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