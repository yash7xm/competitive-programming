import java.util.Scanner;

public class HotelQueries {

    public static class SegmentTree {
        int[] tree;

        SegmentTree(int[] arr) {
            int n = arr.length;
            tree = new int[4 * n];
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

            this.tree[node] = Math.max(this.tree[2 * node], this.tree[2 * node + 1]);
        }

        void Update(int node, int start, int end, int i, int x) {
            if (start == end) {
                this.tree[node] -= x;
                return;
            }

            int mid = (start + end) / 2;

            if (i <= mid) {
                this.Update(2 * node, start, mid, i, x);
            } else {
                this.Update(2 * node + 1, mid + 1, end, i, x);
            }

            this.tree[node] = Math.max(this.tree[2 * node], this.tree[2 * node + 1]);
        }

        int Query(int node, int start, int end, int x) {
            if (start == end) {
                if (this.tree[node] < x) {
                    return -1;
                }
                return start;
            }

            if (this.tree[node] < x) {
                return -1;
            }

            int mid = (start + end) / 2;

            if (this.tree[2 * node] >= x) {
                return this.Query(2 * node, start, mid, x);
            } else {
                return this.Query(2 * node + 1, mid + 1, end, x);
            }

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
        }

        int[] g = new int[m];
        for (int i = 0; i < m; i++) {
            g[i] = in.nextInt();
        }

        SegmentTree sg = new SegmentTree(h);

        for (int i = 0; i < m; i++) {
            int res = (sg.Query(1, 0, n - 1, g[i]));
            if (res != -1) {
                sg.Update(1, 0, n - 1, res, g[i]);
            }
            res++;
            System.out.print(res + " ");
        }
        System.out.println();

        in.close();
    }
}
