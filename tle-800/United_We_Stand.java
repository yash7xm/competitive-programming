import java.util.ArrayList;
import java.util.Scanner;

public class United_We_Stand {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t-- > 0){
            int n = in.nextInt();
            int[] arr = new int[n];

            int max = Integer.MIN_VALUE;
            for(int i=0; i<n; i++) {
                arr[i] = in.nextInt();
                max = Math.max(arr[i], max);
            }

            ArrayList<Integer> listb = new ArrayList<>();
            ArrayList<Integer> listc = new ArrayList<>();

            for(int i=0; i<n; i++){
                if(arr[i] == max) {
                    listc.add(arr[i]);
                } else {
                    listb.add(arr[i]);
                }
            }

            if(listb.size() == 0 || listc.size() == 0) {
                System.out.println(-1);
            } else {
                System.out.println(listb.size() + " " + listc.size());
                for(int i=0; i<listb.size(); i++){
                    System.out.print(listb.get(i) + " ");
                }
                System.out.println();
                for(int i=0; i<listc.size(); i++){
                    System.out.print(listc.get(i) + " ");
                }
                System.out.println();
            }
        }
        in.close();
    }
}
