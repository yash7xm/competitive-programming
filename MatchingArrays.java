import java.util.*;

public class MatchingArrays {
    static final int INF = 1000000005;
    static final int MAXN = 200005;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(); 
            int x = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            Integer[] aid = new Integer[n];
            int[] ans = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                aid[i] = i;
            }

            Arrays.sort(aid, (l, r) -> Integer.compare(a[l], a[r]));

            Arrays.sort(b);

            for (int i = 0; i < x; i++) {
                ans[aid[n - x + i]] = b[i];
            }

            for (int i = x; i < n; i++) {
                ans[aid[i - x]] = b[i];
            }

            for (int i = 0; i < n; i++) {
                if (a[i] > ans[i]) {
                    x--;
                }
            }

            if (x == 0) {
                System.out.println("YES");
                for (int i = 0; i < n; i++) {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
