#include <bits/stdc++.h>
using namespace std;

struct Queries {
    int type, a, b;
    Queries(int type, int a, int b) : type(type), a(a), b(b) {}
};

vector<int> arr, farr;
vector<int> allVals;
vector<Queries> quers;
map<int, int> compressMap;

void compressIndexes() {
    sort(allVals.begin(), allVals.end());
    int idx = 1;

    for (int val : allVals) {
        if (compressMap.find(val) == compressMap.end()) {
            compressMap[val] = idx++;
        }
    }
}

void build() {
    for (int i = 1; i < arr.size(); ++i) {
        int j = compressMap[arr[i]];
        int idx = j;
        while (idx < farr.size()) {
            farr[idx] += 1;
            idx += (idx & -idx);
        }
    }
}

void update(int i, int x) {
    while (i < farr.size()) {
        farr[i] += x;
        i += (i & -i);
    }
}

int query(int x) {
    int cnt = 0;
    while (x > 0) {
        cnt += farr[x];
        x -= (x & -x);
    }
    return cnt;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    arr.resize(n + 1);

    allVals.reserve(n + 2 * q);
    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
        allVals.push_back(arr[i]);
    }

    quers.reserve(q);
    for (int i = 0; i < q; i++) {
        string type;
        int a, b;
        cin >> type >> a >> b;

        if (type == "?") {
            quers.emplace_back(1, a, b);
            allVals.push_back(a);
            allVals.push_back(b);
        } else {
            quers.emplace_back(2, a, b);
            allVals.push_back(b);
        }
    }

    compressIndexes();
    farr.resize(compressMap.size() + 1, 0);
    build();

    for (const auto& quer : quers) {
        if (quer.type == 1) {
            int a = compressMap[quer.a];
            int b = compressMap[quer.b];
            cout << query(b) - query(a - 1) << "\n";
        } else {
            int k = quer.a;
            int x = quer.b;

            update(compressMap[arr[k]], -1);
            arr[k] = x;
            update(compressMap[x], 1);
        }
    }

    return 0;
}
