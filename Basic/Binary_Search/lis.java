import java.util.ArrayList;
import java.util.Scanner;

public class lis {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int pos = lowerBound(list, arr[i]);
            if (pos == list.size()) {
                list.add(arr[i]);
            } else {
                list.set(pos, arr[i]);
            }
        }

        System.out.println(list.size());
        in.close();
    }

    private static int lowerBound(ArrayList<Integer> list, int t) {
        int lo = 0;
        int hi = list.size() - 1;
        int ans = list.size();

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (check(list, mid, t) == 1) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private static int check(ArrayList<Integer> list, int mid, int t) {
        if (list.get(mid) >= t)
            return 1;
        return 0;
    }
}
