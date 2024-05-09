import java.util.Scanner;
import java.util.Stack;

public class Game_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            String s = in.next();
            int count = 0;
            Stack<Character> st = new Stack<>();
            st.push(s.charAt(0));

            for (int i = 1; i < s.length(); i++) {
                if (st.size() > 0 && s.charAt(i) != st.peek()) {
                    st.pop();
                    count++;
                } else {
                    st.push(s.charAt(i));
                }
            }

            if (count % 2 == 0) {
                System.out.println("NET");
            } else {
                System.out.println("DA");
            }
        }
        in.close();
    }
}