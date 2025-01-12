import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheTrail {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            solve();
        }
        out.flush();
    }

    private static void solve() {
        int n = in.nextInt();
        int m = in.nextInt();
        String s = in.next();
        long[][] arr = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextLong();
            }
        }

        long[] rowsum = new long[n];
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < m; j++) {
                sum += arr[i][j];
            }
            rowsum[i] = sum;
        }

        long[] colsum = new long[m];
        for (int j = 0; j < m; j++) {
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i][j];
            }
            colsum[j] = sum;
        }

        int row = 0, col = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'R') {
                arr[row][col] = -colsum[col];
                colsum[col] = 0;
                rowsum[row] += arr[row][col];
                col++;
            } else if (ch == 'D') {
                arr[row][col] = -rowsum[row];
                rowsum[row] = 0;
                colsum[col] += arr[row][col];
                row++;
            }
        }

        arr[row][col] = -rowsum[row];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
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
