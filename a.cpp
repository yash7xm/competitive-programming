#include <bits/stdc++.h>
using namespace std;

struct Trie {
    struct Node {
        Node* childs[26];
        bool isEnd;

        Node() {
            fill(begin(childs), end(childs), nullptr);
            isEnd = false;
        }
    };

    Node* root = new Node();

    void insert(const string& word) {
        Node* curr = root;
        for (char ch : word) {
            int idx = ch - 'a';
            if (curr->childs[idx] == nullptr)
                curr->childs[idx] = new Node();
            curr = curr->childs[idx];
        }
        curr->isEnd = true;
    }
};

vector<long long> dp;
Trie t;
string s;

long long countWays(int i) {
    if (i == s.size()) return 1;
    if (dp[i] != -1) return dp[i];

    Trie::Node* curr = t.root;
    long long ways = 0;

    for (int j = i; j < s.size(); ++j) {
        int idx = s[j] - 'a';
        if (curr->childs[idx] == nullptr) break;
        curr = curr->childs[idx];
        if (curr->isEnd) {
            ways += countWays(j + 1);
        }
    }

    return dp[i] = ways;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> s >> n;

    for (int i = 0; i < n; ++i) {
        string word;
        cin >> word;
        t.insert(word);
    }

    dp.assign(s.size(), -1);
    cout << countWays(0) << '\n';

    return 0;
}
