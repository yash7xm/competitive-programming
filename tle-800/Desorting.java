import java.util.Scanner;

public class Desorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            if (sorted(arr)) {
                int min = Integer.MAX_VALUE;
                for (int i = 1; i < n; i++) {
                    min = Math.min(arr[i] - arr[i - 1], min);
                }
                min = min / 2 + 1;
                System.out.println(min);
            } else {
                System.out.println(0);
            }
        }
        in.close();
    }

    public static boolean sorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }
}
