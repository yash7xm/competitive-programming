import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Ropes {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        double lo = 0, hi = Long.MIN_VALUE, ans = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            hi = Math.max(hi, arr[i]);
        }

        for (int i = 0; i < 40; i++) {
            double mid = (lo + hi) / 2;
            if (check(mid, arr, k))
                lo = mid;
            else
                hi = mid;
        }

        ans = (lo + hi) / 2;
        out.println(ans);
        out.flush();
    }

    static boolean check(double mid, int[] arr, int k) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt += arr[i] / mid;
        }
        return cnt >= k;
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
