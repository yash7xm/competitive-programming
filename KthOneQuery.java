import java.io.*;
import java.util.*;

public class KthOneQuery {
    static class SegmentTree {
        int[] count;
        boolean[] flip;
        int size;

        SegmentTree(int n) {
            size = 1;
            while (size < n) size <<= 1;
            count = new int[size * 2];
            flip = new boolean[size * 2];
        }

        void push(int x, int lx, int rx) {
            if (flip[x] && rx - lx > 1) {
                int mid = (lx + rx) / 2;
                apply(2 * x + 1, lx, mid);
                apply(2 * x + 2, mid, rx);
                flip[x] = false;
            }
        }

        void apply(int x, int lx, int rx) {
            count[x] = (rx - lx) - count[x];
            flip[x] ^= true;
        }

        void flipRange(int l, int r) {
            flipRange(l, r, 0, 0, size);
        }

        void flipRange(int l, int r, int x, int lx, int rx) {
            if (lx >= r || rx <= l) return;
            if (lx >= l && rx <= r) {
                apply(x, lx, rx);
                return;
            }

            push(x, lx, rx);
            int mid = (lx + rx) / 2;
            flipRange(l, r, 2 * x + 1, lx, mid);
            flipRange(l, r, 2 * x + 2, mid, rx);
            count[x] = count[2 * x + 1] + count[2 * x + 2];
        }

        int kthOne(int k) {
            return kthOne(k, 0, 0, size);
        }

        int kthOne(int k, int x, int lx, int rx) {
            if (rx - lx == 1) return lx;

            push(x, lx, rx);
            int mid = (lx + rx) / 2;
            int leftCount = count[2 * x + 1];

            if (k < leftCount) return kthOne(k, 2 * x + 1, lx, mid);
            else return kthOne(k - leftCount, 2 * x + 2, mid, rx);
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();
        SegmentTree st = new SegmentTree(n);

        for (int i = 0; i < m; i++) {
            int t = in.nextInt();
            if (t == 1) {
                int l = in.nextInt();
                int r = in.nextInt();
                st.flipRange(l, r);
            } else {
                int k = in.nextInt();
                out.println(st.kthOne(k));
            }
        }

        out.flush();
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
    }
}
