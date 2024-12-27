#include <iostream>
#include <vector>
#include <set>

using namespace std;

class SlidingWindowMedian {
private:
    multiset<int> low, high; // low contains the smaller half, high contains the larger half

    void balance() {
        // Ensure size of low >= size of high
        while (low.size() > high.size() + 1) {
            high.insert(*low.rbegin());
            low.erase(prev(low.end()));
        }
        while (high.size() > low.size()) {
            low.insert(*high.begin());
            high.erase(high.begin());
        }
    }

public:
    void insert(int x) {
        if (low.empty() || x <= *low.rbegin()) {
            low.insert(x);
        } else {
            high.insert(x);
        }
        balance();
    }

    void erase(int x) {
        if (x <= *low.rbegin()) {
            low.erase(low.find(x));
        } else {
            high.erase(high.find(x));
        }
        balance();
    }

    int getMedian() {
        return *low.rbegin(); // Median is the largest element in low
    }
};

int main() {
    int n, k;
    cin >> n >> k;
    vector<int> arr(n);
    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    SlidingWindowMedian swm;
    vector<int> medians;

    for (int i = 0; i < n; ++i) {
        swm.insert(arr[i]);
        if (i >= k - 1) {
            medians.push_back(swm.getMedian());
            swm.erase(arr[i - k + 1]);
        }
    }

    for (int median : medians) {
        cout << median << " ";
    }
    cout << endl;

    return 0;
}
