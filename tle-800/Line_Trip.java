import java.util.Scanner;

public class Line_Trip {

    public static int calculateMaxDis(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > max) {
                max = arr[i] - arr[i - 1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int firstGasDis = arr[0];
            int lastGasDis = 2 * (x - arr[n - 1]);

            int maxDisBwGas = calculateMaxDis(arr);

            int res = Math.max(firstGasDis, Math.max(lastGasDis, maxDisBwGas));

            System.out.println(res);
        }
        in.close();
    }
}
