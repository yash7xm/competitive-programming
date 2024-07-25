package Range_Queries;
import java.util.*;
import java.io.*;

public class PrefixSumQueries {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static final int N = 200010;
    static final int S = 1 << 18;

    static int n, q;
    static long[] a = new long[N];
    static Node[] tt = new Node[S << 1];

    static class Node {
        long sum, pref;

        Node(long sum, long pref) {
            this.sum = sum;
            this.pref = pref;
        }

        Node(long x) {
            this.sum = x;
            this.pref = Math.max(0, x);
        }

        static Node combine(Node a, Node b) {
            return new Node(a.sum + b.sum, Math.max(a.pref, a.sum + b.pref));
        }
    }

    static void build(int k, int l, int r) {
        if (l == r) {
            tt[k] = new Node(a[l]);
            return;
        }
        int m = (l + r) >> 1;
        build(k << 1, l, m);
        build(k << 1 | 1, m + 1, r);
        tt[k] = Node.combine(tt[k << 1], tt[k << 1 | 1]);
    }

    static void update(int i, long x, int k, int l, int r) {
        if (l == r) {
            tt[k] = new Node(x);
            return;
        }
        int m = (l + r) >> 1;
        if (i <= m)
            update(i, x, k << 1, l, m);
        else
            update(i, x, k << 1 | 1, m + 1, r);
        tt[k] = Node.combine(tt[k << 1], tt[k << 1 | 1]);
    }

    static Node query(int ql, int qr, int k, int l, int r) {
        if (ql > r || qr < l)
            return new Node(0);
        if (ql <= l && qr >= r)
            return tt[k];
        int m = (l + r) >> 1;
        Node q1 = query(ql, qr, k << 1, l, m);
        Node q2 = query(ql, qr, k << 1 | 1, m + 1, r);
        return Node.combine(q1, q2);
    }

    public static void main(String[] args) {
        n = in.nextInt();
        q = in.nextInt();
        for (int i = 1; i <= n; ++i) {
            a[i] = in.nextLong();
        }
        build(1, 1, n);

        for (int i = 0; i < q; ++i) {
            int t = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            if (t == 1) {
                update(x, a[x] = y, 1, 1, n);
            } else {
                out.println(query(x, y, 1, 1, n).pref);
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
