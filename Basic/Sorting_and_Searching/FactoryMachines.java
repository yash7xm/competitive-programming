package Sorting_and_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FactoryMachines {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int t = in.nextInt();

        long[] arr = new long[n];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            min = Math.min(min, arr[i]);
        }

        long lo = 1, hi = min * t;
        long ans = hi;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (check(arr, mid, t)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        out.println(ans);
        out.flush();
    }

    public static boolean check(long[] arr, long k, int t) {
        long cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt += k / arr[i];
        }
        return cnt >= t ? true : false;
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
