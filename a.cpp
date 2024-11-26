#include <bits/stdc++.h>
using namespace std;

struct Range {
    int start, end, index;

    // Constructor
    Range(int s, int e, int i) : start(s), end(e), index(i) {}

    // Custom comparator for sorting
    bool operator<(const Range &other) const {
        if (start != other.start) {
            return start < other.start;
        }
        return end > other.end; // Sort by end descending if starts are equal
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;

    vector<Range> ranges;
    for (int i = 0; i < n; ++i) {
        int start, end;
        cin >> start >> end;
        ranges.emplace_back(start, end, i);
    }

    // Sort ranges by start, and by end descending if starts are equal
    sort(ranges.begin(), ranges.end());

    // Arrays to store results for "contains" and "contained"
    vector<int> contains(n, 0), contained(n, 0);

    // Determine the "contains" relationship
    int minEnd = INT_MAX; // Tracks the smallest end from right to left
    for (int i = n - 1; i >= 0; --i) {
        if (ranges[i].end >= minEnd) {
            contains[ranges[i].index] = 1;
        }
        minEnd = min(minEnd, ranges[i].end);
    }

    // Determine the "contained" relationship
    int maxEnd = INT_MIN; // Tracks the largest end from left to right
    for (int i = 0; i < n; ++i) {
        if (ranges[i].end <= maxEnd) {
            contained[ranges[i].index] = 1;
        }
        maxEnd = max(maxEnd, ranges[i].end);
    }

    // Print results for "contains"
    for (int i = 0; i < n; ++i) {
        cout << contains[i] << " ";
    }
    cout << "\n";

    // Print results for "contained"
    for (int i = 0; i < n; ++i) {
        cout << contained[i] << " ";
    }
    cout << "\n";

    return 0;
}
