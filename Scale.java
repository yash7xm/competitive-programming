import java.util.*;
import java.io.*;

public class Scale {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                String line = in.nextLine();
                String[] parts = line.split("");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(parts[j]);
                }
            }

            int[][] res = new int[n / k][n / k];

            for (int i = 0; i < n; i += k) {
                for (int j = 0; j < n; j += k) {
                    res[i / k][j / k] = arr[i][j];
                }
            }

            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    out.print(res[i][j]);
                }
                out.println();
            }
        }

        out.flush();
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
