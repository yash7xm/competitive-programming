import java.util.*;

public class Balanced_Shuffle_Easy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();
        int n = s.length();
        int[] prefix = new int[n];
        prefix[0] = 0;
        int openCount = 0;
        int closeCount = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == '(') {
                openCount++;
            } else {
                closeCount++;
            }
            prefix[i] = openCount - closeCount;
        }

        TreeMap<Integer, Stack<Integer>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            Stack<Integer> st;
            if (map.containsKey(prefix[i])) {
                st = map.get(prefix[i]);
                st.push(i + 1);
            } else {
                st = new Stack<>();
                st.push(i + 1);
                map.put(prefix[i], st);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (Integer key : map.keySet()) {
            Stack<Integer> st;
            st = map.get(key);
            while (st.size() > 0) {
                int pos = st.pop();
                ans.append(s.charAt(pos - 1));
            }
        }
        System.out.println(ans.toString());

        in.close();
    }
}
