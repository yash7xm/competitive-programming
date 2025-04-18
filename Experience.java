import java.io.*;
import java.util.*;

public class Experience {
    static int[] parent, size;
    static long[] exp;
    static int n;

    public static void init(int n) {
        Experience.n = n;
        parent = new int[n + 1];    
        size = new int[n + 1];
        exp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public static int get(int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }

    public static void add(int x, int val) {
        int root = get(x);
        exp[root] += val;
    }

    public static long total(int x) {
        long ans = exp[x];
        while (x != parent[x]) {
            x = parent[x];
            ans += exp[x];
        }
        return ans;
    }

    public static void join(int x, int y) {
        int rx = get(x);
        int ry = get(y);

        if (rx == ry) return;

        if (size[rx] > size[ry]) {
            int temp = rx;
            rx = ry;
            ry = temp;
        }

        parent[rx] = ry;
        exp[rx] -= exp[ry]; 
        size[ry] += size[rx];
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();
        init(n);

        for (int i = 0; i < m; i++) {
            String op = in.next();
            if (op.equals("join")) {
                int x = in.nextInt();
                int y = in.nextInt();
                join(x, y);
            } else if (op.equals("add")) {
                int x = in.nextInt();
                int val = in.nextInt();
                add(x, val);
            } else if (op.equals("get")) {
                int x = in.nextInt();
                out.println(total(x));
            }
        }

        out.close();
    }

    // FastReader utility
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
    }
}
