import java.io.*;
import java.util.*;

public class KDivisibleSum {
	
	static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int t = in.nextInt();
		while(t-- > 0) {
			solve();
		}
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		int k = in.nextInt();

		long cf = (n + k - 1) / k;
		long res = (cf*k + n - 1) / n;

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