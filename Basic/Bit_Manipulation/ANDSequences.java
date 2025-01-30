import java.io.*;
import java.util.*;

public class ANDSequences {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	static final int MOD = 1_000_000_007;

	static long[] fact;
	static void precomputeFactorials(int maxN) {
		fact = new long[maxN + 1];
		fact[0] = 1;
		for (int i = 1; i <= maxN; i++) {
			fact[i] = (fact[i - 1] * i) % MOD;
		}
	}

	public static void main(String[] args) {
		precomputeFactorials(200000);
		int t = in.nextInt();
		while (t-- > 0) {
			solve();
		}
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextLong();
		}

		long x = a[0];
		for (int i = 1; i < n; i++) {
			x = Math.min(x, a[i]);
		}

		long cnt = 0;
		for (long num : a) {
			if (num == x) cnt++;
		}

		if (cnt < 2) {
			out.println(0);
			return;
		}

		for (long num : a) {
			if ((num & x) != x) {
				out.println(0);
				return;
			}
		}

		long result = (cnt * (cnt - 1)) % MOD;
		result = (result * fact[n - 2]) % MOD;

		out.println(result);
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