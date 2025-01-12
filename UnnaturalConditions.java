import java.util.Scanner;

public class UnnaturalConditions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextInt();
        in.nextInt();

        for (int i = 0; i < 2000; i++) {
            System.out.print("5");
        }
        System.out.println();
        for (int i = 0; i < 1999; i++) {
            System.out.print("4");
        }
        System.out.print("5");
        System.out.println();
        in.close();
    }
}
