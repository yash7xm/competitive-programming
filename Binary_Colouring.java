import java.util.Scanner;

public class Binary_Colouring {

    private static boolean foundSolution;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long x = in.nextLong();
            foundSolution = false;
            solve("", 0, 0, x);
        }
        in.close();
    }

    private static void solve(String psf, long sum, double i, long tar) {

        if (foundSolution)
            return;

        if (i > 32)
            return;

        if (psf.length() > 1 && psf.charAt(psf.length() - 1) != '0' && psf.charAt(psf.length() - 2) != '0') {
            return;
        }

        if (sum > tar) {
            return;
        }

        if (sum == tar) {
            foundSolution = true;
            System.out.println((long) i);
            for (int j = 0; j < psf.length(); j++) {
                char ch = psf.charAt(j);
                if (ch == '2')
                    System.out.print("-1" + " ");
                else
                    System.out.print(ch + " ");
            }
            System.out.println();
            return;
        }

        long twoValue = (long) Math.pow(2.0, i);
        solve(psf + "2", sum - twoValue, i + 1, tar);
        solve(psf + "0", sum, i + 1, tar);
        solve(psf + "1", sum + twoValue, i + 1, tar);
    }
}
