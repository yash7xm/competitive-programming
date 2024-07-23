import java.util.Scanner;
import java.math.BigInteger;

public class New_Bakery {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();

            if (b <= a) {
                BigInteger result = BigInteger.valueOf(n).multiply(BigInteger.valueOf(a));
                System.out.println(result);
            } else {
                int N = b - a + 1;
                if (N >= n) {
                    int an = b + (n) * (-1);
                    BigInteger bBig = BigInteger.valueOf(b);
                    BigInteger anBig = BigInteger.valueOf(an);
                    BigInteger res = bBig.multiply(bBig.add(BigInteger.ONE)).divide(BigInteger.valueOf(2))
                            .subtract(anBig.multiply(anBig.add(BigInteger.ONE)).divide(BigInteger.valueOf(2)));
                    System.out.println(res);
                } else {
                    int an = b + (N - 1) * (-1);
                    BigInteger bBig = BigInteger.valueOf(b);
                    BigInteger anBig = BigInteger.valueOf(an);
                    BigInteger part1 = bBig.multiply(bBig.add(BigInteger.ONE)).divide(BigInteger.valueOf(2))
                            .subtract(anBig.multiply(anBig.add(BigInteger.ONE)).divide(BigInteger.valueOf(2)));
                    BigInteger part2 = BigInteger.valueOf(n - N + 1).multiply(BigInteger.valueOf(a));
                    BigInteger res = part1.add(part2);
                    System.out.println(res);
                }
            }
        }
        in.close();
    }
}
