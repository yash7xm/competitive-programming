import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheMeetingPlaceCannotBeChanged {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] pos = new int[n];
        int[] vel = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            vel[i] = in.nextInt();
        }

        double lo = 0, hi = 1e9;
        while (hi - lo > 1e-7) {
            double T = (lo + hi) / 2;
            if (check(T, pos, vel)) {
                hi = T;
            } else {
                lo = T;
            }
        }

        out.printf("%.6f\n", lo);
        out.flush();
    }

    static boolean check(double T, int[] pos, int[] vel) {
        double left = -1e9, right = 1e9;

        for (int i = 0; i < pos.length; i++) {
            double l = pos[i] - T * vel[i];
            double r = pos[i] + T * vel[i];

            left = Math.max(l, left);
            right = Math.min(r, right);

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
