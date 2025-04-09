#include <bits/stdc++.h>
using namespace std;

struct Node {
    long long a, d, sum;

    Node() : a(0), d(0), sum(0) {}
};

class SegmentTree {
    vector<Node> tree;
    vector<int> arr;
    int size;

public:
    SegmentTree(const vector<int>& input) {
        size = input.size();
        arr = input;
        tree.resize(4 * size);
        build(1, 1, size);
    }

    void build(int v, int tl, int tr) {
        if (tl == tr) {
            tree[v].sum = arr[tl - 1];
        } else {
            int tm = (tl + tr) / 2;
            build(v * 2, tl, tm);
            build(v * 2 + 1, tm + 1, tr);
            tree[v].sum = tree[v * 2].sum + tree[v * 2 + 1].sum;
        }
    }

    void push(int v, int tl, int tr) {
        if (tree[v].a != 0 || tree[v].d != 0) {
            int n = tr - tl + 1;
            tree[v].sum += n * (2 * tree[v].a + (n - 1) * tree[v].d) / 2;

            if (tl != tr) {
                int tm = (tl + tr) / 2;
                int lenLeft = tm - tl + 1;

                tree[v * 2].a += tree[v].a;
                tree[v * 2].d += tree[v].d;

                tree[v * 2 + 1].a += tree[v].a + tree[v].d * lenLeft;
                tree[v * 2 + 1].d += tree[v].d;
            }

            tree[v].a = 0;
            tree[v].d = 0;
        }
    }

    void update(int v, int tl, int tr, int l, int r, long long a, long long d) {
        push(v, tl, tr);
        if (r < tl || tr < l) return;
        if (l <= tl && tr <= r) {
            long long offset = a + d * (tl - l);
            tree[v].a += offset;
            tree[v].d += d;
            push(v, tl, tr);
            return;
        }

        int tm = (tl + tr) / 2;
        update(v * 2, tl, tm, l, r, a, d);
        update(v * 2 + 1, tm + 1, tr, l, r, a, d);
        tree[v].sum = tree[v * 2].sum + tree[v * 2 + 1].sum;
    }

    long long query(int v, int tl, int tr, int l, int r) {
        push(v, tl, tr);
        if (r < tl || tr < l) return 0;
        if (l <= tl && tr <= r) {
            return tree[v].sum;
        }

        int tm = (tl + tr) / 2;
        return query(v * 2, tl, tm, l, r) + query(v * 2 + 1, tm + 1, tr, l, r);
    }

    void update(int l, int r, long long a, long long d) {
        update(1, 1, size, l, r, a, d);
    }

    long long query(int l, int r) {
        return query(1, 1, size, l, r);
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<int> arr(n);
    for (int& x : arr) {
        cin >> x;
    }

    SegmentTree st(arr);

    for (int i = 0; i < m; ++i) {
        int t;
        cin >> t;
        if (t == 1) {
            int l, r;
            cin >> l >> r;
            st.update(l, r, 1, 1);
        } else {
            int l, r;
            cin >> l >> r;
            cout << st.query(l, r) << "\n";
        }
    }

    return 0;
}
