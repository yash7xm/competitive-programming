import java.util.Scanner;

public class GoalsofVictory {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];

            int sum = 0;
            for(int i=0; i<n-1; i++){
                arr[i] = in.nextInt();
                sum += arr[i];
            }

            System.out.println(sum*-1);
        }
        in.close();
    }
}
