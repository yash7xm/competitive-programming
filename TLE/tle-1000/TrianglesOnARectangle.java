import java.io.*;
import java.util.*;

public class TrianglesOnARectangle {
	
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
		int w = in.nextInt();
		int h = in.nextInt();

		int k = in.nextInt();
		int[] a = new int[k];
		for(int i=0; i<k ;i++) {
			a[i] = in.nextInt();
		}

		k = in.nextInt();
		int[] c = new int[k];
		for(int i=0; i<k ;i++) {
			c[i] = in.nextInt();
		}

		k = in.nextInt();
		int[] b = new int[k];
		for(int i=0; i<k ;i++) {
			b[i] = in.nextInt();
		}

		k = in.nextInt();
		int[] d = new int[k];
		for(int i=0; i<k ;i++) {
			d[i] = in.nextInt();
		}

		long res = 0;
		int base = a[a.length-1] - a[0];
		res = (long)Math.max(res, (long)base * d[d.length-1]);
		res = (long)Math.max(res, (long)base * b[b.length-1]);
		res = (long)Math.max(res, (long)base * h);

		base = c[c.length-1] - c[0];
		res = (long)Math.max(res, (long)base * d[0]);
		res = (long)Math.max(res, (long)base * b[0]);
		res = (long)Math.max(res, (long)base * h);

		base = d[d.length-1] - d[0];
		res = (long)Math.max(res, (long)base * a[a.length-1]);
		res = (long)Math.max(res, (long)base * c[c.length-1]);
		res = (long)Math.max(res, (long)base * w);

		base = b[b.length-1] - b[0];
		res = (long)Math.max(res, (long)base * a[0]);
		res = (long)Math.max(res, (long)base * c[0]);
		res = (long)Math.max(res, (long)base * w);

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