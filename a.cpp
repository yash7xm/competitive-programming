#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

struct Pair
{
    int i, j;
    Pair(int i, int j) : i(i), j(j) {}
};

Pair start(0, 0);
Pair exitPoint(0, 0);
queue<Pair> mq;
vector<vector<Pair>> parent;

void monsterBFS(vector<vector<char>> &arr, vector<vector<int>> &vis)
{
    int dirs[4][2] = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    int lvl = 0;

    while (!mq.empty())
    {
        int n = mq.size();
        while (n-- > 0)
        {
            Pair rem = mq.front();
            mq.pop();

            if (vis[rem.i][rem.j] <= lvl)
            {
                continue;
            }

            vis[rem.i][rem.j] = lvl;

            for (int k = 0; k < 4; ++k)
            {
                int rowdash = rem.i + dirs[k][0];
                int coldash = rem.j + dirs[k][1];

                if (rowdash < 0 || coldash < 0 || rowdash >= arr.size() || coldash >= arr[0].size() || vis[rowdash][coldash] <= lvl + 1 || arr[rowdash][coldash] == '#')
                {
                    continue;
                }

                mq.push(Pair(rowdash, coldash));
            }
        }
        lvl++;
    }
}

bool bfs(vector<vector<char>> &arr, vector<vector<int>> &vis, vector<vector<bool>> &avis)
{
    queue<Pair> q;
    q.push(start);
    int lvl = 0;
    int dirs[4][2] = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    while (!q.empty())
    {
        int n = q.size();
        while (n-- > 0)
        {
            Pair rem = q.front();
            q.pop();

            if (avis[rem.i][rem.j])
            {
                continue;
            }

            avis[rem.i][rem.j] = true;

            if (rem.i == 0 || rem.i == arr.size() - 1 || rem.j == 0 || rem.j == arr[0].size() - 1)
            {
                exitPoint = rem;
                return true;
            }

            for (int k = 0; k < 4; ++k)
            {
                int rowdash = rem.i + dirs[k][0];
                int coldash = rem.j + dirs[k][1];

                if (rowdash < 0 || coldash < 0 || rowdash >= arr.size() || coldash >= arr[0].size() || arr[rowdash][coldash] != '.' || vis[rowdash][coldash] <= lvl + 1 || avis[rowdash][coldash])
                {
                    continue;
                }

                q.push(Pair(rowdash, coldash));
                parent[rowdash][coldash] = rem;
            }
        }
        lvl++;
    }

    return false;
}

int main()
{
    int n, m;
    cin >> n >> m;
    vector<vector<char>> arr(n, vector<char>(m));
    parent = vector<vector<Pair>>(n, vector<Pair>(m, Pair(-1, -1)));

    for (int i = 0; i < n; ++i)
    {
        string line;
        cin >> line;
        for (int j = 0; j < m; ++j)
        {
            arr[i][j] = line[j];
            if (arr[i][j] == 'A')
            {
                start = Pair(i, j);
            }
            if (arr[i][j] == 'M')
            {
                mq.push(Pair(i, j));
            }
        }
    }

    vector<vector<int>> vis(n, vector<int>(m, INT_MAX));
    monsterBFS(arr, vis);

    vector<vector<bool>> avis(n, vector<bool>(m, false));

    if (!bfs(arr, vis, avis))
    {
        cout << "NO" << endl;
    }
    else
    {
        cout << "YES" << endl;
        vector<char> ans;
        for (Pair rem = exitPoint; rem.i != -1 && rem.j != -1; rem = parent[rem.i][rem.j])
        {
            Pair par = parent[rem.i][rem.j];
            if (par.i == -1 && par.j == -1)
            {
                break;
            }
            if (rem.i + 1 == par.i && rem.j == par.j)
            {
                ans.push_back('U');
            }
            else if (rem.i == par.i && rem.j - 1 == par.j)
            {
                ans.push_back('R');
            }
            else if (rem.i - 1 == par.i && rem.j == par.j)
            {
                ans.push_back('D');
            }
            else if (rem.i == par.i && rem.j + 1 == par.j)
            {
                ans.push_back('L');
            }
        }

        cout << ans.size() << endl;
        for (int i = ans.size() - 1; i >= 0; --i)
        {
            cout << ans[i];
        }
        cout << endl;
    }

    return 0;
}
