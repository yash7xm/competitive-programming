import java.io.*;
import java.util.*;

public class PalindromeReorder {
	
	static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		String s = in.next();
		int[] arr = new int[26];
		for(char ch : s.toCharArray()) {
			arr[ch-'A']++;
		}

		int odds = 0;
		char odd = 'c';
		int freq = 0;
		for(int i=0; i<26; i++) {
			if(arr[i] != 0 && arr[i] % 2 == 1) {
				odd = (char)(i+'A');
				freq = arr[i];
				odds++;
			}
		}

		if(odds > 1) {
			out.println("NO SOLUTION");
		} else {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<26; i++) {
				if(arr[i] % 2 == 0) {
					int n = arr[i] / 2;
					while(n-- > 0) {
						sb.append((char)(i+'A'));
					}
				}
			}

			while(freq-- > 0) {
				sb.append(odd);
			}

			for(int i=25; i>=0; i--) {
				if(arr[i] % 2 == 0) {
					int n = arr[i] / 2;
					while(n-- > 0) {
						sb.append((char)(i+'A'));
					}
				}
			}

			out.println(sb.toString());
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