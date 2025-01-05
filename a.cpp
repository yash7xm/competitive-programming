#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int upperBound(const vector<int>& arr, int lo, int x) {
    int hi = arr.size() - 1;
    int ans = -1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] >= x) {
            hi = mid - 1;
            ans = mid;
        } else {
            lo = mid + 1;
        }
    }
    return ans;
}

int lowerBound(const vector<int>& arr, int lo, int x) {
    int hi = arr.size() - 1;
    int ans = -1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] <= x) {
            lo = mid + 1;
            ans = mid;
        } else {
            hi = mid - 1;
        }
    }
    return ans;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    while (t--) {
        int n, l, r;
        cin >> n >> l >> r;

        vector<int> arr(n);
        for (int i = 0; i < n; ++i) {
            cin >> arr[i];
        }

        sort(arr.begin(), arr.end());
        long long cnt = 0;

        for (int i = 0; i < n; ++i) {
            int left = upperBound(arr, i + 1, l - arr[i]);
            int right = lowerBound(arr, i + 1, r - arr[i]);

            if (left == -1 || right == -1) {
                continue;
            }

            if (left <= right) {
                cnt += right - left + 1;
            }
        }

        cout << cnt << '\n';
    }

    return 0;
}
