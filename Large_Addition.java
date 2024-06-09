import java.util.Scanner;

public class Large_Addition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long x = in.nextLong();
            boolean flag = true;
            int carry = 0;
            long y = x;
            int firstDigit = 0;
            while (y > 0) {
                firstDigit = (int) (y % 10);
                y /= 10;
            }
            while (x > 0) {
                int lastDigit = (int) (x % 10);
                if (carry != 0) {
                    lastDigit--;
                    carry = 0;
                }
                if (lastDigit == 9 || lastDigit == -1) {
                    flag = false;
                    break;
                } else {
                    carry = -1;
                }

                x /= 10;
            }

            if (!flag || firstDigit != 1 || carry == 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
        in.close();
    }
}
