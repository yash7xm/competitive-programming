package Range_Queries;
import java.util.*;
import java.io.*;

public class StaticRangeMinimumQueries {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int n = in.nextInt();
        int q = in.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }

        int len = (int) Math.ceil(Math.sqrt(n));

        int[] sqrt = new int[len];
        Arrays.fill(sqrt, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            sqrt[i / len] = Math.min(sqrt[i / len], arr[i]);
        }

        for (int i = 0; i < q; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            int min = Integer.MAX_VALUE;
            while (a <= b) {
                if (a % len == 0 && a + len - 1 <= b) {
                    min = Math.min(min, sqrt[a / len]);
                    a += len;
                } else {
                    min = Math.min(min, arr[a]);
                    a++;
                }
            }

            out.println(min);
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
