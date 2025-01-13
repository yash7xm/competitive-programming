import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaximumMedian {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        long lo = arr[n / 2];
        long hi = arr[n - 1] + k;
        long ans = lo;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (check(arr, mid, k)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        out.println(ans);
        out.flush();
    }

    static boolean check(int[] arr, long mid, int k) {
        int moves = 0;
        int n = arr.length;
        for (int i = n / 2; i < n; i++) {
            if (arr[i] < mid) {
                moves += mid - arr[i];
                if (moves > k)
                    return false;
            }
        }

        return moves <= k;
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
