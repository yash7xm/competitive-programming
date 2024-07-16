#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <climits>

using namespace std;

struct Pair {
    int vtx;
    int wt;

    Pair(int vtx, int wt) {
        this->vtx = vtx;
        this->wt = wt;
    }

    bool operator<(const Pair& other) const {
        return wt < other.wt;
    }
};

int main() {
    int n, m;
    cin >> n >> m;

    vector<vector<Pair>> graph(n + 1);
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        int wt = 1;

        graph[u].emplace_back(v, wt);
    }

    priority_queue<Pair> pq;
    pq.emplace(1, 0);
    vector<int> path(n + 1, INT_MIN);
    vector<int> parent(n + 1, -1);
    path[1] = 0;

    while (!pq.empty()) {
        Pair rem = pq.top();
        pq.pop();

        if (rem.wt < path[rem.vtx])
            continue;

        path[rem.vtx] = rem.wt;

        for (Pair& nbr : graph[rem.vtx]) {
            if (path[nbr.vtx] < rem.wt + nbr.wt) {
                pq.emplace(nbr.vtx, rem.wt + nbr.wt);
                parent[nbr.vtx] = rem.vtx;
            }
        }
    }

    if (path[n] == INT_MIN) {
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
