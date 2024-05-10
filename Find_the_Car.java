import java.util.Scanner;

public class Find_the_Car {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int q = in.nextInt();

            int[] arr = new int[k];
            int[] b = new int[k];
            int[] quer = new int[q];
            int[] ans = new int[q];

            for (int i = 0; i < k && n > 0; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < k; i++) {
                b[i] = in.nextInt();
            }
            for (int i = 0; i < q; i++) {
                quer[i] = in.nextInt();
            }

            for (int i = 0; i < q; i++) {
                int el = quer[i];

                int j = bs(arr, el);

                if (arr[j] > el) {
                    if (j == 0) {
                        double s = (double) arr[j] / b[j];
                        ans[i] = (int) ((el * 1.0) / s);
                    } else {
                        int d = arr[j] - arr[j - 1];
                        int time = b[j] - b[j - 1];
                        double s = (double) d / time;

                        double newD = el - arr[j - 1];

                        ans[i] = (int) (newD / s);
                        ans[i] += b[j - 1];
                    }
                } else if (arr[j] == el) {
                    ans[i] = b[j];
                }
            }

            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
        in.close();
    }

    public static int bs(int[] arr, int t) {
        int si = 0;
        int ei = arr.length - 1;
        while (si < ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] > t) {
                ei = mid;
            } else if (arr[mid] < t) {
                si = mid + 1;
            } else {
                si = mid;
                break;
            }
        }
        return si;
    }
}
