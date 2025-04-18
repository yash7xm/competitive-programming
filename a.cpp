#include <iostream>
#include <vector>
using namespace std;

const int N = 2e5 + 5;

int parent[N], size[N];
long long add[N], exp[N];

// Find function with path compression
int find(int x) {
    if (x != parent[x]) {
        int par = parent[x];
        parent[x] = find(parent[x]);
        exp[x] += add[par] - add[parent[x]];  // Add delta
    }
    return parent[x];
}

// Union by size
void join(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y) return;
    if (size[x] < size[y]) swap(x, y);
    parent[y] = x;
    exp[y] += add[y] - add[x];  // Convert exp to parent base
    size[x] += size[y];
}

// Add experience to the whole team
void addExp(int x, int v) {
    x = find(x);
    add[x] += v;
}

// Get experience of a player
long long getExp(int x) {
    find(x);  // Path compress and update exp[x]
    return exp[x] + add[parent[x]];
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    // Initialize
    for (int i = 1; i <= n; ++i) {
        parent[i] = i;
        size[i] = 1;
        exp[i] = 0;
        add[i] = 0;
    }

    while (m--) {
        string cmd;
        int x, y;
        cin >> cmd;

        if (cmd == "join") {
            cin >> x >> y;
            join(x, y);
        } else if (cmd == "add") {
            int v;
            cin >> x >> v;
            addExp(x, v);
        } else if (cmd == "get") {
            cin >> x;
            cout << getExp(x) << '\n';
        }
    }

    return 0;
}
