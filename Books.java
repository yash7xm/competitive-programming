import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Books {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int t = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        long[] p = new long[n + 1];
        p[0] = 0;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] + arr[i - 1];
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            long x = p[i] - t;
            int left = upperBound(p, i, x);
            res = Math.max(res, i - left);
        }

        out.println(res);
        out.flush();
    }

    static int upperBound(long[] p, int hi, long x) {
        int lo = 0, ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (p[mid] >= x) {
                hi = mid - 1;
                ans = mid;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
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
