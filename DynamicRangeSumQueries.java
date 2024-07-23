import java.util.*;
import java.io.*;

public class DynamicRangeSumQueries {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int arr[];
    static long sqrt[];
    static int len;

    static void build() {
        sqrt = new long[len];
        for (int i = 1; i < arr.length; i++) {
            sqrt[i / len] += arr[i];
        }
    }

    static void update(int k, int delta) {
        sqrt[k / len] = sqrt[k / len] - arr[k] + delta;
        arr[k] = delta;
    }

    static long query(int a, int b) {
        long sum = 0;
        while (a <= b) {
            if (a % len == 0 && a + len - 1 <= b) {
                sum += sqrt[a / len];
                a += len;
            } else {
                sum += arr[a];
                a++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int q = in.nextInt();

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }

        len = (int) Math.ceil(Math.sqrt(n));
        build();

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
