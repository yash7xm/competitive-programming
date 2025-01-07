package Bit_Manipulation;

import java.util.Scanner;

public class ManyFormulas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        int n = s.length() - 1;
        int N = s.length();
        long res = 0;
        for (int i = 0; i < (1 << n); i++) {
            long sum = 0;
            int end = N;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    int start = N - j - 1;
                    String sub = s.substring(start, end);
                    end = start;
                    sum += Long.parseLong(sub);
                }
            }
            String sub = s.substring(0, end);
            sum += Long.parseLong(sub);
            res += sum;
        }

        System.out.println(res);
        in.close();
    }
}
