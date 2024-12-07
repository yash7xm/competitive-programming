package AdventOfCode;

import java.util.*;

public class day5part2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            if (line.isEmpty()) {   
                break;
            }
            String[] parts = line.split("\\|");
            int u = Integer.parseInt(parts[0].trim());
            int v = Integer.parseInt(parts[1].trim());

            graph.putIfAbsent(u, new HashSet<Integer>());
            graph.putIfAbsent(v, new HashSet<Integer>());
            graph.get(u).add(v);
        }

        ArrayList<ArrayList<Integer>> updates = new ArrayList<>();
        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }
            String[] parts = line.split(",");
            ArrayList<Integer> update = new ArrayList<>();
            for (String part : parts) {
                update.add(Integer.parseInt(part.trim()));
            }
            updates.add(update);
        }

        long result = 0;
        for (ArrayList<Integer> update : updates) {
            if (!isValidUpdate(update, graph)) {
                makeValidUpdate(update, graph);
                int middleIndex = update.size() / 2;
                result += update.get(middleIndex);
            }
        }

        System.out.println(result);
        in.close();
    }

    private static boolean isValidUpdate(ArrayList<Integer> update, HashMap<Integer, HashSet<Integer>> graph) {
        for (int i = 0; i < update.size(); i++) {
            for (int j = i + 1; j < update.size(); j++) {
                int u = update.get(i);
                int v = update.get(j);

                if (graph.containsKey(u) && !graph.get(u).contains(v)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void makeValidUpdate(ArrayList<Integer> update, HashMap<Integer, HashSet<Integer>> graph) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < update.size(); i++) {
                for (int j = i + 1; j < update.size(); j++) {
                    int u = update.get(i);
                    int v = update.get(j);

                    if (graph.containsKey(u) && !graph.get(u).contains(v)) {
                        update.set(i, v);
                        update.set(j, u);
                        isSorted = false;
                    }
                }
            }
        }
    }
}
