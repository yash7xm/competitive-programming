#include <bits/stdc++.h>
using namespace std;

struct Range {
    int start, end, index;
    bool operator<(const Range &o) const {
        if (start != o.start) {
            return start < o.start;
        }
        return end > o.end;
    }
};

class FenwickTree {
private:
    vector<int> tree;
public:
    FenwickTree(int size) {
        tree.resize(size + 1, 0);
    }

    void update(int idx) {
        while (idx < tree.size()) {
            tree[idx]++;
            idx += idx & -idx;
        }
    }

    int query(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= idx & -idx;
        }
        return sum;
    }
};

int compress(vector<int> &list, unordered_map<int, int> &map) {
    sort(list.begin(), list.end());
    int idx = 1;
    for (int val : list) {
        if (map.find(val) == map.end()) {
            map[val] = idx++;
        }
    }
    return idx;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;
    vector<Range> ranges(n);
    vector<int> ends;
    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        ranges[i] = {x, y, i};
        ends.push_back(y);
    }

    sort(ranges.begin(), ranges.end());

    unordered_map<int, int> map;
    int size = compress(ends, map);

    vector<int> contains(n, 0), contained(n, 0);
    FenwickTree fenwick(size);

    // Count how many ranges each range contains
    for (int i = n - 1; i >= 0; i--) {
        int idx = map[ranges[i].end];
        contains[ranges[i].index] = fenwick.query(idx);
        fenwick.update(idx);
    }

    fenwick = FenwickTree(size); // Reset Fenwick Tree

    // Count how many ranges each range is contained in
    for (int i = 0; i < n; i++) {
        int idx = map[ranges[i].end];
        contained[ranges[i].index] = fenwick.query(size) - fenwick.query(idx - 1);
        fenwick.update(idx);
    }

    for (int i = 0; i < n; i++) {
        cout << contains[i] << " ";
    }
    cout << "\n";
    for (int i = 0; i < n; i++) {
        cout << contained[i] << " ";
    }
    cout << "\n";

    return 0;
}
