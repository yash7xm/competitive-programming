import java.util.Scanner;

public class Dont_Try_to_Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); 

        for (int t = 0; t < testCases; t++) {
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        n = m;
        m = n;
        scanner.nextLine(); 
        String x = scanner.nextLine();
        String s = scanner.nextLine();

        for (int i = 0; i < 6; i++) {
            if (x.contains(s)) {
                System.out.println(i);
                return;
            }
            x += x;
        }
        System.out.println(-1);
    }
}
