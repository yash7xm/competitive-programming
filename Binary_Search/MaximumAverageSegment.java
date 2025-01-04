import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class MaximumAverageSegment {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {

        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        double low = 0, high = 100, mid;
        int left = 0, right = 0;

        while (high - low > 1e-7) {
            mid = (low + high) / 2;
            if (canFindSegment(a, n, d, mid)) {
                low = mid;
                int[] result = findSegment(a, n, d, mid);
                left = result[0];
                right = result[1];
            } else {
                high = mid;
            }
        }

        out.println((left + 1) + " " + (right + 1));
        out.flush();
    }

    private static boolean canFindSegment(int[] a, int n, int d, double x) {
        double[] prefix = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + (a[i - 1] - x);
        }

        double minPrefix = 0;
        for (int i = d; i <= n; i++) {
            if (prefix[i] - minPrefix >= 0) {
                return true;
            }
            minPrefix = Math.min(minPrefix, prefix[i - d + 1]);
        }

        return false;
    }

    private static int[] findSegment(int[] a, int n, int d, double x) {
        double[] prefix = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + (a[i - 1] - x);
        }

        double minPrefix = 0;
        int minIndex = 0;
        for (int i = d; i <= n; i++) {
            if (prefix[i] - minPrefix >= 0) {
                return new int[] { minIndex, i - 1 };
            }
            if (prefix[i - d + 1] < minPrefix) {
                minPrefix = prefix[i - d + 1];
                minIndex = i - d + 1;
            }
        }

        return new int[] { -1, -1 };
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
