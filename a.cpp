#include <bits/stdc++.h>
using namespace std;

struct Node {
    long long lazy;
    int a[32];

    Node() {
        lazy = 0;
        fill(a, a + 32, 0);
    }
};

class SegmentTree {
    vector<Node> tree;
    int size;

public:
    SegmentTree(int n) {
        size = n;
        tree.resize(4 * n);
    }

    void push(int v, int tl, int tr) {
        if (tree[v].lazy != 0) {
            for (int i = 0; i < 32; ++i) {
                if ((tree[v].lazy >> i) & 1) {
                    tree[v].a[i] = (tr - tl + 1);
                }
            }

            if (tl != tr) {
                tree[v * 2].lazy |= tree[v].lazy;
                tree[v * 2 + 1].lazy |= tree[v].lazy;
            }

            tree[v].lazy = 0;
        }
    }

    Node merge(const Node &left, const Node &right) {
        Node res;
        for (int i = 0; i < 32; ++i) {
            res.a[i] = left.a[i] + right.a[i];
        }
        return res;
    }

    void update(int v, int tl, int tr, int l, int r, int val) {
        push(v, tl, tr);
        if (r < tl || tr < l) return;

        if (l <= tl && tr <= r) {
            tree[v].lazy |= val;
            push(v, tl, tr);
            return;
        }

        int tm = (tl + tr) / 2;
        update(v * 2, tl, tm, l, r, val);
        update(v * 2 + 1, tm + 1, tr, l, r, val);
        tree[v] = merge(tree[v * 2], tree[v * 2 + 1]);
    }

    Node query(int v, int tl, int tr, int l, int r) {
        push(v, tl, tr);
        if (r < tl || tr < l) return Node();

        if (l <= tl && tr <= r) {
            return tree[v];
        }

        int tm = (tl + tr) / 2;
        Node left = query(v * 2, tl, tm, l, r);
        Node right = query(v * 2 + 1, tm + 1, tr, l, r);

        return merge(left, right);
    }

    void update(int l, int r, int val) {
        update(1, 0, size - 1, l, r - 1, val);
    }

    int query(int l, int r) {
        Node res = query(1, 0, size - 1, l, r - 1);
        int result = 0;
        int rangeSize = r - l;
        for (int i = 0; i < 32; ++i) {
            if (res.a[i] == rangeSize) {
                result |= (1 << i);
            }
        }
        return result;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    SegmentTree st(n);

    for (int i = 0; i < m; ++i) {
        int t;
        cin >> t;
        if (t == 1) {
            int l, r, v;
            cin >> l >> r >> v;
            st.update(l, r, v);
        } else {
            int l, r;
            cin >> l >> r;
            cout << st.query(l, r) << "\n";
        }
    }

    return 0;
}
