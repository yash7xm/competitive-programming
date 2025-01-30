import java.io.*;
import java.util.*;

public class JohnnyAndHisHobbies {

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
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			set.add(arr[i]);
		}

		for (int i = 1; i < 1024; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (set.contains(i ^ arr[j])) {
					cnt++;
				} else {
					break;
				}
			}

			if (cnt == n) {
				out.println(i);
				return;
			}
		}

		out.println(-1);
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