import java.io.*;
import java.util.*;

public class XorSum4 {

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

		int mod = (int) 1e9 + 7;

		long res = 0;

		for (int bit = 0; bit < 60; bit++) {
            long count0 = 0, count1 = 0;
            long power = (1L << bit) % mod;

            for (long num : arr) {
                if ((num & (1L << bit)) == 0) {
                    count0++;
                } else {
                    count1++;
                }
            }

            long contribution = (count0 * count1) % mod * power % mod;
            res = (res + contribution) % mod;
        }

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