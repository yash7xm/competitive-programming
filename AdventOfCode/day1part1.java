package AdventOfCode;
import java.util.*;

public class day1part1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            if (!line.isEmpty()) {
                String[] nums = line.split("\\s+");
                list1.add(Integer.parseInt(nums[0]));
                list2.add(Integer.parseInt(nums[1]));
            } else {
                break;
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        long ans = 0;
        for (int i = 0; i < list1.size(); i++) {
            ans += Math.abs(list1.get(i) - list2.get(i));
        }

        System.out.println(ans);

        in.close();
    }
}
