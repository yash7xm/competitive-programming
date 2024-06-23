import java.util.Scanner;

public class EvenAndOddQueries {

    public static class Node {
        long val;
        int odds;
        int evens;

        Node(long val, int odds, int evens) {
            this.val = val;
            this.odds = odds;
            this.evens = evens;
        }
    }

    public static class SegmentTree {
        Node[] tree;

        SegmentTree(int[] arr) {
            int n = arr.length;
            this.tree = new Node[4 * n];
            this.Build(1, 0, n - 1, arr);
        }

        void Build(int id, int start, int end, int[] arr) {
            if (start == end) {
                this.tree[id] = new Node(0, 0, 0);
                this.tree[id].val = arr[start];
                if (arr[start] % 2 == 0) {
                    this.tree[id].odds = 0;
                    this.tree[id].evens = 1;
                } else {
                    this.tree[id].odds = 1;
                    this.tree[id].evens = 0;
                }

                return;
            }

            int mid = (start + end) / 2;

            this.Build(2 * id, start, mid, arr);
            this.Build(2 * id + 1, mid + 1, end, arr);

            this.tree[id] = new Node(0, 0, 0);
            this.tree[id].val = this.tree[2 * id].val + this.tree[2 * id + 1].val;
            this.tree[id].odds = this.tree[2 * id].odds + this.tree[2 * id + 1].odds;
            this.tree[id].evens = this.tree[2 * id].evens + this.tree[2 * id + 1].evens;
        }

        void Update(int id, int start, int end, int i, int x) {
            if (start == end) {
                this.tree[id].val = x;
                if (x % 2 == 0) {
                    this.tree[id].odds = 0;
                    this.tree[id].evens = 1;
                } else {
                    this.tree[id].odds = 1;
                    this.tree[id].evens = 0;
                }
                return;
            }

            int mid = (start + end) / 2;

            if (i <= mid) {
                this.Update(2 * id, start, mid, i, x);
            } else {
                this.Update(2 * id + 1, mid + 1, end, i, x);
            }

            this.tree[id].val = this.tree[2 * id].val + this.tree[2 * id + 1].val;
            this.tree[id].odds = this.tree[2 * id].odds + this.tree[2 * id + 1].odds;
            this.tree[id].evens = this.tree[2 * id].evens + this.tree[2 * id + 1].evens;
        }

        int QueryOdd(int id, int start, int end, int l, int r) {
            if (start >= l && end <= r) {
                return this.tree[id].odds;
            }

            if (start > r || end < l) {
                return 0;
            }

            int mid = (start + end) / 2;

            return this.QueryOdd(2 * id, start, mid, l, r) + this.QueryOdd(2 * id + 1, mid + 1, end, l, r);
        }

        int QueryEven(int id, int start, int end, int l, int r) {
            if (start >= l && end <= r) {
                return this.tree[id].evens;
            }

            if (start > r || end < l) {
                return 0;
            }

            int mid = (start + end) / 2;

            return this.QueryEven(2 * id, start, mid, l, r) + this.QueryEven(2 * id + 1, mid + 1, end, l, r);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        SegmentTree sg = new SegmentTree(arr);
        int q = in.nextInt();
        while (q-- > 0) {
            int type = in.nextInt();
            if (type == 0) {
                int i = in.nextInt();
                int x = in.nextInt();
                sg.Update(1, 0, n - 1, i - 1, x);
            } else {
                int l = in.nextInt();
                int r = in.nextInt();
                if (type == 1) {
                    System.out.println(sg.QueryEven(1, 0, n - 1, l - 1, r - 1));
                } else {
                    System.out.println(sg.QueryOdd(1, 0, n - 1, l - 1, r - 1));
                }
            }
        }

        in.close();
    }
}
