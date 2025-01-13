import java.util.Scanner;
import java.util.Stack;

public class Three_Indices {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int[] min = new int[n];
            min[0] = 0;

            for (int i = 1; i < n; i++) {
                if (arr[i] < arr[min[i - 1]]) {
                    min[i] = i;
                } else {
                    min[i] = min[i - 1];
                }
            }

            boolean found = false;
            String ans = "";
            Stack<Integer> st = new Stack<>();
            for (int j = n - 1; j >= 0; j--) {
                while (st.size() > 0 && arr[st.peek()] >= arr[j]) {
                    st.pop();
                }

                if (st.size() > 0 && arr[st.peek()] < arr[j] && arr[j] != arr[min[j]]) {
                    found = true;
                    int i = min[j] + 1;
                    j = j + 1;
                    int k = st.peek() + 1;
                    ans = i + " " + j + " " + k;
                    break;
                }

                st.push(j);
            }

            if (found) {
                System.out.println("YES");
                System.out.println(ans);
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }
}
