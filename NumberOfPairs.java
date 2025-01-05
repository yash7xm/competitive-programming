import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberOfPairs {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int l = in.nextInt();
            int r = in.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            Arrays.sort(arr);
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                int left = upperBound(arr, i + 1, l - arr[i]);
                int right = lowerBound(arr, i + 1, r - arr[i]);

                if (left == -1 || right == -1) {
                    continue;
                }

                if (left <= right) {
                    cnt += right - left + 1;
                }
            }

            out.println(cnt);
        }
        out.flush();
    }

    static int upperBound(int[] arr, int lo, int x) {
        int hi = arr.length - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= x) {
                hi = mid - 1;
                ans = mid;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    static int lowerBound(int[] arr, int lo, int x) {
        int hi = arr.length - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= x) {
                lo = mid + 1;
                ans = mid;
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
