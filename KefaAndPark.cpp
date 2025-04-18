#include <bits/stdc++.h>
using namespace std;

#define fastio() ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr)
#define pb push_back
#define sz(x) int((x).size())

typedef vector<int> vi;

vector<vi> tree;
vi isCat;
int res, n, m;

void dfs(int root, int cats, vi &vis) {
    vis[root] = 1;

    if (isCat[root]) cats++;
    else cats = 0;

    if (cats > m) return;

    bool isLeaf = true;
    for (int nbr : tree[root]) {
        if (!vis[nbr]) {
            isLeaf = false;
            dfs(nbr, cats, vis);
        }
    }

    if (isLeaf) res++;
}

int main() {
    fastio();

    cin >> n >> m;

    isCat.resize(n + 1);
    for (int i = 1; i <= n; i++) {
        cin >> isCat[i];
    }

    tree.resize(n + 1);
    vi vis(n + 1, 0);

    for (int i = 0; i < n - 1; i++) {
        int u, v;
        cin >> u >> v;
        tree[u].pb(v);
        tree[v].pb(u);
    }

    res = 0;
    dfs(1, 0, vis);

    cout << res << endl;

    return 0;
}
