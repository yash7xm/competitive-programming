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
		for(int i=0; i<n; i++) {
			arr[i] = in.nextLong();
		}

		Set<Long> set = new HashSet<>();
		calculate(arr, 0, set);

		out.println(set.size());
	}

	public static void calculate(long[] arr, int idx, Set<Long> set) {
		if(idx == arr.length) {
			long xor = 0;
			for(long a : arr) {
				xor ^= a;
			}
			set.add(xor);
			return;
		}

		calculate(arr, idx + 1, set);

		for(int i=0; i<arr.length; i++) {
			if(i != idx) {
				long temp = arr[i];
				arr[i] += arr[idx];
				long org = arr[idx];
				arr[idx] = 0;

				calculate(arr, idx + 1, set);

				arr[idx] = org;
				arr[i] = temp;
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