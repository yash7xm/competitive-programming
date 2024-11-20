#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<pair<int, int>> events;

    // Read arrival and leaving times
    for (int i = 0; i < n; ++i) {
        int a, b;
        cin >> a >> b;
        events.push_back({a, 1});  // Arrival event (+1)
        events.push_back({b, -1}); // Departure event (-1)
    }

    // Sort events by time; if times are equal, process departures before arrivals
    sort(events.begin(), events.end(), [](pair<int, int> &x, pair<int, int> &y) {
        if (x.first == y.first)
            return x.second < y.second;
        return x.first < y.first;
    });

    // Sweep line to calculate maximum customers
    int current_customers = 0, max_customers = 0;
    for (auto &event : events) {
        current_customers += event.second;
        max_customers = max(max_customers, current_customers);
    }

    cout << max_customers << endl;
    return 0;
}
