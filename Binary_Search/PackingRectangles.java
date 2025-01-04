import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PackingRectangles {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int w = in.nextInt();
        int h = in.nextInt();
        int n = in.nextInt();

        long lo = 0;
        long hi = 1;
        long ans = hi;

        while (!canFit(w, h, n, hi)) {
            hi *= 2;
        }

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (canFit(w, h, n, mid)) {
                hi = mid - 1;
                ans = mid;
            } else {
                lo = mid + 1;
            }
        }

        out.println(ans);
        out.flush();
    }

    static boolean canFit(int w, int h, int n, long mid) {
        long x = mid / w;
        long y = mid / h;

        return x * y >= (long) n;
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
