package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class USBvsPS2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int m = in.nextInt();

        ArrayList<Integer> usbMouses = new ArrayList<>();
        ArrayList<Integer> ps2Mouses = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int cost = in.nextInt();
            String type = in.next();
            if (type.equals("USB")) {
                usbMouses.add(cost);
            } else {
                ps2Mouses.add(cost);
            }
        }

        Collections.sort(usbMouses);
        Collections.sort(ps2Mouses);

        int totalComputers = 0;
        long totalCost = 0;

        int usbIndex = 0;
        while (a > 0 && usbIndex < usbMouses.size()) {
            totalCost += usbMouses.get(usbIndex++);
            totalComputers++;
            a--;
        }

        int ps2Index = 0;
        while (b > 0 && ps2Index < ps2Mouses.size()) {
            totalCost += ps2Mouses.get(ps2Index++);
            totalComputers++;
            b--;
        }

        ArrayList<Integer> remainingMouses = new ArrayList<>();
        while (usbIndex < usbMouses.size()) {
            remainingMouses.add(usbMouses.get(usbIndex++));
        }
        while (ps2Index < ps2Mouses.size()) {
            remainingMouses.add(ps2Mouses.get(ps2Index++));
        }
        Collections.sort(remainingMouses);

        int bothIndex = 0;
        while (c > 0 && bothIndex < remainingMouses.size()) {
            totalCost += remainingMouses.get(bothIndex++);
            totalComputers++;
            c--;
        }

        System.out.println(totalComputers + " " + totalCost);
        in.close();
    }
}
