import java.io.*;
import java.util.*;

public class ANDORAndSquareSum {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		int[] bits = new int[20];
		for (int bit = 0; bit < 20; bit++) {
			for (int i = 0; i < n; i++) {
				if (((arr[i] >> bit) & 1) == 1) {
					bits[bit]++;
				}
			}
		}

		long sum = 0;
		for (int i = 0; i < n; i++) {
			long num = 0;
			for (int bit = 19; bit >= 0; bit--) {
				if (bits[bit] > 0) {
					num = 2 * num + 1;
					bits[bit]--;
				} else {
					num = 2 * num;
				}
			}
			sum += num * num;
		}

		out.println(sum);
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