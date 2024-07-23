#include <bits/stdc++.h>
using namespace std;

vector<int> arr, sqrtBlocks;
int len;

int query(int a, int b)
{
    int minVal = INT_MAX;

    while (a <= b)
    {
        if (a % len == 0 && a + len - 1 <= b)
        {
            minVal = min(sqrtBlocks[a / len], minVal);
            a += len;
        }
        else
        {
            minVal = min(arr[a], minVal);
            a++;
        }
    }

    return minVal;
}

void update(int k, int val)
{
    int i = (k / len) * len;
    arr[k] = val;
    sqrtBlocks[i / len] = INT_MAX;
    for (int j = 0; j < len && i < arr.size(); j++, i++)
    {
        sqrtBlocks[i / len] = min(sqrtBlocks[i / len], arr[i]);
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    arr.resize(n + 1);
    len = ceil(sqrt(n));
    sqrtBlocks.assign(len, INT_MAX);
    for (int i = 1; i <= n; i++)
    {
        cin >> arr[i];
        sqrtBlocks[i / len] = min(sqrtBlocks[i / len], arr[i]);
    }

    for (int i = 0; i < q; i++)
    {
        int type, a, b;
        cin >> type >> a >> b;

        if (type == 1)
        {
            update(a, b);
        }
        else
        {
            cout << query(a, b) << "\n";
        }
    }

    return 0;
}
