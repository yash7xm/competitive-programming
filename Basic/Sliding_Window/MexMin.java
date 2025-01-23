import java.io.*;
import java.util.*;

public class MexMin {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		int m = in.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		List<List<Integer>> pos = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			pos.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			pos.get(arr[i]).add(i);
		}

		for (int i = 0; i <= n; i++) {
			List<Integer> temp = pos.get(i);

			temp.add(-1);
			temp.add(n);

			Collections.sort(temp);

			boolean valid = false;
			for (int j = 1; j < temp.size(); j++) {
				if (temp.get(j) - temp.get(j - 1) > m) {
					valid = true;
					break;
				}
			}

			if (valid || temp.size() == 0) {
				out.println(i);
				return;
			}
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