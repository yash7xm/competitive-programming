#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    vector<int> arr(n + 1);
    for (int i = 1; i <= n; ++i) {
        cin >> arr[i];
    }

    int len = ceil(sqrt(n));
    vector<int> sqrt(len, INT_MAX);

    for (int i = 1; i <= n; ++i) {
        sqrt[i / len] = min(sqrt[i / len], arr[i]);
    }

    for (int i = 0; i < q; ++i) {
        int a, b;
        cin >> a >> b;

        int minimum = INT_MAX;
        while (a <= b) {
            if (a % len == 0 && a + len - 1 <= b) {
                minimum = min(minimum, sqrt[a / len]);
                a += len;
            } else {
                minimum = min(minimum, arr[a]);
                ++a;
            }
        }

        cout << minimum << "\n";
    }

    return 0;
}
