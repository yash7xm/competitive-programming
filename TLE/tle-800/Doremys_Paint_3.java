import java.util.Scanner;

public class Doremys_Paint_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int num1Count = 0;
            int num2Count = 0;

            int num1 = arr[0];
            int num2 = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i] == num1) {
                    num1Count++;
                } else {
                    if (arr[i] != num2) {
                        num2 = arr[i];
                        num2Count = 1;
                    } else {
                        num2Count++;
                    }
                }
            }

            if (num1Count == n) {
                System.out.println("Yes");
            } else {
                if (n % 2 == 0) {
                    if (num1Count == n / 2 && num2Count == n / 2) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                } else if (n % 2 == 1) {
                    if (num1Count == n / 2 && num2Count == (n / 2) + 1) {
                        System.out.println("Yes");
                    } else if (num2Count == n / 2 && num1Count == (n / 2) + 1) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                }
            }
        }
        in.close();
    }
}
