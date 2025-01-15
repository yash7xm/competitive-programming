import java.io.*;
import java.util.*;

public class RestaurantCustomers {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		Integer[] arr = new Integer[2 * n];
		for (int i = 0; i < n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();

			arr[2 * i] = a;
			arr[2 * i + 1] = -b;
		}

		Arrays.sort(arr, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));

		int cnt = 0, res = 0;
		for (int time : arr) {
			if (time < 0) {
				cnt--;
			} else {
				cnt++;
				res = Math.max(cnt, res);
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