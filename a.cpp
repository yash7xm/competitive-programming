#include <bits/stdc++.h>
using namespace std;

struct Query {
    int l, r, idx, block;

    Query(int _l, int _r, int _idx, int blockSize) {
        l = _l;
        r = _r;
        idx = _idx;
        block = l / blockSize;
    }

    bool operator<(const Query& other) const {
        if (block != other.block)
            return block < other.block;
        return (block % 2 == 0) ? r < other.r : r > other.r;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;
    vector<int> arr(n);
    for (int i = 0; i < n; i++) cin >> arr[i];

    int blockSize = sqrt(n) + 1;
    vector<Query> queries;
    for (int i = 0; i < q; i++) {
        int l, r;
        cin >> l >> r;
        queries.emplace_back(l - 1, r - 1, i, blockSize);
    }

    sort(queries.begin(), queries.end());

    unordered_map<int, int> freq;
    vector<int> answer(q);
    int currL = 0, currR = -1, distinct = 0;

    for (auto& qu : queries) {
        while (currL > qu.l) {
            currL--;
            freq[arr[currL]]++;
            if (freq[arr[currL]] == 1) distinct++;
        }

        while (currR < qu.r) {
            currR++;
            freq[arr[currR]]++;
            if (freq[arr[currR]] == 1) distinct++;
        }

        while (currL < qu.l) {
            freq[arr[currL]]--;
            if (freq[arr[currL]] == 0) distinct--;
            currL++;
        }

        while (currR > qu.r) {
            freq[arr[currR]]--;
            if (freq[arr[currR]] == 0) distinct--;
            currR--;
        }

        answer[qu.idx] = distinct;
    }

    for (int ans : answer)
        cout << ans << '\n';

    return 0;
}
