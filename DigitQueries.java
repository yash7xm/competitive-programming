import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DigitQueries {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int q = in.nextInt();
        while (q-- > 0) {
            long k = in.nextLong();
            out.println(getNumber(k));
            out.flush();
        }
    }

    static long getNumber(long k) {
        long digits = 1, count = 9, start = 1;
        while (k > digits * count) {
            k -= digits * count;
            digits++;
            count *= 10;
            start *= 10;
        }

        long number = start + (k - 1) / digits;

        String numStr = Long.toString(number);
        return numStr.charAt((int) ((k - 1) % digits)) - '0';
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
