package Two_Pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CellularNetwork {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] cities = new int[n];
        int[] towers = new int[m];

        for (int i = 0; i < n; i++) {
            cities[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            towers[i] = in.nextInt();
        }

        long d = 0;
        for (int city : cities) {
            long r = upperBound(towers, city);
            long l = lowerBound(towers, city);

            long closest = Long.MAX_VALUE;
            if (r != Long.MAX_VALUE) {
                closest = Math.min(closest, Math.abs(city - r));
            }
            if (l != Long.MIN_VALUE) {
                closest = Math.min(closest, Math.abs(city - l));
            }

            d = Math.max(d, closest);
        }

        out.println(d);
        out.flush();
    }

    static long upperBound(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        long ans = Long.MAX_VALUE;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= x) {
                hi = mid - 1;
                ans = arr[mid];
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    static long lowerBound(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        long ans = Long.MIN_VALUE;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= x) {
                lo = mid + 1;
                ans = arr[mid];
            } else {
                hi = mid - 1;
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
