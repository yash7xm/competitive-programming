import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SegmentsWithSmallSpread {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long k = in.nextLong();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }

        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        long res = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[j]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(j);

            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[j]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(j);

            while (!maxDeque.isEmpty() && !minDeque.isEmpty() &&
                    arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > k) {
                if (minDeque.peekFirst() == i) {
                    minDeque.pollFirst();
                }
                if (maxDeque.peekFirst() == i) {
                    maxDeque.pollFirst();
                }
                i++;
            }

            res += j - i + 1;
        }

        System.out.println(res);
        in.close();
    }
}
