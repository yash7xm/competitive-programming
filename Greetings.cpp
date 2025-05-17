#include <bits/stdc++.h>
using namespace std;

#define endl '\n'
#define pb push_back
#define all(x) x.begin(), x.end()
#define sz(x) (int)x.size()
#define fi first
#define se second
#define fastio() ios::sync_with_stdio(false); cin.tie(0)

int query(vector<int> &bit, int i) {
    int sum = 0;
    while (i > 0) {
        sum += bit[i];
        i -= i & -i;
    }
    return sum;
}

void update(vector<int> &bit, int i) {
    while (i < sz(bit)) {
        bit[i]++;
        i += i & -i;
    }
}

long long countInversions(vector<int> &nums) {
    vector<int> a = nums;
    sort(all(a));
    map<int, int> rank;
    for (int i = 0; i < sz(a); i++) {
        rank[a[i]] = i + 1;
    }

    vector<int> bit(sz(a) + 2, 0);
    long long res = 0;

    for (int i = sz(nums) - 1; i >= 0; i--) {
        int pos = rank[nums[i]];
        res += query(bit, pos - 1);
        update(bit, pos);
    }

    return res;
}

void solve() {
    int n;
    cin >> n;
    vector<pair<int, int>> v(n);
    for (int i = 0; i < n; i++) {
        cin >> v[i].fi >> v[i].se;
    }

    sort(all(v));

    vector<int> b;
    for (auto &p : v) {
        b.pb(p.se);
    }

    cout << countInversions(b) << endl;
}

int main() {
    fastio();
    int t;
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
