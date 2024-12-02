package AdventOfCode;

import java.util.Scanner;

public class day2part2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) {
                String[] arr = line.split("\\s+");
                int[] temp = new int[arr.length - 1];
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0, k = 0; j < arr.length; j++) {
                        if (i == j) {
                            continue;
                        }
                        temp[k] = Integer.parseInt(arr[j]);
                        k++;
                    }
                    if (check(temp) > 0) {
                        cnt++;
                        break;
                    }
                }
            } else {
                break;
            }
        }

        System.out.println(cnt);
        sc.close();
    }

    public static int check(int[] arr) {
        int n = arr.length;
        int inc = 1, dec = 1;
        for (int i = 0; i < n - 1; i++) {
            int a = (arr[i]);
            int b = (arr[i + 1]);
            if (a < b && b - a <= 3) {
                inc++;
            }
            if (a > b && a - b <= 3) {
                dec++;
            }
        }
        if (inc == n || dec == n) {
            return 1;
        }
        return 0;
    }
}
