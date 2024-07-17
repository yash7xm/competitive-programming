#include <bits/stdc++.h>
using namespace std;

const int MAX = 30;
vector<vector<int>> table;

void build(vector<int> &p)
{
    int n = p.size();
    table.assign(MAX, vector<int>(n));

    for (int i = 0; i < n; i++)
    {
        table[0][i] = p[i];
    }

    for (int i = 1; i < MAX; i++)
    {
        for (int j = 0; j < n; j++)
        {
            table[i][j] = table[i - 1][table[i - 1][j]];
        }
    }
}

int query(int a, int k)
{
    for (int i = 0; i < MAX; i++)
    {
        if ((k & (1 << i)) != 0)
        {
            a = table[i][a];
        }
    }
    return a;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    vector<int> p(n);
    for (int i = 0; i < n; i++)
    {
        cin >> p[i];
        p[i]--;
    }

    build(p);

    for (int i = 0; i < q; i++)
    {
        int a, k;
        cin >> a >> k;
        a--;
        cout << query(a, k) + 1 << '\n';
    }

    return 0;
}
