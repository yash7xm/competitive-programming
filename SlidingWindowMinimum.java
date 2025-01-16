import java.io.*;
import java.util.*;

public class SlidingWindowMinimum {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		int k = in.nextInt();
		int x = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();

		long[] arr = new long[n + 1];
		arr[1] = x;
		for (int i = 2; i <= n; i++) {
			arr[i] = (long)((long)(a * arr[i - 1] + b)) % c;
		}

		ArrayDeque<Integer> d = new ArrayDeque<>();
		for (int i = 1; i <= k; i++) {
			while (!d.isEmpty() && arr[i] < arr[d.peekLast()]) {
				d.pollLast();
			}
			d.addLast(i);
		}

		long res = 0;
		for (int i = k + 1; i <= n; i++) {
			res ^= arr[d.peekFirst()];
			if (!d.isEmpty() && d.peekFirst() <= i - k) {
				d.pollFirst();
			}
			while (!d.isEmpty() && arr[i] <= arr[d.peekLast()]) {
				d.pollLast();
			}
			d.addLast(i);
		}

		res ^= arr[d.peekFirst()];
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