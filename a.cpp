#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

class Pair
{
public:
    int vtx;
    long long wt;
    bool c;

    Pair(int vtx, long long wt, bool c) : vtx(vtx), wt(wt), c(c) {}

    bool operator>(const Pair &other) const
    {
        return this->wt > other.wt;
    }
};

vector<vector<Pair>> graph;

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
        graph[u].emplace_back(v, wt, false);
    }

    priority_queue<Pair, vector<Pair>, greater<Pair>> pq;
    pq.emplace(1, 0, false);

    vector<vector<long long>> path(n + 1, vector<long long>(2, LLONG_MAX));
    path[1][0] = 0;

    while (!pq.empty())
    {
        Pair rem = pq.top();
        pq.pop();

        if (rem.wt > path[rem.vtx][rem.c ? 1 : 0])
        {
            continue;
        }

        for (const Pair &nbr : graph[rem.vtx])
        {
            if (!rem.c)
            {
                long long newWt = rem.wt + nbr.wt;
                if (path[nbr.vtx][0] > newWt)
                {
                    path[nbr.vtx][0] = newWt;
                    pq.emplace(nbr.vtx, newWt, false);
                }

                long long disWt = rem.wt + nbr.wt / 2;
                if (path[nbr.vtx][1] > disWt)
                {
                    path[nbr.vtx][1] = disWt;
                    pq.emplace(nbr.vtx, disWt, true);
                }
            }
            else
            {
                long long newWt = rem.wt + nbr.wt;
                if (path[nbr.vtx][1] > newWt)
                {
                    path[nbr.vtx][1] = newWt;
                    pq.emplace(nbr.vtx, newWt, true);
                }
            }
        }
    }

    long long res = min(path[n][0], path[n][1]);
    cout << res << endl;

    return 0;
}
