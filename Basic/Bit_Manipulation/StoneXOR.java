import java.io.*;
import java.util.*;

public class StoneXOR {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextLong();
		}

		Set<Long> set = new HashSet<>();
		int totalSubsets = 1 << n;
        for (int mask = 0; mask < totalSubsets; mask++) {
            long xorValue = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    xorValue ^= stones[i];
                }
            }

            set.add(xorValue);
        

		out.println(set.size());
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