import java.io.*;
import java.util.*;

public class MagicOfTheLocker {

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

		long res = 0;
		if (n % 3 == 0) {
			res = exp(3, n / 3);
		} else if (n % 3 == 1) {
			res = (exp(3, (n - 4) / 3) * 4) % mod;
		} else if (n % 3 == 2) {
			res = (exp(3, n / 3) * 2) % mod;
		}

		out.println(res);
	}

	static long mod = (long) 1e9 + 7;

	public static long exp(long a, long b) {
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