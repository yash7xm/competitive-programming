import java.util.Scanner;

public class Multiply_y_2_divide_by_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int count2 = 0, count3 = 0;
            while (n % 2 == 0) {
                count2++;
                n /= 2;
            }
            while (n % 3 == 0) {
                count3++;
                n /= 3;
            }
            if (n == 1 && count2 <= count3) {
                System.out.println(2 * count3 - count2);
            } else {
                System.out.println(-1);
            }
        }
        in.close();
    }
}