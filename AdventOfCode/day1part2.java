package AdventOfCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class day1part2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            if (!line.isEmpty()) {
                String[] nums = line.split("\\s+");
                int num1 = Integer.parseInt(nums[0]);
                int num2 = Integer.parseInt(nums[1]);
                list1.add(num1);
                list2.add(num2);
                map.put(num2, map.getOrDefault(num2, 0) + 1);
            } else {
                break;
            }
        }

        long res = 0;
        for (int num : list1) {
            res += num * map.getOrDefault(num, 0);
        }

        System.out.println(res);

        in.close();
    }
}
