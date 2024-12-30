import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KuriyamaMiraisStones {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        long[] p1 = new long[n];
        for (int i = 0; i < n; i++) {
            p1[i] = arr[i];
            if (i != 0) {
                p1[i] += p1[i - 1];
            }
        }

        Arrays.sort(arr);
        long[] p2 = new long[n];
        for (int i = 0; i < n; i++) {
            p2[i] = arr[i];
            if (i != 0) {
                p2[i] += p2[i - 1];
            }
        }

        int q = in.nextInt();

        for (int i = 0; i < q; i++) {
            int type = in.nextInt();
            int l = in.nextInt() - 1;
            int r = in.nextInt() - 1;

            long res = 0;
            if (type == 1) {
                res = l > 0 ? p1[r] - p1[l - 1] : p1[r];
            } else {
                res = l > 0 ? p2[r] - p2[l - 1] : p2[r];
            }

            out.println(res);
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
    }
}
