import java.util.HashMap;
import java.util.Scanner;

public class SegmentsWithSmallSet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        long res = 0;
        for (int i = 0, j = 0; j < n; j++) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            while (map.size() > k) {
                if (map.get(arr[i]) == 1) {
                    map.remove(arr[i]);
                } else {
                    map.put(arr[i], map.get(arr[i]) - 1);
                }
                i++;
            }

            res += j - i + 1;
        }

        System.out.println(res);
        in.close();
    }
}
