import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MoneyBuysLessHappinessNow {
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

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            long sum = 0;
            for (int c : arr) {
                if (sum >= c) {
                    pq.add(c);
                    sum -= c;
                } else if (pq.size() > 0 && pq.peek() > c) {
                    int max = pq.poll();
                    sum += max - c;
                    pq.add(c);
                }

                sum += x;
            }

            System.out.println(pq.size());
        }
        in.close();
    }
}
