import java.util.HashMap;
import java.util.Scanner;

public class Good_Prefixes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            long sum = arr[0];
            int max = arr[0];

            int res = 0;

            HashMap<Integer, Long> map = new HashMap<>();

            if (arr[0] == 0)
                res++;
            map.put(arr[0], sum);

            for (int i = 1; i < n; i++) {
                sum += arr[i];
                max = Math.max(arr[i], max);

                if (sum - max == max) {
                    res++;
                }
            }

            System.out.println(res);
        }
        in.close();
    }
}
