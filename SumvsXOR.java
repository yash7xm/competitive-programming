import java.io.*;
import java.util.*;

public class SumvsXOR {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		long n = in.nextLong();

		int cnt = 0;
        boolean foundOne = false;

        for (int i = 63; i >= 0; i--) {
            if ((n & (1L << i)) != 0) {
                foundOne = true;
            } else if (foundOne) {
                cnt++;
            }
        }

		out.println(1L << cnt);
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