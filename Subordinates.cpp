#include <bits/stdc++.h>
using namespace std;

#define fastio() ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr)
#define pb push_back
#define all(x) (x).begin(), (x).end()
#define ff first
#define ss second
#define sz(x) int((x).size())

typedef long long ll;
typedef vector<int> vi;
typedef pair<int, int> pii;

vector<vi> graph;

int dfs(int root, vi &res) {
	if(graph[root].size() == 0) {
		res[root] = 0;
		return 1;
	}

	int childs = 0;
	for(int nbr : graph[root]) {
		childs += dfs(nbr, res);
	}

	res[root] = childs;
	return childs + 1;
}	

int main() {
    fastio();
    int n;
    cin >> n;

    graph.resize(n+1);

    for(int i=2; i<=n; i++) {
    	int u, v;
    	cin >> u;
    	v = i;

    	graph[u].pb(v);
    }

    vi res(n+1, 0);

    dfs(1, res);

    for(int i=1; i<=n; i++) {
    	cout << res[i] << " ";
    }
    return 0;
}