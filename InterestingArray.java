import java.io.*;
import java.util.*;

public class InterestingArray {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	static final int MAXBIT = 30;

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		int m = in.nextInt();

		int[] l = new int[m];
		int[] r = new int[m];
		int[] q = new int[m];
		int[] a = new int[n];
		int[] t = new int[4 * n];
		int[] sum = new int[n];

		for (int i = 0; i < m; i++) {
			l[i] = in.nextInt() - 1;
			r[i] = in.nextInt() - 1;
			q[i] = in.nextInt();
		}

		for (int bit = 0; bit < MAXBIT; bit++) {
			Arrays.fill(sum, 0);

			for (int i = 0; i < m; i++) {
				if (((q[i] >> bit) & 1) == 1) {
					sum[l[i]]++;
					if (r[i] + 1 < n) sum[r[i] + 1]--;
				}
			}

			for (int i = 0; i < n; i++) {
				if (i > 0) sum[i] += sum[i - 1];
				if (sum[i] > 0) {
					a[i] |= (1 << bit);
				}
			}
		}

		Build(1, 0, n - 1, a, t);

		for (int i = 0; i < m; i++) {
			if (query(1, 0, n - 1, l[i], r[i], t) != q[i]) {
				out.println("NO");
				return;
			}
		}

		out.println("YES");
		for (int i = 0; i < n; i++) {
			out.print(a[i] + " ");
		}
		out.println();
	}

	private static void Build(int node, int start, int end, int[] arr, int[] t) {
		if (start == end) {
			t[node] = arr[start];
			return;
		}

		int mid = (start + end) / 2;
		Build(2 * node, start, mid, arr, t);
		Build(2 * node + 1, mid + 1, end, arr, t);

		t[node] = t[2 * node] & t[2 * node + 1];
	}

	private static int query(int node, int start, int end, int lq, int rq, int[] t) {
		if (start >= lq && end <= rq) {
			return t[node];
		}

		if (start > rq || end < lq) {
			return (1 << MAXBIT) - 1;
		}

		int mid = (start + end) / 2;
		return query(2 * node, start, mid, lq, rq, t) &
		       query(2 * node + 1, mid + 1, end, lq, rq, t);
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
