#include <bits/stdc++.h>
using namespace std;

vector<int> arr;
vector<long long> blockSums;
int len;

void build(int n) {
    blockSums.assign(len, 0);
    for (int i = 1; i <= n; ++i) {
        blockSums[i / len] += arr[i];
    }
}

void update(int k, int delta) {
    blockSums[k / len] = blockSums[k / len] - arr[k] + delta;
    arr[k] = delta;
}

long long query(int a, int b) {
    long long sum = 0;
    while (a <= b) {
        if (a % len == 0 && a + len - 1 <= b) {
            sum += blockSums[a / len];
            a += len;
        } else {
            sum += arr[a];
            ++a;
        }
    }
    return sum;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    arr.resize(n + 1);
    for (int i = 1; i <= n; ++i) {
        cin >> arr[i];
    }

    len = ceil(sqrt(n));
    build(n);

    for (int i = 0; i < q; ++i) {
        int type, a, b;
        cin >> type >> a >> b;

        if (type == 1) {
            update(a, b);
        } else {
            cout << query(a, b) << "\n";
        }
    }

    return 0;
}
