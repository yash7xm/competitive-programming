import java.io.*;
import java.util.*;

public class JustAddIt {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		while (true) {
			long n = in.nextLong();
			long k = in.nextLong();

			if (n == 0 && k == 0) {
				break;
			}
			solve(n, k);
		}
		out.flush();
	}

	public static void solve(long n, long k) {
		long mod = 10000007L;

		long res = (exp(n, k, mod) + exp(n, n, mod)) % mod;
		res = (res + 2 * ((exp(n - 1, k, mod) + exp(n - 1, n - 1, mod)) % mod)) % mod;

		out.println(res);
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