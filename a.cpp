#include <bits/stdc++.h>
using namespace std;

struct Queries {
    int type, a, b;
    Queries(int type, int a, int b) : type(type), a(a), b(b) {}
};

vector<int> arr, tree;
vector<int> allVals;
vector<Queries> quers;
unordered_map<int, int> compressMap;

void compressIndexes() {
    sort(allVals.begin(), allVals.end());
    allVals.erase(unique(allVals.begin(), allVals.end()), allVals.end());

    for (int i = 0; i < allVals.size(); i++) {
        compressMap[allVals[i]] = i;
    }
}

void update(int node, int start, int end, int idx, int val) {
    if (start == end) {
        tree[node] += val;
    } else {
        int mid = (start + end) / 2;
        if (start <= idx && idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
}

int query(int node, int start, int end, int l, int r) {
    if (r < start || end < l) {
        return 0;
    }
    if (l <= start && end <= r) {
        return tree[node];
    }
    int mid = (start + end) / 2;
    int left_query = query(2 * node, start, mid, l, r);
    int right_query = query(2 * node + 1, mid + 1, end, l, r);
    return left_query + right_query;
}

void build() {
    for (int i = 0; i < arr.size(); i++) {
        int k = compressMap[arr[i]];
        update(1, 0, allVals.size() - 1, k, 1);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    arr.resize(n);
    allVals.reserve(n + 2 * q);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        allVals.push_back(arr[i]);
    }

    quers.reserve(q);
    for (int i = 0; i < q; i++) {
        char type;
        int a, b;
        cin >> type >> a >> b;

        if (type == '?') {
            quers.emplace_back(1, a, b);
            allVals.push_back(a);
            allVals.push_back(b);
        } else {
            quers.emplace_back(2, a, b);
            allVals.push_back(b);
        }
    }

    compressIndexes();

    tree.resize(4 * allVals.size(), 0);
    build();

    for (const auto& quer : quers) {
        if (quer.type == 1) {
            int a = compressMap[quer.a];
            int b = compressMap[quer.b];
            cout << query(1, 0, allVals.size() - 1, a, b) << "\n";
        } else {
            int k = quer.a - 1;
            int x = quer.b;
            update(1, 0, allVals.size() - 1, compressMap[arr[k]], -1);
            arr[k] = x;
            update(1, 0, allVals.size() - 1, compressMap[x], 1);
        }
    }

    return 0;
}
