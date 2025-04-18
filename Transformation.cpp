#include <bits/stdc++.h>
using namespace std;

#define fastio() ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr)
#define pb push_back
#define sz(x) int((x).size())

typedef long long ll;
typedef vector<ll> vll;

vll res;
bool found = false;

void dfs(ll a, ll b) {
    res.pb(a);
    
    if (a == b) {
        found = true;
        return;
    }

    if (a > b) {
        res.pop_back();
        return;
    }

    dfs(a * 2, b);
    if (!found) dfs(a * 10 + 1, b);

    if (!found) res.pop_back();
}

int main() {
    fastio();
    ll a, b;
    cin >> a >> b;

    dfs(a, b);

    if (!found) {
        cout << "NO\n";
    } else {
        cout << "YES\n";
        cout << sz(res) << "\n";
        for (ll x : res) cout << x << " ";
        cout << "\n";
    }

    return 0;
}
