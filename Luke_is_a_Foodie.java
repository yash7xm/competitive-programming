import java.util.Scanner;

public class Luke_is_a_Foodie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int lo = Math.abs(x - arr[0]);
            int hi = x + arr[0];
            int res = 0;

            for (int i = 1; i < n; i++) {
                int nlo = Math.abs(x - arr[i]);
                int nhi = x + arr[i];

                if ((nlo >= lo && nlo <= hi) || (nhi >= lo && nhi <= hi)) {
                    lo = Math.max(lo, nlo);
                    hi = Math.min(hi, nhi);
                } else {
                    res++;
                    lo = nlo;
                    hi = nhi;
                }
            }

            System.out.println(res);
        }
        in.close();
    }
}
