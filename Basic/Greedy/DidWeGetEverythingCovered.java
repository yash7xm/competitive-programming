package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class DidWeGetEverythingCovered {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            in.nextInt();
            String s = in.next();

            StringBuilder res = new StringBuilder();
            boolean[] found = new boolean[k];
            Arrays.fill(found, false);

            int count = 0;
            for (char c : s.toCharArray()) {
                if (res.length() == n) {
                    break;
                }
                if (!found[c - 'a']) {
                    count++;
                }
                found[c - 'a'] = true;

                if (count == k) {
                    Arrays.fill(found, false);
                    count = 0;
                    res.append(c);
                }
            }

            if (res.length() == n) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
                for (int i = 0; i < k; i++) {
                    if (!found[i]) {
                        while (res.length() < n) {
                            res.append((char) ('a' + i));
                        }
                    }
                }
                System.out.println(res.toString());
            }
        }

        in.close();
    }
}
