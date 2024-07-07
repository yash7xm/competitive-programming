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

            int lo = arr[0] - x;
            int hi = arr[0] + x;
            int res = 0;

            for (int i = 1; i < n; i++) {
                int nlo = arr[i] - x;
                int nhi = arr[i] + x;

                if ((nlo >= lo && nlo <= hi) || (nhi >= lo && nhi <= hi)) {
                    lo = Math.max(lo, nlo);
                    hi = Math.min(hi, nhi);
                } else if ((lo >= nlo && lo <= nhi) || (hi >= nlo && hi <= nhi)) {
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
