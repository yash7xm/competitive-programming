import java.io.*;
import java.util.*;

public class CuriousRobinHood {

	static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int t = in.nextInt();
		while(t-- > 0) {
			solve();
		}

		out.flush();
	}

	static long[] farr;

	public static void update(int i, long val) {
		boolean flag = true;
		while(i < farr.length) {
			farr[i] += val;
			i += (i & -i);
		}
	}

	public static long query(int l, int r) {
		return prefixSum(r) - prefixSum(l-1);
	}

	public static long prefixSum(int i) {
		long sum = 0;
		while(i > 0) {
			sum += farr[i];
			i -= (i & -i);
		}
		return sum;
	}

	public static void solve() {
		int n = in.nextInt();
		int q = in.nextInt();

		farr = new long[n+1];
		for(int i = 1; i <= n; i++) {
			update(i, in.nextInt());
		}

		while(q-- > 0) {
			int type = in.nextInt();

			if(type == 1) {
				int i = in.nextInt();
				long val = query(i+1, i+1);
				update(i+1, -val);
				out.println("Case 1: " + val);
			} else if(type == 2) {
				int i = in.nextInt();
				int val = in.nextInt();
				update(i+1, val);
			} else {
				int l = in.nextInt();
				int r = in.nextInt();

				long res = query(l+1, r+1);
				out.println("Case 3: " + res);
			}
		}
	}

	static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
    }
}