import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Sofia_and_the_Lost_Operations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
                set.add(b[i]);
            }
            int m = in.nextInt();
            int[] d = new int[m];
            for (int i = 0; i < m; i++) {
                d[i] = in.nextInt();
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (a[i] != b[i]) {
                    map.put(b[i], map.getOrDefault(b[i], 0) + 1);
                }
            }

            boolean flag = false;
            boolean res = true;
            for (int i = m - 1; i >= 0; i--) {
                if (!flag && !set.contains(d[i])) {
                    res = false;
                    break;
                } else if (set.contains(d[i])) {
                    flag = true;
                }

                if (map.containsKey(d[i])) {
                    map.put(d[i], map.get(d[i]) - 1);
                    if (map.get(d[i]) == 0) {
                        map.remove(d[i]);
                    }
                }
            }

            if (res == false) {
                System.out.println("NO");
            } else {
                if (map.size() == 0)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
        in.close();
    }
}
