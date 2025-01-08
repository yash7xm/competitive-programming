import java.util.Scanner;

public class InversionCount {

    static long res;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            res = 0;
            solve(arr, 0, arr.length - 1);
            System.out.println(res);
        }
        in.close();
    }

    static int[] solve(int[] arr, int start, int end) {
        if (start >= end) {
            return new int[] { arr[start] };
        }

        int mid = (start + end) / 2;
        int[] left = solve(arr, start, mid);
        int[] right = solve(arr, mid + 1, end);

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int n = left.length;
        int m = right.length;
        int[] arr = new int[n + m];

        int i = 0, j = 0, idx = 0;
        while (i < n && j < m) {
            if (left[i] < right[j]) {
                arr[idx++] = left[i];
                i++;
                res += j;
            } else {
                arr[idx++] = right[j];
                j++;
            }
        }

        while (i < n) {
            arr[idx++] = left[i];
            i++;
            res += j;
        }

        while (j < m) {
            arr[idx++] = right[j];
            j++;
        }
        return arr;
    }
}
