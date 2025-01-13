import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SplittingAnArray {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        long lo = 0L, hi = 0L;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            hi += arr[i];
            lo = Math.max(lo, arr[i]);
        }

        long ans = -1;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            if (check(arr, mid, k)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        out.println(ans);
        out.flush();
    }

    static boolean check(int[] arr, long mid, int k) {
        int cnt = 1;
        long currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (currSum + arr[i] <= mid) {
                currSum += arr[i];
            } else {
                currSum = arr[i];
                cnt++;
            }
        }

        return cnt <= k;
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
