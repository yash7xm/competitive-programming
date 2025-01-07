package Bit_Manipulation;

import java.util.Scanner;

public class LittleElephantAndBits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = s.length();
        int idx = n - 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                idx = i;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != idx) {
                System.out.print(s.charAt(i));
            }
        }
        System.out.println();
        in.close();
    }
}
