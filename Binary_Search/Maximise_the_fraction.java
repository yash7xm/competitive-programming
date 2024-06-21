import java.util.PriorityQueue;
import java.util.Scanner;

public class Maximise_the_fraction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }

            double lo = 0.0;
            double hi = 1e8;
            double ans = lo;

            while (Math.abs(lo - hi) > 1e-9) {
                double mid = (lo + hi) / 2.0;
                PriorityQueue<Double> pq = new PriorityQueue<>();
                for (int i = 0; i < n; i++) {
                    pq.add(a[i] - mid * b[i]);
                    if (pq.size() > k)
                        pq.poll();
                }
                double s = 0.0;
                while (pq.size() > 0) {
                    s += pq.peek();
                    pq.poll();
                }

                if (s >= 0.0) {
                    ans = mid;
                    lo = mid;
                } else {
                    hi = mid;
                }
            }

            System.out.printf("%.6f%n", ans);
        }
        in.close();
    }
}
