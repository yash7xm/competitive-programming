#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<int> arr(n);
    vector<int> pos(n + 1); // Stores positions of each number (1-based indexing)

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        pos[arr[i]] = i; // Store the position of each number
    }

    // Calculate initial number of rounds
    int rounds = 1;
    for (int i = 2; i <= n; i++) {
        if (pos[i] < pos[i - 1]) {
            rounds++;
        }
    }

    while (m--) {
        int a, b;
        cin >> a >> b;
        a--; // Convert to 0-based index
        b--; // Convert to 0-based index

        // Identify affected elements
        set<int> affected;
        affected.insert(arr[a]);
        affected.insert(arr[b]);
        if (arr[a] > 1) affected.insert(arr[a] - 1);
        if (arr[a] < n) affected.insert(arr[a] + 1);
        if (arr[b] > 1) affected.insert(arr[b] - 1);
        if (arr[b] < n) affected.insert(arr[b] + 1);

        // Remove transitions affected by these elements
        for (int x : affected) {
            if (x > 1 && pos[x] < pos[x - 1]) {
                rounds--;
            }
        }

        // Perform the swap
        swap(arr[a], arr[b]);
        pos[arr[a]] = a;
        pos[arr[b]] = b;

        // Add transitions back
        for (int x : affected) {
            if (x > 1 && pos[x] < pos[x - 1]) {
                rounds++;
            }
        }

        // Output the number of rounds
        cout << rounds << "\n";
    }

    return 0;
}
