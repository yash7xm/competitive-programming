import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumofThreeValues {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        int x = in.nextInt();

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = i + 1;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < n - 2; i++) {
            int a = arr[i][0];
            for (int j = i + 1; j < n - 1; j++) {
                int b = arr[j][0];
                long c = x - (a + b);
                int k = bs(arr, j + 1, c);
                if (k != -1) {
                    out.println(arr[i][1] + " " + arr[j][1] + " " + arr[k][1]);
                    out.flush();
                    return;
                }
            }
        }

        out.println("IMPOSSIBLE");
        out.flush();
    }

    private static int bs(int[][] arr, int k, long x) {
        int lo = k, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid][0] == x) {
                return mid;
            } else if (arr[mid][0] > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
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
