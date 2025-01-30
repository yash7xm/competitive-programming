import java.io.*;
import java.util.*;

public class HossamAndCombinatorics {

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
		int max = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}

		long cntMax = 0, cntMin = 0;
		for (int num : arr) {
			if (num == min) {
				cntMin++;
			}
			if (num == max) {
				cntMax++;
			}
		}

		long res = 2L * (cntMin * cntMax);

		if (max == min) {
			res = 1L * (cntMin * (cntMin - 1));
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