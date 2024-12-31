import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MultiplicationTable {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        long n = in.nextInt();
        long lo = 1, hi = n * n, ans = hi;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (check(mid, n)) {
                hi = mid - 1;
                ans = mid;
            } else {
                lo = mid + 1;
            }
        }

        out.println(ans);
        out.flush();
    }

    static boolean check(long mid, long n) {
        long k = 0;
        for (int i = 1; i <= n; i++) {
            k += Math.min(n, mid / i);
        }

        return k >= (n * n + 1) / 2;
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