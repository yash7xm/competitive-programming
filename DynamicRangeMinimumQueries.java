import java.util.*;
import java.io.*;

public class DynamicRangeMinimumQueries {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int arr[], sqrt[];
    static int len;

    static int query(int a, int b) {
        int min = Integer.MAX_VALUE;

        while (a <= b) {
            if (a % len == 0 && a + len - 1 <= b) {
                min = Math.min(sqrt[a / len], min);
                a += len;
            } else {
                min = Math.min(arr[a], min);
                a++;
            }
        }

        return min;
    }

    static void update(int k, int val) {
        int i = (k / len) * (len);
        arr[k] = val;
        sqrt[i / len] = Integer.MAX_VALUE;
        for (int j = 1; j <= len && i < arr.length; j++, i++) {
            sqrt[i / len] = Math.min(sqrt[i / len], arr[i]);
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int q = in.nextInt();

        arr = new int[n + 1];
        len = (int) Math.ceil(Math.sqrt(n));
        sqrt = new int[len];
        Arrays.fill(sqrt, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
            sqrt[i / len] = Math.min(sqrt[i / len], arr[i]);
        }

        for (int i = 0; i < q; i++) {
            int type = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();

            if (type == 1) {
                update(a, b);
            } else {
                out.println(query(a, b));
            }
        }

        out.flush();
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
