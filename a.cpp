#include <iostream>
#include <vector>
#include <queue>
#include <climits>
#include <algorithm>

using namespace std;

struct Edge {
    int vtx;
    long long wt;
    Edge(int v, long long w) : vtx(v), wt(w) {}
    bool operator>(const Edge& other) const {
        return wt > other.wt;
    }
};

struct Node {
    long long min;
    int ways;
    int minc;
    int maxc;
    Node(long long m, int w, int minVtx, int maxVtx) : min(m), ways(w), minc(minVtx), maxc(maxVtx) {}
};

vector<vector<Edge>> graph;

int main() {
    int n, m;
    cin >> n >> m;

    graph.resize(n + 1);
    for (int i = 0; i < m; i++) {
        int u, v;
        long long wt;
        cin >> u >> v >> wt;
        graph[u].emplace_back(v, wt);
    }

    vector<Node> dp(n + 1, Node(LLONG_MAX, 0, INT_MAX, INT_MIN));
    dp[1] = Node(0, 1, 0, 0);
    int mod = 1000000007;

    priority_queue<Edge, vector<Edge>, greater<Edge>> pq;
    pq.emplace(1, 0);

    while (!pq.empty()) {
        Edge rem = pq.top();
        pq.pop();

        long long newDist = rem.wt;
        if (newDist > dp[rem.vtx].min)
            continue;

        for (Edge& nbr : graph[rem.vtx]) {
            newDist = rem.wt + nbr.wt;
            if (newDist < dp[nbr.vtx].min) {
                dp[nbr.vtx].min = newDist;
                dp[nbr.vtx].ways = dp[rem.vtx].ways;
                dp[nbr.vtx].minc = dp[rem.vtx].minc + 1;
                dp[nbr.vtx].maxc = dp[rem.vtx].maxc + 1;
                pq.emplace(nbr.vtx, newDist);
            } else if (newDist == dp[nbr.vtx].min) {
                dp[nbr.vtx].ways = (dp[nbr.vtx].ways + dp[rem.vtx].ways) % mod;
                dp[nbr.vtx].minc = min(dp[nbr.vtx].minc, dp[rem.vtx].minc + 1);
                dp[nbr.vtx].maxc = max(dp[nbr.vtx].maxc, dp[rem.vtx].maxc + 1);
            }
        }
    }

    cout << dp[n].min << " " << dp[n].ways << " " << dp[n].minc << " " << dp[n].maxc << endl;

    return 0;
}
