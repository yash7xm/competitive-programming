import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VeryEasyTask {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        long n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        long hi = Math.max(x, y) * n;
        long lo = 0;
        long ans = -1;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (check(mid, x, y, n)) {
                hi = mid - 1;
                ans = mid;
            } else {
                lo = mid + 1;
            }
        }

        out.println(ans);
        out.flush();
    }

    static boolean check(long t, int x, int y, long n) {
        if (t < Math.min(x, y)) {
            return false;
        }

        int cnt = 1;
        t -= Math.min(x, y);

        cnt += t / x + t / y;

        return cnt >= n;
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
