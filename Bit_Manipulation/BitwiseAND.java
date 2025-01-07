package Bit_Manipulation;

import java.util.Scanner;

public class BitwiseAND {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            int res = 0;

            if (((k - 1) | k) <= n) {
                res = k - 1;
            } else {
                res = k - 2;
            }

            System.out.println(res);
        }
        in.close();
    }
}
