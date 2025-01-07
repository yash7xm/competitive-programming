package Bit_Manipulation;

import java.util.Scanner;

public class MaximizingXOR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();

        int xor = l ^ r;
        int msb = 0;
        while (xor > 0) {
            msb++;
            xor >>= 1;
        }

        int res = (1 << msb) - 1;

        System.out.println(res);
        in.close();
    }
}
