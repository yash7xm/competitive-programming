import java.io.*;
import java.util.*;

public class RockAndLever {

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
		int[] arr = new int[n];
		int[] cnt = new int[32];
		long res = 0;
		for (int k = 0; k < n; k++) {
			arr[k] = in.nextInt();

			for (int i = 31; i >= 0; i--) {
				if (((1 << i) & arr[k]) != 0) {
					res += cnt[i];
					cnt[i]++;
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