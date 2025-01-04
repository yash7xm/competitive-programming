import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KthSum {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        int[] brr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            brr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        Arrays.sort(brr);

        long lo = arr[0] + brr[0];
        long hi = arr[n - 1] + brr[n - 1];
        long ans = hi;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (check(arr, brr, mid, k)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        out.println(ans);
        out.flush();
    }

    static boolean check(int[] arr, int[] brr, long x, int k) {
        long count = 0;
        for (int num : arr) {
            count += countPairs(brr, x - num);
            if (count >= k)
                return true;
        }
        return count >= k;
    }

    static int countPairs(int[] arr, long target) {
        int lo = 0, hi = arr.length - 1, ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) {
                ans = mid + 1;
                lo = mid + 1;
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
