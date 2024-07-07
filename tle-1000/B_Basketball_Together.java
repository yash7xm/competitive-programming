import java.util.Arrays;
import java.util.Scanner;

public class B_Basketball_Together {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int D = in.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        int playersUsed = 0;
        int res = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int playersNeeded = D / arr[i];
            playersNeeded++;
            if (playersUsed + playersNeeded > arr.length) {
                break;
            }
            playersUsed += playersNeeded;
            res++;
        }

        System.out.println(res);
        in.close();
    }
}
