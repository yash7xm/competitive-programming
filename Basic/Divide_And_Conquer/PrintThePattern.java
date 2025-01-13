package Divide_And_Conquer;

import java.util.Scanner;

public class PrintThePattern {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(print(n));
        in.close();
    }

    static String print(int n) {
        if (n == 1) {
            return "A";
        }

        String previous = print(n - 1);
        return previous + (char) (n + 'A' - 1) + previous;
    }
}
