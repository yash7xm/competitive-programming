import java.io.*;
import java.util.*;

public class SerejaAndBrackets {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class Node {
        int open, close, full;

        Node(int open, int close, int full) {
            this.open = open;
            this.close = close;
            this.full = full;
        }
    }

    static class SegmentTree {
        Node[] tree;
        int size;
        String data;

        SegmentTree(String s) {
            this.size = s.length();
            this.data = s;
            tree = new Node[4 * size];
            build(1, 0, size - 1);
        }

        void build(int node, int start, int end) {
            if (start == end) {
                char ch = data.charAt(start);
                if (ch == '(')
                    tree[node] = new Node(1, 0, 0);
                else
                    tree[node] = new Node(0, 1, 0);
                return;
            }

            int mid = (start + end) / 2;
            build(2 * node, start, mid);
            build(2 * node + 1, mid + 1, end);
            tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
        }

        Node merge(Node left, Node right) {
            int match = Math.min(left.open, right.close);
            int open = left.open + right.open - match;
            int close = left.close + right.close - match;
            int full = left.full + right.full + match;
            return new Node(open, close, full);
        }

        Node query(int l, int r) {
            return query(1, 0, size - 1, l, r);
        }

        Node query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return new Node(0, 0, 0);
            }
            if (l <= start && end <= r) {
                return tree[node];
            }

            int mid = (start + end) / 2;
            Node left = query(2 * node, start, mid, l, r);
            Node right = query(2 * node + 1, mid + 1, end, l, r);
            return merge(left, right);
        }
    }

    public static void main(String[] args) {
        String s = in.next();
        int m = in.nextInt();

        SegmentTree segTree = new SegmentTree(s);

        while (m-- > 0) {
            int l = in.nextInt() - 1;
            int r = in.nextInt() - 1;
            Node res = segTree.query(l, r);
            out.println(res.full * 2);
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
