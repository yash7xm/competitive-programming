import java.util.Arrays;
import java.util.Scanner;

public class StudyingAlgorithms {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        long sum = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] <= x) {
                sum += arr[i];
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(cnt);
        in.close();
    }
}
