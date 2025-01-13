import java.util.*;

public class Monsters {

    public static class Pair {
        int idx;
        int el;

        Pair(int idx, int el) {
            this.idx = idx;
            this.el = el;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] arr = new int[n];
            List<Pair> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                arr[i] = arr[i] % k;
                if (arr[i] == 0) {
                    arr[i] = k;
                }
                list.add(new Pair(i + 1, arr[i]));
            }

            list.sort((pair1, pair2) -> {
                if (pair1.el == pair2.el) {
                    return Integer.compare(pair1.idx, pair2.idx);
                } else {
                    return Integer.compare(pair2.el, pair1.el);
                }
            });

            for (Pair p : list) {
                System.out.print(p.idx + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
