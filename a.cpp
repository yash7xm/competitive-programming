#include <iostream>
#include <map>
#include <vector>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    vector<int> tickets(n);
    vector<int> customers(m);

    // Read ticket prices
    for (int i = 0; i < n; ++i) {
        cin >> tickets[i];
    }

    // Read customers' maximum prices
    for (int i = 0; i < m; ++i) {
        cin >> customers[i];
    }

    // Use map to store ticket prices and their counts
    map<int, int> ticketMap;
    for (int price : tickets) {
        ticketMap[price]++;
    }

    // Process each customer's request
    for (int maxPrice : customers) {
        // Find the largest ticket price <= maxPrice
        auto it = ticketMap.upper_bound(maxPrice);
        if (it == ticketMap.begin()) {
            // No suitable ticket found
            cout << -1 << endl;
        } else {
            --it; // Move to the largest valid ticket
            cout << it->first << endl;

            // Decrease the count or remove the ticket
            if (--(it->second) == 0) {
                ticketMap.erase(it);
            }
        }
    }

    return 0;
}
