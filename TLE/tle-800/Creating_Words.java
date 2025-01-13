import java.util.Scanner;

public class Creating_Words {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            String a = in.next();
            String b = in.next();

            StringBuilder sa = new StringBuilder();
            sa.append(b.charAt(0));
            sa.append(a.substring(1));

            StringBuilder sb = new StringBuilder();
            sb.append(a.charAt(0));
            sb.append(b.substring(1));

            System.out.println(sa.toString() + "  " + sb.toString());
        }
        in.close();
    }
}
