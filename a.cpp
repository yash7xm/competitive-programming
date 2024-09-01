#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> tree;
vector<int> res;

int dfs(int u) {
    int sum = 0;
    for (int child : tree[u]) {
        sum += dfs(child) + 1;
    }
    res[u] = sum;
    return sum;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int n;
    cin >> n;

    tree.resize(n + 1);
    res.resize(n + 1);

    for (int i = 2; i <= n; i++) {
        int u;
        cin >> u;
        tree[u].push_back(i);
    }

    dfs(1);

    for (int i = 1; i <= n; i++) {
        cout << res[i] << " ";
    }
    cout << endl;

    return 0;
}
