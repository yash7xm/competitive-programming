import java.util.Scanner;

public class Binary_Cut {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            String s = in.next();
            int count = 0;
            boolean flag = false;
            boolean zeroOne = false;

            for (int i = 0; i < s.length();) {
                while (i < s.length() && s.charAt(i) == '1') {
                    i++;
                    flag = true;
                }
                if (flag) {
                    count++;
                    flag = false;
                }

                while (i < s.length() && s.charAt(i) == '0') {
                    i++;
                    flag = true;
                }

                if (flag) {
                    if (!zeroOne) {
                        while (i < s.length() && s.charAt(i) == '1') {
                            i++;
                            zeroOne = true;
                        }
                    }
                    count++;
                    flag = false;
                }
            }

            System.out.println(count);
        }
        in.close();
    }
}
