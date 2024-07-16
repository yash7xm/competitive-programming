#include <iostream>
#include <vector>
#include <stack>
#include <climits>
#include <algorithm>

using namespace std;

struct Edge
{
    int vtx;
    long long wt;
    Edge(int v, long long w) : vtx(v), wt(w) {}
};

struct Node
{
    long long min;
    int numOfMin;
    int minVtxInMin;
    int maxVtxInMin;
    Node(long long m, int n, int minVtx, int maxVtx) : min(m), numOfMin(n), minVtxInMin(minVtx), maxVtxInMin(maxVtx) {}
};

vector<vector<Edge>> graph;
vector<int> topsort;

void dfs(int u, vector<bool> &vis, stack<int> &st)
{
    vis[u] = true;
    for (Edge &e : graph[u])
    {
        if (!vis[e.vtx])
        {
            dfs(e.vtx, vis, st);
        }
    }
    st.push(u);
}

void topologicalSort(int n)
{
    vector<bool> vis(n + 1, false);
    stack<int> st;

    for (int u = 1; u <= n; u++)
    {
        if (!vis[u])
        {
            dfs(u, vis, st);
        }
    }

    while (!st.empty())
    {
        topsort.push_back(st.top());
        st.pop();
    }
}

int main()
{
    int n, m;
    cin >> n >> m;

    graph.resize(n + 1);
    for (int i = 0; i < m; i++)
    {
        int u, v;
        long long wt;
        cin >> u >> v >> wt;
        graph[u].emplace_back(v, wt);
    }

    topologicalSort(n);

    vector<Node> dp(n + 1, Node(LLONG_MAX, 0, INT_MAX, INT_MIN));
    dp[1] = Node(0, 1, 0, 0);
    int mod = 1000000007;

    for (int idx : topsort)
    {
        if (dp[idx].min != LLONG_MAX)
        {
            for (Edge &nbr : graph[idx])
            {
                long long newDist = nbr.wt + dp[idx].min;
                if (newDist < dp[nbr.vtx].min)
                {
                    dp[nbr.vtx].min = newDist;
                    dp[nbr.vtx].numOfMin = dp[idx].numOfMin;
                    dp[nbr.vtx].minVtxInMin = dp[idx].minVtxInMin + 1;
                    dp[nbr.vtx].maxVtxInMin = dp[idx].maxVtxInMin + 1;
                }
                else if (newDist == dp[nbr.vtx].min)
                {
                    dp[nbr.vtx].numOfMin = (dp[nbr.vtx].numOfMin + dp[idx].numOfMin) % mod;
                    dp[nbr.vtx].minVtxInMin = min(dp[nbr.vtx].minVtxInMin, dp[idx].minVtxInMin + 1);
                    dp[nbr.vtx].maxVtxInMin = max(dp[nbr.vtx].maxVtxInMin, dp[idx].maxVtxInMin + 1);
                }
            }
        }
    }

    cout << dp[n].min << " " << dp[n].numOfMin << " " << dp[n].minVtxInMin << " " << dp[n].maxVtxInMin << endl;

    return 0;
}
