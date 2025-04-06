import java.io.*;
import java.util.*;

public class DistinctValuesWithSegmentTree {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class Query implements Comparable<Query> {
        int l, r, idx;

        Query(int l, int r, int idx) {
            this.l = l;
            this.r = r;
            this.idx = idx;
        }

        public int compareTo(Query other) {
            return Integer.compare(this.r, other.r);
        }
    }

    static class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        void update(int index, int value, int node, int start, int end) {
            if (start == end) {
                tree[node] = value;
                return;
            }
            int mid = (start + end) / 2;
            if (index <= mid)
                update(index, value, 2 * node, start, mid);
            else
                update(index, value, 2 * node + 1, mid + 1, end);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }

        void update(int index, int value) {
            update(index, value, 1, 0, n - 1);
        }

        int query(int l, int r, int node, int start, int end) {
            if (r < start || end < l) return 0;
            if (l <= start && end <= r) return tree[node];
            int mid = (start + end) / 2;
            return query(l, r, 2 * node, start, mid) +
                   query(l, r, 2 * node + 1, mid + 1, end);
        }

        int query(int l, int r) {
            return query(l, r, 1, 0, n - 1);
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int q = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();

        Query[] queries = new Query[q];
        for (int i = 0; i < q; i++) {
            int l = in.nextInt() - 1;
            int r = in.nextInt() - 1;
            queries[i] = new Query(l, r, i);
        }

        Arrays.sort(queries); 
        
        int[] answer = new int[q];
        SegmentTree segTree = new SegmentTree(n);
        Map<Integer, Integer> lastSeen = new HashMap<>();

        int idx = 0;
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            if (lastSeen.containsKey(val)) {
                segTree.update(lastSeen.get(val), 0);
            }
            segTree.update(i, 1);
            lastSeen.put(val, i);

            while (idx < q && queries[idx].r == i) {
                answer[queries[idx].idx] = segTree.query(queries[idx].l, queries[idx].r);
                idx++;
            }
        }

        for (int a : answer) out.println(a);
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
