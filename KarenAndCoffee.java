import java.io.*;
import java.util.*;

public class KarenAndCoffee {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static int N = 200000;

	public static void solve() {
		int n = in.nextInt();
		int k = in.nextInt();
		int q = in.nextInt();

		int[] arr = new int[N + 2];
		for (int i = 0; i < n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();

			arr[a]++;
			arr[b + 1]--;
		}

		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
		}

		int[] pref = new int[N + 2];
		for (int i = 1; i < arr.length; i++) {
			pref[i] = pref[i - 1];
			if (arr[i] >= k) {
				pref[i]++;
			}
		}

		for (int i = 0; i < q; i++) {
			int a = in.nextInt();
			int b = in.nextInt();

			out.println(pref[b] - pref[a - 1]);
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