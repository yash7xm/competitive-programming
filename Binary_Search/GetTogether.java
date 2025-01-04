import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GetTogether {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        long[] pos = new long[n];
        long[] vel = new long[n];

        for (int i = 0; i < n; i++) {
            pos[i] = in.nextLong();
            vel[i] = in.nextLong();
        }

        double lo = 0, hi = 1e9;

        while (hi - lo > 1e-6) {
            double mid = (lo + hi) / 2.0;
            if (canMeet(mid, pos, vel)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        out.printf("%.6f\n", lo);
        out.flush();
    }

    static boolean canMeet(double time, long[] pos, long[] vel) {
        double left = -1e9, right = 1e9;

        for (int i = 0; i < pos.length; i++) {
            double l = pos[i] - vel[i] * time;
            double r = pos[i] + vel[i] * time;

            left = Math.max(left, l);
            right = Math.min(right, r);

            if (left > right) {
                return false;
            }
        }

        return true;
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
