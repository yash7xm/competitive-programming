import java.io.*;
import java.util.*;

public class RestoreTheWeather {

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
		int k = in.nextInt();

		int[] arr = new int[n];
		Integer[] aid = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			aid[i] = i;
		}
		int[] brr = new int[n];
		for (int i = 0; i < n; i++) {
			brr[i] = in.nextInt();
		}

		Arrays.sort(aid, (a, b) -> Integer.compare(arr[a], arr[b]));
		Arrays.sort(brr);

		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			ans[aid[i]] = brr[i];
		}

		for (int i = 0; i < n; i++) {
			out.print(ans[i] + " ");
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