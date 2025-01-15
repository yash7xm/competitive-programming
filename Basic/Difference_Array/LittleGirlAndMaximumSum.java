import java.io.*;
import java.util.*;

public class LittleGirlAndMaximumSum {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		int q = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		long[] dp = new long[n + 2];
		for (int i = 0; i < q; i++) {
			int a = in.nextInt();
			int b = in.nextInt();

			dp[a]++;
			dp[b + 1]--;
		}

		for (int i = 1; i < dp.length; i++) {
			dp[i] += dp[i - 1];
		}

		Arrays.sort(dp);
		Arrays.sort(arr);

		long sum = 0;
		for (int i = 2; i < dp.length; i++) {
			sum += (long)arr[i - 2] * dp[i];
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