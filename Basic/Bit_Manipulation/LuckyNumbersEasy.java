package Bit_Manipulation;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class LuckyNumbersEasy {

    private static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();

        for (int i = 2; i <= 18; i += 2) {
            generate("", i / 2, i / 2);
        }

        Collections.sort(list);

        for (long num : list) {
            if (num >= n) {
                System.out.println(num);
                break;
            }
        }

        in.close();
    }

    static void generate(String curr, int count4, int count7) {
        if (count4 == 0 && count7 == 0) {
            list.add(Long.parseLong(curr));
            return;
        }

        if (count4 > 0) {
            generate(curr + "4", count4 - 1, count7);
        }

        if (count7 > 0) {
            generate(curr + "7", count4, count7 - 1);
        }
    }
}
