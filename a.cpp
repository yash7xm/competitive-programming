#include <iostream>
#include <vector>
#include <cmath>
#include <cstdio>
using namespace std;

int main() {
    int n, k;
    cin >> n >> k;

    vector<vector<int>> arr;

    int root = (int)sqrt(n);
    int row = 0, col = 0, count = 0;

    vector<int> vec;
    for (int i = 1; i <= n; i++) {
        if (count > root) {
            count = 0;
            arr.push_back(vec);
            vec.clear();
        }
        vec.push_back(i);
        count++;
    }

    if (!vec.empty()) {
        arr.push_back(vec);
    }

    for (int i = 0; i < n; i++) {
        int j = k % (n - i);
        while (j > 0) {
            if (col + j < arr[row].size()) {
                col += j;
                j = 0;
            } else {
                j -= arr[row].size() - col;
                col = 0;
                row++;
            }

            if (row >= arr.size()) {
                row = 0;
            }
        }

        while (arr[row].size() <= col) {
            col = 0;
            row++;
            if (row >= arr.size()) {
                row = 0;
            }
        }

        printf("%d ", arr[row][col]);
        if (i != n - 1) {
            arr[row].erase(arr[row].begin() + col);
            while (row < arr.size() && arr[row].size() <= col) {
                col = 0;
                row++;
                if (row >= arr.size()) {
                    row = 0;
                }
            }
        }
    }

    return 0;
}
