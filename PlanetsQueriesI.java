import java.util.*;

public class PlanetsQueriesI {

    static int MAX = 30;
    static int[][] table;

    static void build(int[] p) {
        int n = p.length;
        table = new int[MAX][n];

        for(int i=0; i<n; i++) {
            table[0][p[i]] = i;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int q = scn.nextInt();

        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scn.nextInt()-1;
        }

        scn.close();
    }
}