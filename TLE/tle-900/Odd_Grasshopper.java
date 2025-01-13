import java.util.Scanner;

public class Odd_Grasshopper {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            long x = in.nextLong();
            long n = in.nextLong();

            long[] arr = new long[4];
            arr[0] = 0;
            arr[1] = -n;
            arr[2] = 1;
            arr[3] = n + 1;

            long d = arr[(int) (n % 4)];
            if (x % 2 == 0) {
                System.out.println(x + d);
            } else {
                System.out.println(x - d);
            }
        }
        in.close();
    }
}
