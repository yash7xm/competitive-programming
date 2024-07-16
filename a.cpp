#include <iostream>
#include <vector>
#include <stack>

using namespace std;

vector<vector<int>> graph;
vector<bool> vis;
vector<bool> isPresent;
stack<int> st;

bool dfs(int u) {
    vis[u] = true;
    st.push(u);
    isPresent[u] = true;

    for (int v : graph[u]) {
        if (!vis[v]) {
            if (dfs(v))
                return true;
        }

        if (isPresent[v]) {
            st.push(v);
            return true;
        }
    }

    st.pop();
    isPresent[u] = false;
    return false;
}

int main() {
    int n, m;
    cin >> n >> m;

    graph.resize(n + 1);
    vis.resize(n + 1, false);
    isPresent.resize(n + 1, false);

    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
    }

    for (int u = 1; u <= n; u++) {
        if (!vis[u]) {
            if (dfs(u))
                break;
        }
    }

    if (st.empty()) {
        cout << "IMPOSSIBLE" << endl;
    } else {
        int s = st.top();
        st.pop();
        vector<int> res;
        res.push_back(s);
        while (st.top() != s) {
            res.push_back(st.top());
            st.pop();
        }
        res.push_back(s);

        cout << res.size() << endl;

        for (int i = res.size() - 1; i >= 0; i--) {
            cout << res[i] << " ";
        }
        cout << endl;
    }

    return 0;
}
