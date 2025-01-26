import java.io.*;
import java.util.*;

public class LongestDivisorsInterval {

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

		List<Long> list = new ArrayList<>();
		int res = 0;
		if ((n & 1) == 1) {
			res = 1;
		} else {
			for (long i = 1; i <= n ; i++) {
				if (n % i == 0) {
					res++;
				} else {
					break;
				}
			}
		}

		out.println(res);
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