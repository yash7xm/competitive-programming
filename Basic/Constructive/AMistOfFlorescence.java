import java.util.Scanner;

public class AMistOfFlorescence {

    static int A, B, C, D;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        A = in.nextInt();
        B = in.nextInt();
        C = in.nextInt();
        D = in.nextInt();

        int[][] arr = new int[50][50];
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                if ((i & 1) == 0) {
                    arr[i][j] = 1;
                } else {
                    if ((j & 1) == 0) {
                        arr[i][j] = 1;
                    } else {
                        if (B > 1) {
                            arr[i][j] = 2;
                            B--;
                        } else if (C > 1) {
                            arr[i][j] = 3;
                            C--;
                        } else if (D > 1) {
                            arr[i][j] = 4;
                            D--;
                        } else {
                            arr[i][j] = 1;
                        }
                    }
                }
            }
        }

        for (int i = 25; i < 50; i++) {
            for (int j = 0; j < 25; j++) {
                if ((i & 1) == 1) {
                    arr[i][j] = 2;
                } else {
                    if ((j & 1) == 0) {
                        arr[i][j] = 2;
                    } else {
                        if (A > 1) {
                            arr[i][j] = 1;
                            A--;
                        } else if (C > 1) {
                            arr[i][j] = 3;
                            C--;
                        } else if (D > 1) {
                            arr[i][j] = 4;
                            D--;
                        } else {
                            arr[i][j] = 2;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 25; i++) {
            for (int j = 25; j < 50; j++) {
                if ((i & 1) == 0) {
                    arr[i][j] = 3;
                } else {
                    if ((j & 1) == 1) {
                        arr[i][j] = 3;
                    } else {
                        if (A > 1) {
                            arr[i][j] = 1;
                            A--;
                        } else if (B > 1) {
                            arr[i][j] = 2;
                            B--;
                        } else if (D > 1) {
                            arr[i][j] = 4;
                            D--;
                        } else {
                            arr[i][j] = 3;
                        }
                    }
                }
            }
        }

        for (int i = 25; i < 50; i++) {
            for (int j = 25; j < 50; j++) {
                if ((i & 1) == 1) {
                    arr[i][j] = 4;
                } else {
                    if ((j & 1) == 1) {
                        arr[i][j] = 4;
                    } else {
                        if (A > 1) {
                            arr[i][j] = 1;
                            A--;
                        } else if (C > 1) {
                            arr[i][j] = 3;
                            C--;
                        } else if (B > 1) {
                            arr[i][j] = 2;
                            B--;
                        } else {
                            arr[i][j] = 4;
                        }
                    }
                }
            }
        }

        System.out.println("50 50");
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (arr[i][j] == 1) {
                    System.out.print("A");
                } else if (arr[i][j] == 2) {
                    System.out.print("B");
                } else if (arr[i][j] == 3) {
                    System.out.print("C");
                } else if (arr[i][j] == 4) {
                    System.out.print("D");
                }
            }
            System.out.println();
        }
        in.close();
    }
}
