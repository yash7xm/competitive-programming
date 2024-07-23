import java.util.Scanner;
import java.util.Stack;

public class Traffic_Light {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            char c = in.next().charAt(0);
            String s = in.next();

            Stack<Integer> st = new Stack<>();

            boolean flag = false;
            int firstG = -1;
            int res = 0;
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == 'g') {
                    if (!flag) {
                        firstG = i;
                        flag = true;
                    }
                    while (st.size() > 0) {
                        int idx = st.pop();
                        res = Math.max(res, i - idx);
                    }
                } else if (ch == c) {
                    st.push(i);
                }
            }

            while (st.size() > 0) {
                int idx = st.pop();
                res = Math.max(res, (n - idx) + firstG);
            }

            System.out.println(res);
        }
        in.close();
    }
}
