import java.util.Scanner;
import java.util.Arrays;

public class X_Axis {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = in.nextInt();
            }

            Arrays.sort(arr);
            int a = 11;
            for (int i = arr[0]; i <= arr[2]; i++) {
                int temp = Math.abs(arr[0] - i) + Math.abs(arr[1] - i) + Math.abs(arr[2] - i);
                a = Math.min(a, temp);
            }

            System.out.println(a);
        }
        in.close();
    }
}
