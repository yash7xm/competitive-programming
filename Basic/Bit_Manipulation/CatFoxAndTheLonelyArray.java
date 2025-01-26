import java.io.*;
import java.util.*;

public class CatFoxAndTheLonelyArray {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static class SegmentTree {
		long[] tree;

		public SegmentTree(long[] arr) {
			int n = arr.length;
			tree = new long[4 * n];
			this.Build(1, 0, n - 1, arr);
		}

		void Build(int node, int start, int end, long[] arr) {
			if (start == end) {
				tree[node] = arr[start];
				return;
			}

			int mid = (start + end) / 2;
			this.Build(2 * node, start, mid, arr);
			this.Build((2 * node) + 1, mid + 1, end, arr);

			this.tree[node] = (this.tree[2 * node] | this.tree[(2 * node) + 1]);
		}

		long Query(int node, int start, int end, int lq, int rq) {
			if (start >= lq && end <= rq) {
				return this.tree[node];
			}

			if (start > rq || end < lq) {
				return 0;
			}

			int mid = (start + end) / 2;
			return this.Query(2 * node, start, mid, lq, rq) |
			       this.Query((2 * node) + 1, mid + 1 , end , lq, rq);
		}
	}

	public static void main(String[] args) {
		int t = in.nextInt();
		while (t-- > 0) {
			solve();
		}
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextLong();
		}

		SegmentTree sg = new SegmentTree(arr);

		int lo = 1, hi = n, ans = n;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (check(mid, sg, arr.length)) {
				ans = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}

		out.println(ans);
	}

	static boolean check(int k, SegmentTree sg, int n) {
		int i = 1, j = k;
		long bitwiseOR = sg.Query(1, 1, n, i, j);
		i++; j++;
		while (j <= n) {
			long temp = sg.Query(1, 1, n, i, j);
			if (temp != bitwiseOR) {
				return false;
			} else {
				bitwiseOR = temp;
			}
			i++; j++;
		}

		return true;
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