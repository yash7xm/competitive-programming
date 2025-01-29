import java.io.*;
import java.util.*;

public class AndItsNonZero {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int[][] arr = new int[32][200001];

		for (int i = 1; i <= 200000; i++) {
			for (int j = 0; j < 32; j++) {
				if (((1 << j) & i) == 0) {
					arr[j][i]++;
				}
				arr[j][i] += arr[j][i - 1];
			}
		}
		int t = in.nextInt();
		while (t-- > 0) {
			solve(arr);
		}
		out.flush();
	}

	public static void solve(int[][] arr) {
		int l = in.nextInt();
		int r = in.nextInt();

		int res = Integer.MAX_VALUE;
		for (int j = 0; j < 32; j++) {
			res = Math.min(res, arr[j][r] - arr[j][l - 1]);
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