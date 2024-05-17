import java.util.HashMap;
import java.util.Scanner;

public class Array_Cloning_Technique {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            int maxFreq = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                maxFreq = Math.max(maxFreq, map.get(arr[i]));
            }

            int copy = 0;
            int swaps = 0;

            while (true) {
                if (arr.length - maxFreq <= maxFreq) {
                    if (arr.length - maxFreq > 0)
                        copy++;
                    swaps += arr.length - maxFreq;
                    break;
                }
                copy++;
                swaps += maxFreq;
                maxFreq *= 2;
            }

            System.out.println(copy + swaps);
        }
        in.close();
    }
}
