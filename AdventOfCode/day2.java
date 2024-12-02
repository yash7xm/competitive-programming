package AdventOfCode;

import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) {
                String[] arr = line.split("\\s+");
                int inc = 1, dec = 1;
                for (int i = 0; i < arr.length - 1; i++) {
                    int a = Integer.parseInt(arr[i]);
                    int b = Integer.parseInt(arr[i + 1]);
                    if (a < b && b - a <= 3) {
                        inc++;
                    }
                    if (a > b && a - b <= 3) {
                        dec++;
                    }
                    if (inc == arr.length || dec == arr.length) {
                        cnt++;
                    }
                }
            } else {
                break;
            }
        }

        System.out.println(cnt);
        sc.close();
    }
}
