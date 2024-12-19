#include <bits/stdc++.h>
using namespace std;

struct FastIO {
    FastIO() {
        ios::sync_with_stdio(false);
        cin.tie(nullptr);
        cout.tie(nullptr);
    }
};

int binarySearch(vector<pair<int, int>>& arr, int start, long long x) {
    int lo = start, hi = arr.size() - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (arr[mid].first == x) {
            return mid;
        } else if (arr[mid].first > x) {
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return -1;
}

int main() {
    FastIO io;

    int n, x;
    cin >> n >> x;

    vector<pair<int, int>> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i].first;
        arr[i].second = i + 1;
    }

    sort(arr.begin(), arr.end());

    for (int i = 0; i < n - 3; i++) {
        int a = arr[i].first;
        for (int j = i + 1; j < n - 2; j++) {
            int b = arr[j].first;
            for (int k = j + 1; k < n - 1; k++) {
                int c = arr[k].first;
                long long d = x - (a + b + c);
                int l = binarySearch(arr, k + 1, d);
                if (l != -1) {
                    cout << arr[i].second << " " << arr[j].second << " " << arr[k].second << " " << arr[l].second << endl;
                    return 0;
                }
            }
        }
    }

    cout << "IMPOSSIBLE" << endl;
    return 0;
}
