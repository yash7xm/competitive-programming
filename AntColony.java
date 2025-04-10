import java.util.*;
import java.io.*;

public class AntColony {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class SegmentTree {
        int[] tree;
        int[] arr;
        int n;

        public SegmentTree(int[] arr) {
            this.arr = arr;
            this.n = arr.length;
            tree = new int[4 * n];
            build(1, 0, n - 1);
        }

        void build(int node, int l, int r) {
            if (l == r) {
                tree[node] = arr[l];
            } else {
                int mid = (l + r) / 2;
                build(2 * node, l, mid);
                build(2 * node + 1, mid + 1, r);
                tree[node] = gcd(tree[2 * node], tree[2 * node + 1]);
            }
        }

        int query(int node, int l, int r, int ql, int qr) {
            if (qr < l || ql > r) return 0;
            if (ql <= l && r <= qr) return tree[node];
            int mid = (l + r) / 2;
            int leftGcd = query(2 * node, l, mid, ql, qr);
            int rightGcd = query(2 * node + 1, mid + 1, r, ql, qr);
            return gcd(leftGcd, rightGcd);
        }

        int gcdQuery(int l, int r) {
            return query(1, 0, n - 1, l, r);
        }
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] arr = new int[n];
        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            valueToIndices.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        }

        SegmentTree segTree = new SegmentTree(arr);

        int t = in.nextInt();
        while (t-- > 0) {
            int l = in.nextInt() - 1;
            int r = in.nextInt() - 1;

            int rangeGcd = segTree.gcdQuery(l, r);
            List<Integer> indices = valueToIndices.getOrDefault(rangeGcd, new ArrayList<>());

            int left = lowerBound(indices, l);
            int right = upperBound(indices, r);

            int countGcd = right - left;
            int total = r - l + 1;

            out.println(total - countGcd);
        }

        out.flush();
    }

    static int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) >= target) r = m;
            else l = m + 1;
        }
        return l;
    }

    static int upperBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) > target) r = m;
            else l = m + 1;
        }
        return l;
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
