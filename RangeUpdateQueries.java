import java.util.Scanner;

public class RangeUpdateQueries {

    public static class SegmentTree {
        int[] tree;

        SegmentTree(int[] arr) {
            int n = arr.length;
            this.tree = new int[4 * n];
            this.Build(1, 0, n - 1, arr);
        }

        void Build(int node, int start, int end, int[] arr) {
            if (start == end) {
                this.tree[node] = arr[start];
                return;
            }

            int mid = (start + end) / 2;
            this.Build(2 * node, start, mid, arr);
            this.Build(2 * node + 1, mid + 1, end, arr);

            this.tree[node] = this.tree[2 * node] + this.tree[2 * node + 1];
        }

        int Query(int node, int start, int end, int l, int r) {
            if (start >= l && end <= r) {
                return this.tree[node];
            }

            if (start > r || end < l) {
                return 0;
            }

            int mid = (start + end) / 2;
            return this.Query(2 * node, start, mid, l, r) + this.Query(2 * node + 1, mid + 1, end, l, r);
        }

        void Update(int node, int start, int end, int l, int r, int x) {
            if (start == end) {
                if (start >= l && start <= r)
                    this.tree[node] += x;
                return;
            }

            if (start > r || end < l) {
                return;
            }

            int mid = (start + end) / 2;

            this.Update(2 * node, start, mid, l, r, x);
            this.Update(2 * node + 1, mid + 1, end, l, r, x);

            this.tree[node] = this.tree[2 * node] + this.tree[2 * node + 1];
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

        int[][] quer = new int[q][4];
        for (int i = 0; i < q; i++) {
            int type = in.nextInt();
            if (type == 1) {
                quer[i][0] = type;
                quer[i][1] = in.nextInt();
                quer[i][2] = in.nextInt();
                quer[i][3] = in.nextInt();
            } else {
                quer[i][0] = type;
                quer[i][1] = in.nextInt();
            }
        }

        SegmentTree sg = new SegmentTree(arr);

        for (int i = 0; i < q; i++) {
            int type = quer[i][0];
            if (type == 1) {
                int l = quer[i][1] - 1;
                int r = quer[i][2] - 1;
                int u = quer[i][3];
                sg.Update(1, 0, n - 1, l, r, u);
            } else {
                int l = quer[i][1] - 1;
                int r = quer[i][1] - 1;

                System.out.println(sg.Query(1, 0, n - 1, l, r));
            }
        }

        in.close();
    }
}
