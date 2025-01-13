import java.io.*;
import java.util.*;

public class LeshaAndArraySplitting {
	
	static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		int[] arr = new int[n+1];
		int cnt = 0;
		int[] p = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = in.nextInt();
			if(arr[i] == 0) {
				cnt++;
			}
			p[i] = arr[i] + p[i-1];
		}

		if(cnt == n) {
			out.println("NO");
		} else {
			if(p[n] == 0) {
				for(int i=1; i<=n; i++) {
					if(p[i] != 0) {
						out.println("YES");
						out.println("2");
						out.println("1" + " " + i);
						out.println(i+1 + " " + n);
						break;
					}
				}
			} else {
				out.println("YES");
				out.println("1");
				out.println(1 + " " + n);
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