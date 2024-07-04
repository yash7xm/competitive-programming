package Number_Theory;

import java.util.Scanner;

public class gcd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        int res = gcd(a > b ? a : b, a < b ? a : b);
        System.out.println(res);
        in.close();
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
