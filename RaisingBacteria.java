import java.util.Scanner;

public class RaisingBacteria {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        while (n != 0) {
            int rsbm = n & -n;
            n -= rsbm;
            res++;
        }

        System.out.println(res);
        in.close();
    }
}
