#include <iostream>
#include <vector>
#include <queue>
#define MOD 1000000007

using namespace std;

vector<int> topsort;
vector<vector<int>> graph;

void topSort(int n) {
    vector<int> indeg(n + 1, 0);

    for (int u = 1; u <= n; u++) {
        for (int v : graph[u]) {
            indeg[v]++;
        }
    }

    queue<int> q;
    for (int i = 1; i <= n; i++) {
        if (indeg[i] == 0) {
            q.push(i);
        }
    }

    while (!q.empty()) {
        int u = q.front();
        q.pop();

        topsort.push_back(u);

        for (int v : graph[u]) {
            indeg[v]--;
            if (indeg[v] == 0) {
                q.push(v);
            }
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    graph.resize(n + 1);
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
    }

    topSort(n);

    vector<int> dp(n + 1, 0);
    for (int i = topsort.size() - 1; i >= 0; i--) {
        int idx = topsort[i];
        if (idx == n) {
            dp[idx] = 1;
        } else {
            for (int v : graph[idx]) {
                dp[idx] = (dp[idx] + dp[v]) % MOD;
            }
        }
    }

    cout << dp[1] << endl;

    return 0;
}
