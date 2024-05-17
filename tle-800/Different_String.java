import java.util.Scanner;

public class Different_String {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            String s = in.next();
            char ch = s.charAt(0);
            int j = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ch) {
                    j = i;
                    break;
                }
            }

            if (j == -1) {
                System.out.println("NO");
            } else {
                StringBuilder ans = new StringBuilder();
                ans.append(s.charAt(j));
                for (int i = 0; i < s.length(); i++) {
                    if (i != j)
                        ans.append(s.charAt(i));
                }
                System.out.println("YES");
                System.out.println(ans);
            }
        }
        in.close();
    }
}
