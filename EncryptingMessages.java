import java.io.*;
import java.util.*;

public class EncryptingMessages {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		int c = in.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		int[] brr = new int[m + 1];
		for (int i = 1; i <= m; i++) {
			brr[i] = in.nextInt();
			brr[i] += brr[i - 1];
		}

		for (int i = 0; i < n; i++) {
			out.print((arr[i] + brr[Math.min(i + 1, m)] - brr[Math.max(i - (n - m), 0)]) % c + " ");
		}
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