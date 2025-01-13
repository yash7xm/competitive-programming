import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Equation {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        double c = in.nextDouble();

        double lo = 0;
        double hi = Math.ceil(Math.sqrt(c));
        double ans = hi;

        for (int i = 0; i < 40; i++) {
            double x = (lo + hi) / 2;
            if ((x * x) + Math.sqrt(x) <= c) {
                lo = x;
            } else {
                hi = x;
            }
        }

        ans = (lo + hi) / 2;
        out.println(ans);
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
    }
}
