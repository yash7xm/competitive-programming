import java.util.Scanner;

public class Range_Queries_I {

    public static class SegmentTree {
        long[] tree;

        SegmentTree(int n) {
            this.tree = new long[4 * n];
        }

        void Build(int node, int start, int end, int[] arr) {

            // Leaf Node
            if (start == end) {
                this.tree[node] = arr[start];
                return;
            }

            int mid = (start + end) / 2;

            // Left Node
            Build(2 * node, start, mid, arr);
            // Right Node
            Build(2 * node + 1, mid + 1, end, arr);

            // Merging
            this.tree[node] = this.tree[2 * node] + this.tree[2 * node + 1];
        }

        void Update(int node, int start, int end, int i, int x) {
            // Leaf Node
            if (start == end) {
                this.tree[node] = x;
                return;
            }

            int mid = (start + end) / 2;

            if (i <= mid)
                Update(2 * node, start, mid, i, x);
            else
                Update(2 * node + 1, mid + 1, end, i, x);

            this.tree[node] = this.tree[2 * node] + this.tree[2 * node + 1];
        }

        long Query(int node, int start, int end, int l, int r) {
            if (start >= l && end <= r) {
                return this.tree[node];
            }

            if (start > r || end < l) {
                return 0;
            }

            int mid = (start + end) / 2;
            return Query(2 * node, start, mid, l, r) + Query(2 * node + 1, mid + 1, end, l, r);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int q = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int[][] quer = new int[q][3];
        for (int i = 0; i < q; i++) {
            quer[i][0] = in.nextInt();
            quer[i][1] = in.nextInt();
            quer[i][2] = in.nextInt();
        }

        SegmentTree sg = new SegmentTree(n);

        sg.Build(1, 0, n - 1, arr);

        for (int i = 0; i < q; i++) {
            int type = quer[i][0];
            int l = quer[i][1] - 1;
            int r = quer[i][2];

            if (type == 1) {
                sg.Update(1, 0, n - 1, l, r);
            } else {
                System.out.println(sg.Query(1, 0, n - 1, l, r - 1));
            }
        }

        in.close();
    }
}
