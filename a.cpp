#include <iostream>
#include <queue>

using namespace std;

int main() {
    int n;
    cin >> n;

    queue<int> q;
    for (int i = 1; i <= n; i++) {
        q.push(i);
    }

    bool flag = false;
    while (!q.empty()) {
        int el = q.front();
        q.pop();
        if (flag) {
            cout << el << " ";
        } else {
            q.push(el);
        }
        flag = !flag; // Toggle the flag
    }

    return 0;
}
