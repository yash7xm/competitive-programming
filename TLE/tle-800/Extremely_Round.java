import java.util.Scanner;

public class Extremely_Round {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();

            int d = n;
            int count = 0;
            while (d > 0) {
                d = d / 10;
                count++;
            }
            int divideBy = (int) Math.pow(10, count - 1);

            int firstDigit = n / divideBy;

            int ans = (count - 1) * 9 + firstDigit;

            System.out.println(ans);

        }
        in.close();
    }
}
