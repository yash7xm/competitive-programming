#include <bits/stdc++.h>
using namespace std;

vector<int> val, component, topSort;
vector<vector<int>> adj, adjRev, adjScc;
vector<long long> sccVal;
vector<bool> vis;
stack<int> st;

void dfs1(int u) {
    vis[u] = true;
    for (int v : adj[u]) {
        if (!vis[v]) {
            dfs1(v);
        }
    }
    st.push(u);
}

void dfs2(int u, int comp, long long &sum) {
    component[u] = comp;
    sum += val[u];
    for (int v : adjRev[u]) {
        if (component[v] == -1) {
            dfs2(v, comp, sum);
        }
    }
}

void build(int n, int comp) {
    adjScc.assign(comp, vector<int>());
    for (int u = 1; u <= n; u++) {
        for (int v : adj[u]) {
            if (component[u] != component[v]) {
                adjScc[component[u]].push_back(component[v]);
            }
        }
    }
}

void topologicalSort(int n) {
    vector<int> indeg(n, 0);
    for (int i = 0; i < n; i++) {
        for (int v : adjScc[i]) {
            indeg[v]++;
        }
    }

    queue<int> q;
    for (int i = 0; i < n; i++) {
        if (indeg[i] == 0) {
            q.push(i);
        }
    }

    while (!q.empty()) {
        int rem = q.front();
        q.pop();
        topSort.push_back(rem);
        for (int v : adjScc[rem]) {
            indeg[v]--;
            if (indeg[v] == 0) {
                q.push(v);
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    val.resize(n + 1);
    for (int i = 1; i <= n; i++) {
        cin >> val[i];
    }

    adj.assign(n + 1, vector<int>());
    adjRev.assign(n + 1, vector<int>());
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adjRev[v].push_back(u);
    }

    vis.assign(n + 1, false);
    for (int u = 1; u <= n; u++) {
        if (!vis[u]) {
            dfs1(u);
        }
    }

    component.assign(n + 1, -1);
    int comp = 0;
    sccVal.clear();
    while (!st.empty()) {
        int u = st.top();
        st.pop();
        if (component[u] == -1) {
            long long sum = 0;
            dfs2(u, comp++, sum);
            sccVal.push_back(sum);
        }
    }

    topSort.clear();
    build(n, comp);
    topologicalSort(comp);

    vector<long long> dp(comp, 0);
    for (int u : topSort) {
        dp[u] += sccVal[u];
        for (int v : adjScc[u]) {
            dp[v] = max(dp[v], dp[u]);
        }
    }

    long long maxCoins = *max_element(dp.begin(), dp.end());
    cout << maxCoins << '\n';

    return 0;
}
