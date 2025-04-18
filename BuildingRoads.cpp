#include <bits/stdc++.h>
using namespace std;

#define fastio() ios::sync_with_stdio(false); cin.tie(nullptr)
#define pb push_back
#define all(x) (x).begin(), (x).end()
#define ff first
#define ss second
#define sz(x) int((x).size())
#define endl "\n"

typedef long long ll;
typedef vector<int> vi;
typedef pair<int, int> pii;

vector<vi> graph;

void dfs(int u, vector<int> &vis) {
	stack<int> st;
	st.push(u);

	while (!st.empty()) {
		int rem = st.top();
		st.pop();

		if (vis[rem]) continue;
		vis[rem] = 1;

		for (int nbr : graph[rem]) {
			if (!vis[nbr]) {
				st.push(nbr);
			}
		}
	}
}

int main() {
    fastio();

    int n, m;
    cin >> n >> m;

    graph.resize(n + 1);
    for (int i = 0; i < m; i++) {
    	int u, v;
    	cin >> u >> v;
    	graph[u].pb(v);
    	graph[v].pb(u);
    }

    vector<int> vis(n + 1, 0);
    vi comps;

    for (int i = 1; i <= n; i++) {
    	if (!vis[i]) {
    		dfs(i, vis);
    		comps.pb(i);
    	}
    }

    cout << sz(comps) - 1 << endl;
    for (int i = 1; i < sz(comps); i++) {
    	cout << comps[0] << " " << comps[i] << endl;
    }

    return 0;
}
