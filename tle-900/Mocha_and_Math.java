import java.util.Scanner;

public class Mocha_and_Math {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int res = arr[0];
            for(int i=1; i<n; i++){
                res &= arr[i];
            }
            System.out.println(res);
        }
        in.close();
    }
}
