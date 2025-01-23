import java.io.*;
import java.util.*;

public class SlidingWindowMaximum {

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
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && arr[i] > arr[dq.peekLast()]) {
				dq.pollLast();
			}
			dq.addLast(i);
		}

		for (int i = k; i < n; i++) {
			out.print(arr[dq.peekFirst()] + " ");
			if (!dq.isEmpty() && i - dq.peekFirst() >= k) {
				dq.pollFirst();
			}

			while (!dq.isEmpty() && arr[i] > arr[dq.peekLast()]) {
				dq.pollLast();
			}
			dq.addLast(i);
		}
		out.print(arr[dq.peekFirst()] + " ");
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