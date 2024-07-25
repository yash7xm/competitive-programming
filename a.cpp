#include <bits/stdc++.h>
using namespace std;

vector<int> arr;
vector<vector<int>> tree;

void merge(vector<int>& res, vector<int>& lista, vector<int>& listb) {
    int p = 0, q = 0;
    res.clear();
    while (p < lista.size() && q < listb.size()) {
        if (lista[p] < listb[q]) {
            res.push_back(lista[p]);
            p++;
        } else {
            res.push_back(listb[q]);
            q++;
        }
    }

    while (q < listb.size()) {
        res.push_back(listb[q]);
        q++;
    }

    while (p < lista.size()) {
        res.push_back(lista[p]);
        p++;
    }
}

void build(int node, int start, int end) {
    if (start == end) {
        tree[node].push_back(arr[start]);
        return;
    }

    int mid = (start + end) / 2;

    build(2 * node, start, mid);
    build(2 * node + 1, mid + 1, end);

    merge(tree[node], tree[2 * node], tree[2 * node + 1]);
}

void update(int node, int start, int end, int k, int x) {
    if (start == end) {
        tree[node][0] = x;
        return;
    }

    int mid = (start + end) / 2;
    if (k <= mid) {
        update(2 * node, start, mid, k, x);
    } else {
        update(2 * node + 1, mid + 1, end, k, x);
    }

    merge(tree[node], tree[2 * node], tree[2 * node + 1]);
}

int upperbound(vector<int>& list, int x) {
    int lo = 0;
    int hi = list.size() - 1;
    int ans = list.size();

    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (list[mid] > x) {
            ans = mid;
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return ans;
}

int query(int x, int y) {
    int res = 0;
    res = upperbound(tree[1], y) - upperbound(tree[1], x - 1);
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    arr.resize(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    tree.resize(4 * n);
    for (int i = 0; i < 4 * n; i++) {
        tree[i] = vector<int>();
    }

    build(1, 0, n - 1);

    cin.ignore(); // To ignore the newline character after the last integer input
    while (q-- > 0) {
        string line;
        getline(cin, line);
        stringstream ss(line);
        string type;
        ss >> type;

        if (type == "?") {
            int a, b;
            ss >> a >> b;
            int res = query(a, b);
            cout << res << "\n";
        } else {
            int k, x;
            ss >> k >> x;
            update(1, 0, n - 1, k - 1, x);
        }
    }

    return 0;
}
