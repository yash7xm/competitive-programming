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

            for (int i = 0; i < k; i++) {
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

                for (int j = 0; j < k; j++) {
                    if (arr[j] > el) {
                        if (j == 0) {
                            double s = (double)arr[j] / b[j];
                            ans[i] = (int)((el*1.0) / s);
                        } else {
                            int d = arr[j] - arr[j - 1];
                            int time = b[j] - b[j - 1];
                            double s = (double)(d / time);

                            double newD = (double) el - arr[j-1];

                            ans[i] = (int)(newD / s);
                            ans[i] += b[j-1];
                        }
                        break;
                    } else if (arr[j] == el) {
                        ans[i] = b[j];
                        break;
                    }
                }
            }

            for(int i=0; i<ans.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
