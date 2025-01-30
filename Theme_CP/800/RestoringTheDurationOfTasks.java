import java.io.*;
import java.util.*;

public class RestoringTheDurationOfTasks {

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
		int n = in.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = in.nextInt();
		}
		int[] f = new int[n];
		for (int i = 0; i < n; i++) {
			f[i] = in.nextInt();
		}

		long[] d = new long[n];

		d[0] = f[0] - s[0];

		for (int i = 1; i < n; i++) {
			if (s[i] < f[i - 1]) {
				d[i] = f[i] - f[i - 1];
			} else {
				d[i] = f[i] - s[i];
			}
		}

		for (int i = 0; i < n; i++) {
			out.print(d[i] + " ");
		}
		out.println();
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