import java.io.*;
import java.util.*;

public class A {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		int n = 5;
		int[] arr = new int[n];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			if (i > 0) {
				if (arr[i] < arr[i - 1]) {
					cnt++;
				}
			}
		}

		if (cnt != 1) {
			out.println("No");
		} else {
			out.println("Yes");
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