import java.io.*;
import java.util.*;

public class PowersOfTwo {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		int k = in.nextInt();

		List<Integer> powers = new ArrayList<>();
		for (int i = 0; (1 << i) <= n; i++) {
			if ((n & (1 << i)) != 0) {
				powers.add(1 << i);
			}
		}

		int count = powers.size();
		if (count > k) {
			System.out.println("NO");
			return;
		}

		int index = 0;
		while (index < powers.size() && count < k) {
			if (powers.get(index) == 1) {
				index++;
				continue;
			}
			int value = powers.get(index);
			powers.set(index, value / 2);
			powers.add(value / 2);
			count++;
		}

		if (powers.size() == k) {
			out.println("YES");
			for (int num : powers) {
				out.print(num + " ");
			}
		} else {
			out.println("NO");
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