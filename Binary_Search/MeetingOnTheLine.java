import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MeetingOnTheLine {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] pos = new int[n];
            int[] time = new int[n];

            for (int i = 0; i < n; i++) {
                pos[i] = in.nextInt() * 2;
            }

            for (int i = 0; i < n; i++) {
                time[i] = in.nextInt() * 2;
            }

            int l = -1, r = (int) 1e9 * 2;
            while (r - l > 1) {
                int m = (l + r) / 2;
                if (canMeet(m, pos, time)) {
                    r = m;
                } else {
                    l = m;
                }
            }

            int mxl = 0, mnr = (int) 1e9 * 2;
            for (int i = 0; i < n; i++) {
                mxl = Math.max(mxl, pos[i] - (r - time[i]));
                mnr = Math.min(mnr, pos[i] + (r - time[i]));
            }

            if (mxl % 2 == 0) {
                out.println(mxl / 2);
            } else {
                out.println(mxl / 2 + ".5");
            }
        }
        out.flush();
    }

    static boolean canMeet(int T, int[] pos, int[] time) {
        int mxl = 0, mnr = (int) 1e9 * 2;

        for (int i = 0; i < pos.length; i++) {
            if (time[i] > T) {
                return false;
            }

            mxl = Math.max(mxl, pos[i] - (T - time[i]));
            mnr = Math.min(mnr, pos[i] + (T - time[i]));
        }

        return mxl <= mnr;
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
    }
}
