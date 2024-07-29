#include <bits/stdc++.h>
using namespace std;

struct Node {
    long long sum, maxsubsum, prefix, suffix;
    Node(long long sum = 0, long long maxsubsum = 0, long long prefix = 0, long long suffix = 0) 
        : sum(sum), maxsubsum(maxsubsum), prefix(prefix), suffix(suffix) {}
};

vector<int> arr;
vector<Node> tree;

Node merge(Node left, Node right) {
    Node node;
    node.sum = left.sum + right.sum;
    node.prefix = max(left.prefix, left.sum + right.prefix);
    node.suffix = max(right.suffix, right.sum + left.suffix);
    node.maxsubsum = max({left.maxsubsum, right.maxsubsum, left.suffix + right.prefix});
    return node;
}

void build(int node, int start, int end) {
    if (start == end) {
        tree[node] = Node(arr[start], arr[start], arr[start], arr[start]);
        return;
    }

    int mid = (start + end) / 2;
    build(2 * node, start, mid);
    build(2 * node + 1, mid + 1, end);
    tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
}

void update(int node, int start, int end, int i, int x) {
    if (start == end) {
        tree[node] = Node(x, x, x, x);
        return;
    }

    int mid = (start + end) / 2;
    if (i <= mid) {
        update(2 * node, start, mid, i, x);
    } else {
        update(2 * node + 1, mid + 1, end, i, x);
    }
    tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    arr.resize(n);
    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    tree.resize(4 * n);
    build(1, 0, n - 1);

    for (int i = 0; i < q; ++i) {
        int k, x;
        cin >> k >> x;
        --k;
        arr[k] = x;
        update(1, 0, n - 1, k, x);
        long long res = tree[1].maxsubsum;
        if (res < 0) res = 0;
        cout << res << '\n';
    }

    return 0;
}
