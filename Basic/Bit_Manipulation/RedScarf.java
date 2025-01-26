import java.io.*;
import java.util.*;

public class RedScarf {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		long[] arr = new long[n];
		long[] pref = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextLong();
			pref[i] = arr[i];
			if (i != 0) {
				pref[i] ^= pref[i - 1];
			}
		}

		for (int i = 0; i < n; i++) {
			long left = pref[n - 1] ^ pref[i];
			long right = pref[i] ^ arr[i];

			out.print((left ^ right) + " ");
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