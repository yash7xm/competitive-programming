import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Apartments {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int[] brr = new int[m];
        for (int i = 0; i < m; i++) {
            brr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        Arrays.sort(brr);

        int start = 0, res = 0;
        for (int i = 0; i < n; i++) {
            int idx = bs(brr, arr[i] - k, start);
            if (idx >= brr.length) {
                continue;
            } else {
                if (brr[idx] <= arr[i] + k) {
                    start = idx + 1;
                    res++;
                }
            }
        }

        out.println(res);
        out.flush();
    }

    public static int bs(int[] arr, int tar, int lo) {
        int hi = arr.length - 1, ans = arr.length;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= tar) {
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