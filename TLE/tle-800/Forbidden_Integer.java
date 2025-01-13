import java.util.Scanner;

public class Forbidden_Integer{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int x = scanner.nextInt();

            if (x != 1) {
                System.out.println("YES");
                System.out.println(n);
                for (int j = 0; j < n; j++) {
                    System.out.print(1 + " ");
                }
                System.out.println();
            } else if (k == 1 || (k == 2 && n % 2 == 1)) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                System.out.println(n / 2);
                int element = n % 2 == 1 ? 3 : 2;
                System.out.print(element + " ");
                for (int j = 0; j < n / 2 - 1; j++) {
                    System.out.print(2 + " ");
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}
