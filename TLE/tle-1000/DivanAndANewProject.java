import java.io.*;
import java.util.*;

public class DivanAndANewProject {
	
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
		int[] arr = new int[n];
		Integer[] aid = new Integer[n];
		for(int i=0; i<n; i++) {
			arr[i] = in.nextInt();
			aid[i] = i;
		}

		Arrays.sort(aid, (l,r) -> Integer.compare(arr[r], arr[l]));

		long sum = 0;
		long dis = 1;
		for(int i=0; i<n; i++) {
			sum += 2 * dis * arr[aid[i]];
			if(i % 2 != 0) {
				dis++;
			}
		}
		out.println(sum);
		int[] ans = new int[n];
		dis = 1;
		for(int i=0; i<n; i++) {
			if(i % 2 == 0) {
				ans[aid[i]] = (int)dis;
			} else {
				ans[aid[i]] = (int)(-1*dis);
				dis++;
			}
		}
		out.print("0 ");
		for(int x : ans) {
			out.print(x + " ");
		}
		out.println();
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