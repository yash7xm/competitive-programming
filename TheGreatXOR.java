import java.io.*;
import java.util.*;

public class TheGreatXOR {

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
		long x = in.nextLong();

		out.println(theGreatXor(x));
	}

	public static long theGreatXor(long x) {
		long res = 0;
		boolean flag = false;

		for (int i = 63; i >= 0; i--) {
			if (((1L << i) & x) != 0) {
				flag = true;
			} else if (flag) {
				res |= (1L << i);
			}
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