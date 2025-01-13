import java.util.HashMap;
import java.util.Scanner;

public class Color_Balls {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        while (t-- > 0) {
            int n = in.nextInt();
            long k = in.nextLong();

            HashMap<Long, Long> map = new HashMap<>();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
                map.put(arr[i], map.getOrDefault(arr[i], 0L) + 1);
            }

            long lo = 0;
            long hi = n;
            long ans = lo;

            while (lo <= hi) {
                long mid = lo + (hi - lo) / 2;
                if (check(mid, k, map) == 1) {
                    ans = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            System.out.println(ans);
        }
        in.close();
    }

    private static int check(long mid, long k, HashMap<Long, Long> map) {
        long total = mid * k;
        long placed = 0;
        for (long key : map.keySet()) {
            placed += Math.min(map.get(key), mid);
        }
        return placed >= total ? 1 : 0;
    }
}