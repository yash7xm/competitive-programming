import java.io.*;
import java.util.*;

public class ChefAndRiffles {

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

		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}

		int[] perm = new int[n + 1];
		int idx = 1;
		for (int i = 1; i <= n; i += 2) {
			perm[idx++] = i;
		}
		for (int i = 2; i <= n; i += 2) {
			perm[idx++] = i;
		}

		int[] res = exp(k, arr, perm);

		for (int i = 1; i <= n; i++) {
			out.print(res[i] + " ");
		}
		out.println();
	}

	public static int[] exp(int b, int[] arr, int[] perm) {
		while (b > 0) {
			if ((b & 1) == 1) {
				arr = apply(arr, perm);
			}
			perm = apply(perm, perm);
			b >>= 1;
		}
		return arr;
	}

	public static int[] apply(int[] seq, int[] perm) {
		int[] newSeq = new int[seq.length];
		for (int i = 1; i < newSeq.length; i++) {
			newSeq[i] = seq[perm[i]];
		}
		return newSeq;
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