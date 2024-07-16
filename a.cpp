#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <algorithm>
#include <climits>

using namespace std;

struct Pair {
    int vtx;
    int wt;
    Pair(int vtx, int wt) : vtx(vtx), wt(wt) {}
};

void topSort(vector<int>& topsort, vector<vector<Pair>>& graph) {
    int n = graph.size();
    vector<int> indeg(n, 0);

    for (int i = 1; i < n; i++) {
        for (const Pair& nbr : graph[i]) {
            indeg[nbr.vtx]++;
        }
    }

    queue<int> q;
    for (int i = 1; i < n; i++) {
        if (indeg[i] == 0) {
            q.push(i);
        }
    }

    while (!q.empty()) {
        int u = q.front();
        q.pop();

        topsort.push_back(u);

        for (const Pair& nbr : graph[u]) {
            indeg[nbr.vtx]--;
            if (indeg[nbr.vtx] == 0) {
                q.push(nbr.vtx);
            }
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    vector<vector<Pair>> graph(n + 1);
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        int wt = -1;
        graph[u].emplace_back(v, wt);
    }

    vector<int> topsort;
    topSort(topsort, graph);

    vector<int> dist(n + 1, INT_MAX);
    vector<int> parent(n + 1, -1);
    dist[1] = 0;

    for (int u : topsort) {
        if (dist[u] != INT_MAX) {
            for (const Pair& nbr : graph[u]) {
                int newdist = dist[u] + nbr.wt;
                if (newdist < dist[nbr.vtx]) {
                    dist[nbr.vtx] = newdist;
                    parent[nbr.vtx] = u;
                }
            }
        }
    }

    if (dist[n] == INT_MAX) {
        cout << "IMPOSSIBLE" << endl;
    } else {
        vector<int> res;
        for (int i = n; i != 1; i = parent[i]) {
            res.push_back(i);
        }
        res.push_back(1);

        cout << res.size() << endl;
        for (int i = res.size() - 1; i >= 0; i--) {
            cout << res[i] << " ";
        }
        cout << endl;
    }

    return 0;
}
