import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Mafia {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] arr = new int[n];
        long lo = 0, hi = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            hi += arr[i];
        }

        long ans = 0;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (check(arr, mid)) {
                hi = mid - 1;
                ans = mid;
            } else {
                lo = mid + 1;
            }
        }

        out.println(ans);
        out.flush();
    }

    static boolean check(int[] arr, long mid) {
        long cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mid) {
                return false;
            }
            cnt += mid - arr[i];
        }
        return cnt >= mid;
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
