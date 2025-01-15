import java.io.*;
import java.util.*;

public class MEXorMixup {
	
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
		int a = in.nextInt();
		int b = in.nextInt();

		int res = 0;
		int n = a-1;
		int xor = 0;
		if(n % 4 == 0) {
			xor = n;
		} else if(n % 4 == 1) {	
			xor = 1;
		} else if(n % 4 == 2) {
			xor = n+1;
		} else if(n % 4 == 3) {
			xor = 0;
		}

		if(xor == b) {
			res = a;
		} else {
			int x = xor ^ b;
			if(x == a) {
				res = a + 2;
			} else {
				res = a + 1;
			}
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