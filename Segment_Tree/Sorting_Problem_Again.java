import java.util.Scanner;

public class Sorting_Problem_Again {

    public static class Node {
        int[] arr;
        int l;
        int r;

        Node(int[] arr, int l, int r) {
            this.arr = arr;
            this.l = l;
            this.r = r;
        }
    }

    public static class SegmentTree {
        Node[] tree;

        SegmentTree(int[] arr) {
            int n = arr.length;
            tree = new Node[4 * n];
            this.Build(1, 0, n - 1, arr);
        }

        void Build(int id, int start, int end, int[] arr) {
            if (start == end) {
                int[] a = { arr[start] };
                this.tree[id] = new Node(a, -1, -1);
                return;
            }

            int mid = (start + end) / 2;
            this.Build(2 * id, start, mid, arr);
            this.Build(2 * id + 1, mid + 1, end, arr);

            this.tree[id] = merge(this.tree[2 * id], this.tree[2 * id + 1]);
        }

        void Update(int id, int start, int end, int i, int x) {
            if (start == end) {
                Node node = new Node(new int[] { x }, -1, -1);
                this.tree[id] = node;
                return;
            }

            int mid = (start + end) / 2;

            if (i <= mid) {
                this.Update(2 * id, start, mid, i, x);
            } else {
                this.Update(2 * id + 1, mid + 1, end, i, x);
            }

            this.tree[id] = merge(this.tree[2 * id], this.tree[2 * id + 1]);
        }

        void Query() {
            int l = this.tree[1].l;
            int r = this.tree[1].r;

            System.out.println(l + " " + r);
        }

        Node merge(Node first, Node second) {
            int[] arr1 = first.arr;
            int[] arr2 = second.arr;

            int[] res = new int[arr1.length + arr2.length];

            int p = 0;
            int q = 0;
            int k = 0;

            while (p < arr1.length && q < arr2.length) {
                if (arr1[p] < arr2[q]) {
                    res[k] = arr1[p];
                    p++;
                } else {
                    res[k] = arr2[q];
                    q++;
                }
                k++;
            }

            while (p < arr1.length) {
                res[k] = arr1[p];
                p++;
                k++;
            }

            while (q < arr2.length) {
                res[k] = arr2[q];
                q++;
                k++;
            }

            Node mergedNode = new Node(res, -1, -1);

            if (arr1[arr1.length - 1] <= arr2[0]) {
                if ((first.l == -1 && first.r == -1) && (second.l != -1 && second.r != -1)) {
                    mergedNode.l = second.l + arr1.length;
                    mergedNode.r = second.r + arr2.length;
                } else if ((first.l != -1 && first.r != -1) && (second.l == -1 && second.r == -1)) {
                    mergedNode.l = first.l;
                    mergedNode.r = first.r;
                } else if ((first.l == -1 && first.r == -1) && (second.l == -1 && second.r == -1)) {
                    mergedNode.l = -1;
                    mergedNode.r = -1;
                } else {
                    mergedNode.l = first.l;
                    mergedNode.r = second.r + arr1.length;
                }
            } else {
                int r = this.lowerBound(arr2, arr1[arr1.length - 1]);
                int l = this.lowerBound(arr1, arr2[0]);

                r += arr1.length; 

                mergedNode.l = l + 1;
                mergedNode.r = r;
            }
            return mergedNode;
        }

        int lowerBound(int[] arr, int t) {
            int lo = 0;
            int hi = arr.length - 1;
            int ans = arr.length;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;

                if (arr[mid] >= t) {
                    ans = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            return ans;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int q = in.nextInt();
            int[][] quer = new int[q][2];
            for (int i = 0; i < q; i++) {
                quer[i][0] = in.nextInt();
                quer[i][1] = in.nextInt();
            }

            SegmentTree sg = new SegmentTree(arr);

            sg.Query();

            for (int i = 0; i < q; i++) {
                sg.Update(1, 0, n - 1, quer[i][0] - 1, quer[i][1]);
                sg.Query();
            }
        }
        in.close();
    }
}
