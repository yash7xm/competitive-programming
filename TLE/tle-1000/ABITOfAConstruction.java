import java.io.*;
import java.util.*;

public class ABITOfAConstruction {
	
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

		if(n == 1) {
			out.println(k);
		} else {
			int idx = 0;
			while((1 << idx) <= k) {
				idx++;	
			}
			idx--;
			int a = (1<<idx) - 1;
			int b = k - a;
			out.print(a + " " + b + " ");
			for(int i=2; i<n; i++) {
				out.print("0 ");
			}
			out.println();
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