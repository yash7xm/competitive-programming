import java.util.Scanner;

public class RangeXorQueries {

    public static class SegmentTree {
        int[] tree;

        SegmentTree(int n) {
            this.tree = new int[4 * n];
        }

        void Build(int node, int start, int end, int[] arr) {
            if (start == end) {
                this.tree[node] = arr[start];
                return;
            }

            int mid = (start + end) / 2;
            this.Build(2 * node, start, mid, arr);
            this.Build(2 * node + 1, mid + 1, end, arr);

            this.tree[node] = this.tree[2 * node] ^ this.tree[2 * node + 1];
        }

        int Query(int node, int start, int end, int l, int r) {
            if (start >= l && end <= r) {
                return this.tree[node];
            }

            if (start > r || end < l) {
                return 0;
            }

            int mid = (start + end) / 2;
            return this.Query(2 * node, start, mid, l, r) ^ this.Query(2 * node + 1, mid + 1, end, l, r);
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

        int[][] quer = new int[q][2];
        for (int i = 0; i < q; i++) {
            quer[i][0] = in.nextInt();
            quer[i][1] = in.nextInt();
        }

        SegmentTree sg = new SegmentTree(n);
        sg.Build(1, 0, n - 1, arr);

        for (int i = 0; i < q; i++) {
            int l = quer[i][0] - 1;
            int r = quer[i][1] - 1;
            System.out.println(sg.Query(1, 0, n - 1, l, r));
        }

        in.close();
    }
}
