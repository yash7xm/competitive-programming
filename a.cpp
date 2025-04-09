#include <bits/stdc++.h>
using namespace std;

struct Node {
    long long lazyAdd = 0, lazySet = 0, sum = 0;
};

class SegmentTree {
    vector<Node> tree;
    vector<int> A;
    int size;

public:
    SegmentTree(const vector<int>& a) {
        A = a;
        size = a.size();
        tree.resize(4 * size);
        build(1, 0, size - 1);
    }

    Node merge(const Node& left, const Node& right) {
        return Node{0LL, 0LL, left.sum + right.sum};
    }

    void push(int v, int tl, int tr) {
        if (tree[v].lazySet != 0) {
            tree[v].sum = tree[v].lazySet * (tr - tl + 1);
            if (tl != tr) {
                tree[v * 2].lazySet = tree[v].lazySet;
                tree[v * 2 + 1].lazySet = tree[v].lazySet;
                tree[v * 2].lazyAdd = 0;
                tree[v * 2 + 1].lazyAdd = 0;
            }
            tree[v].lazySet = 0;
        }

        if (tree[v].lazyAdd != 0) {
            tree[v].sum += tree[v].lazyAdd * (tr - tl + 1);
            if (tl != tr) {
                tree[v * 2].lazyAdd += tree[v].lazyAdd;
                tree[v * 2 + 1].lazyAdd += tree[v].lazyAdd;
            }
            tree[v].lazyAdd = 0;
        }
    }

    void build(int v, int tl, int tr) {
        if (tl == tr) {
            tree[v].sum = A[tl];
        } else {
            int tm = (tl + tr) / 2;
            build(v * 2, tl, tm);
            build(v * 2 + 1, tm + 1, tr);
            tree[v] = merge(tree[v * 2], tree[v * 2 + 1]);
        }
    }

    void update(int v, int tl, int tr, int l, int r, long long val, int type) {
        push(v, tl, tr);
        if (tr < l || tl > r) return;

        if (l <= tl && tr <= r) {
            if (type == 1) {
                tree[v].lazyAdd += val;
            } else {
                tree[v].lazySet = val;
                tree[v].lazyAdd = 0;
            }
            push(v, tl, tr);
            return;
        }

        int tm = (tl + tr) / 2;
        update(v * 2, tl, tm, l, r, val, type);
        update(v * 2 + 1, tm + 1, tr, l, r, val, type);
        tree[v] = merge(tree[v * 2], tree[v * 2 + 1]);
    }

    long long query(int v, int tl, int tr, int l, int r) {
        push(v, tl, tr);
        if (tr < l || tl > r) return 0;
        if (l <= tl && tr <= r) return tree[v].sum;
        int tm = (tl + tr) / 2;
        long long left = query(v * 2, tl, tm, l, r);
        long long right = query(v * 2 + 1, tm + 1, tr, l, r);
        return left + right;
    }

    void update(int l, int r, int x, int type) {
        update(1, 0, size - 1, l - 1, r - 1, x, type);
    }

    long long query(int l, int r) {
        return query(1, 0, size - 1, l - 1, r - 1);
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;
    vector<int> A(n);
    for (int i = 0; i < n; ++i) cin >> A[i];

    SegmentTree st(A);

    for (int i = 0; i < q; ++i) {
        int t;
        cin >> t;
        if (t == 1) {
            int l, r, x;
            cin >> l >> r >> x;
            st.update(l, r, x, 1);
        } else if (t == 2) {
            int l, r, x;
            cin >> l >> r >> x;
            st.update(l, r, x, 2);
        } else {
            int l, r;
            cin >> l >> r;
            cout << st.query(l, r) << '\n';
        }
    }

    return 0;
}
