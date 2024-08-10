import java.util.*;
import java.io.*;

public class FindKDistinctPointswithFixedCenter {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            int xc = in.nextInt();
            int yc = in.nextInt();
            int k = in.nextInt();

            int[][] res = new int[k][2];
            int x = xc * k;
            if (x > 0)
                x++;
            else
                x--;
            int sum = 0;
            for (int i = 0; i < k - 1; i++) {
                res[i][0] = x;
                sum += res[i][0];
                if (x > 0)
                    x++;
                else
                    x--;
            }
            res[k - 1][0] = (xc * k) - sum;
            int y = yc * k;
            if (y > 0)
                y++;
            else
                y--;
            sum = 0;
            for (int i = 0; i < k - 1; i++) {
                res[i][1] = y;
                sum += res[i][1];
                if (y > 0)
                    y++;
                else
                    y--;
            }
            res[k - 1][1] = (yc * k) - sum;

            for (int i = 0; i < k; i++) {
                System.out.println(res[i][0] + " " + res[i][1]);
            }
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
