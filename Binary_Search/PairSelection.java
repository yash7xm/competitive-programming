import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PairSelection {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int k = in.nextInt();

        int[] arr = new int[n];
        int[] brr = new int[n];

        double lo = 0, hi = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            brr[i] = in.nextInt();
            hi += arr[i];
        }

        double ans = 0;
        while (hi - lo > 1e-7) {
            double mid = (lo + hi) / 2;
            PriorityQueue<Double> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                pq.add(arr[i] - (mid * brr[i]));
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            double s = 0;
            while (pq.size() > 0) {
                s += pq.poll();
            }

            if (s >= 0) {
                ans = mid;
                lo = mid;
            } else {
                hi = mid;
            }
        }

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
    }
}
