import java.io.*;
import java.util.*;

public class GregAndArray {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		Queries[] quer = new Queries[m + 1];
		for (int i = 1; i <= m; i++) {
			int l = in.nextInt();
			int r = in.nextInt();
			int d = in.nextInt();

			quer[i] = new Queries(l, r, d);
		}

		int[] q = new int[m + 2];
		for (int i = 0; i < k; i++) {
			int x = in.nextInt();
			int y = in.nextInt();

			q[x]++;
			q[y + 1]--;
		}

		for (int i = 1; i < q.length; i++) {
			q[i] += q[i - 1];
		}

		long[] b = new long[n + 2];
		for (int i = 1; i <= m; i++) {
			long times = q[i];
			int l = quer[i].l;
			int r = quer[i].r;
			long d = (long)quer[i].d * times;

			b[l] += d;
			b[r + 1] -= d;
		}

		for (int i = 1; i <= n; i++) {
			b[i] += b[i - 1];
			out.print(arr[i - 1] + b[i] + " ");
		}
		out.println();
	}

	public static class Queries {
		int l, r, d;

		public Queries(int l, int r, int d) {
			this.l = l;
			this.r = r;
			this.d = d;
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