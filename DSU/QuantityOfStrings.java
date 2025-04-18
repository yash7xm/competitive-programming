import java.io.*;
import java.util.*;

public class QuantityOfStrings {
    static final int MOD = 1000000007;
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            parent[px] = py;
        }
    }

    static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) != 0) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int start = 0; start <= n - k; start++) {
            for (int i = 0; i < k / 2; i++) {
                int a = start + i;
                int b = start + k - i - 1;
                union(a, b);
            }
        }

        Set<Integer> uniqueRoots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            uniqueRoots.add(find(i));
        }

        int components = uniqueRoots.size();
        System.out.println(modPow(m, components, MOD));
    }
}
