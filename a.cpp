#include <bits/stdc++.h>
using namespace std;

struct Node {
    int time, index;
    bool arrival;

    Node(int t, int i, bool a) : time(t), index(i), arrival(a) {}

    // Comparator for sorting
    bool operator<(const Node& other) const {
        if (time == other.time) {
            return arrival > other.arrival; // Arrivals (true) come before departures (false)
        }
        return time < other.time; // Sort by time
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<Node> events;
    for (int i = 0; i < n; i++) {
        int l, r;
        cin >> l >> r;
        events.emplace_back(l, i, true);  // Arrival event
        events.emplace_back(r, i, false); // Departure event
    }

    // Sort events
    sort(events.begin(), events.end());

    int maxRoom = 1;
    priority_queue<int, vector<int>, greater<int>> pq; // Min-heap for available rooms
    pq.push(INT_MAX);

    vector<int> res(n);
    for (const auto& event : events) {
        if (event.arrival) {
            // Assign room to arrival
            res[event.index] = min(maxRoom, pq.top());
            if (pq.top() < maxRoom) {
                pq.pop();
            } else {
                maxRoom++;
            }
        } else {
            // Add room back to the pool on departure
            pq.push(res[event.index]);
        }
    }

    cout << maxRoom - 1 << "\n"; // Total rooms allocated
    for (int i = 0; i < n; i++) {
        cout << res[i] << " "; // Room assignments
    }
    cout << "\n";

    return 0;
}
