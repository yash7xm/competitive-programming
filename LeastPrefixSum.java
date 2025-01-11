import java.util.*;

public class LeastPrefixSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
        sc.close();
    }

    private static void solve(Scanner sc) {
        long n = sc.nextLong(); 
        long m = sc.nextLong();
        long ans = 0, sum = 0, mn = 0;
        long[] arr = new long[(int) n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
        PriorityQueue<Long> minHeap = new PriorityQueue<>(); 

        for (int i = 0; i < m; i++) {
            mn += arr[i];
        }
        sum = mn;

        for (int i = (int) m - 1; i >= 1; i--) {
            sum -= arr[i];
            maxHeap.add(arr[i]);
            if (sum < mn) {
                ans++;
                mn -= 2 * maxHeap.poll();
            }
        }

        sum = 0;
        for (int i = (int) m; i < n; i++) {
            sum += arr[i];
            minHeap.add(arr[i]);
            while (sum < 0) {
                ans++;
                sum -= 2 * minHeap.poll();
            }
        }

        System.out.println(ans);
    }
}
