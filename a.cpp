#include <iostream>
#include <vector>
#include <set>
#include <iterator>

using namespace std;

class SlidingWindowCost
{
private:
    multiset<int> low, high;             // low contains the smaller half, high contains the larger half
    long long low_sum = 0, high_sum = 0; // Sum of elements in low and high respectively

    void balance()
    {
        // Ensure size of low >= size of high
        while (low.size() > high.size() + 1)
        {
            int val = *low.rbegin();
            high.insert(val);
            high_sum += val;
            low_sum -= val;
            low.erase(prev(low.end()));
        }
        while (high.size() > low.size())
        {
            int val = *high.begin();
            low.insert(val);
            low_sum += val;
            high_sum -= val;
            high.erase(high.begin());
        }
    }

public:
    void insert(int x)
    {
        if (low.empty() || x <= *low.rbegin())
        {
            low.insert(x);
            low_sum += x;
        }
        else
        {
            high.insert(x);
            high_sum += x;
        }
        balance();
    }

    void erase(int x)
    {
        if (x <= *low.rbegin())
        {
            low.erase(low.find(x));
            low_sum -= x;
        }
        else
        {
            high.erase(high.find(x));
            high_sum -= x;
        }
        balance();
    }

    long long getCost()
    {
        int median = *low.rbegin();
        long long cost = (long long)median * low.size() - low_sum;
        cost += high_sum - (long long)median * high.size();
        return cost;
    }
};

int main()
{
    int n, k;
    cin >> n >> k;
    vector<int> arr(n);
    for (int i = 0; i < n; ++i)
    {
        cin >> arr[i];
    }

    SlidingWindowCost swc;
    vector<long long> costs;

    for (int i = 0; i < n; ++i)
    {
        swc.insert(arr[i]);
        if (i >= k - 1)
        {
            costs.push_back(swc.getCost());
            swc.erase(arr[i - k + 1]);
        }
    }

    for (long long cost : costs)
    {
        cout << cost << " ";
    }
    cout << endl;

    return 0;
}
