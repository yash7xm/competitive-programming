#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input street length and number of traffic lights
    int x, n;
    cin >> x >> n;

    vector<int> pos(n);
    for (int i = 0; i < n; i++) {
        cin >> pos[i];
    }

    // Ordered set to store the traffic light positions
    set<int> positions;
    positions.insert(0);
    positions.insert(x);

    // Map to store segment lengths and their counts
    map<int, int> segments;
    segments[x] = 1;

    vector<int> results;
    for (int i = 0; i < n; i++) {
        int p = pos[i];

        // Find neighboring lights
        auto it = positions.upper_bound(p);
        int right = *it;
        int left = *prev(it);

        // Remove the old segment
        int oldSeg = right - left;
        segments[oldSeg]--;
        if (segments[oldSeg] == 0) {
            segments.erase(oldSeg);
        }

        // Add the new segments
        int leftSeg = p - left;
        int rightSeg = right - p;
        segments[leftSeg]++;
        segments[rightSeg]++;

        // Add the new light position
        positions.insert(p);

        // The largest segment is the last key in the map
        results.push_back(segments.rbegin()->first);
    }

    // Output the results
    for (int res : results) {
        cout << res << " ";
    }
    cout << endl;

    return 0;
}
