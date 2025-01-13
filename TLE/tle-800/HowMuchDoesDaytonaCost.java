import java.util.Scanner;

public class HowMuchDoesDaytonaCost {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();

            boolean res = false;
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = in.nextInt();
                if(arr[i] == k) res = true;
            }

            if(res) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }
}
