import java.util.Scanner;

public class Raspberries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] arr = new int[n];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                if (k != 4) {
                    for (int j = 0; j <= k; j++) {
                        if ((arr[i] + j) % k == 0) {
                            min = Math.min(min, j);
                            break;
                        }
                    }
                }
            }

            if (k == 4) {
                int twos = 0;
                int fours = 0;
                int eights = 0;
                int odds = 0;
                int evens = 0;
                for (int i = 0; i < n; i++) {
                    if (arr[i] % 2 == 0) {
                        evens++;
                    } else {
                        odds++;
                    }
                    if (arr[i] == 2)
                        twos++;
                    else if (arr[i] == 4)
                        fours++;
                    else if (arr[i] == 8)
                        eights++;
                }

                if(twos >=2 || fours >= 1 || eights >= 1) {
                    min = 0;
                } else {
                    if(evens >= 1 && odds >=1) min = 1;
                    else min = 2;
                }
            }

            System.out.println(min);
        }
        in.close();
    }
}
