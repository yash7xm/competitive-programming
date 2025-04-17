import java.util.*;

public class AncientBerlandRoads {
    static int N, M, Q;
    static int[] parentCity, setSize, currPop, initialPop;
    static List<int[]> initialRoads = new ArrayList<>();
    static Stack<Object> queriesStack = new Stack<>();
    static Set<Integer> unusableRoads = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        Q = sc.nextInt();

        parentCity = new int[N + 1];
        setSize = new int[N + 1];
        currPop = new int[N + 1];
        initialPop = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            initialPop[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int city1 = sc.nextInt();
            int city2 = sc.nextInt();
            initialRoads.add(new int[]{city1, city2});
        }

        for (int i = 0; i < Q; i++) {
            String type = sc.next();
            if (type.equals("D")) {
                int roadIndex = sc.nextInt();
                queriesStack.push(roadIndex);
                unusableRoads.add(roadIndex);
            } else if (type.equals("P")) {
                int city = sc.nextInt();
                int newPop = sc.nextInt();
                queriesStack.push(new int[]{city, initialPop[city]});
                initialPop[city] = newPop; // set new pop immediately
            }
        }

        System.arraycopy(initialPop, 0, currPop, 0, initialPop.length);
        makeSet();

        for (int i = 1; i <= M; i++) {
            if (!unusableRoads.contains(i)) {
                int[] edge = initialRoads.get(i - 1);
                unionSet(edge[0], edge[1]);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 1; i <= N; i++) {
            pq.add(new int[]{currPop[i], i});
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(pq.peek()[0]);

        while (!queriesStack.isEmpty()) {
            Object top = queriesStack.pop();

            if (top instanceof Integer) {
                int roadIndex = (Integer) top;
                int[] edge = initialRoads.get(roadIndex - 1);
                unionSet(edge[0], edge[1]);
                pq.add(new int[]{currPop[findSet(edge[0])], findSet(edge[0])});
            } else if (top instanceof int[]) {
                int[] popChange = (int[]) top;
                int city = popChange[0];
                int oldPop = popChange[1];
                int set = findSet(city);
                currPop[set] += oldPop - initialPop[city];
                pq.add(new int[]{currPop[set], set});
                initialPop[city] = oldPop;
            }

            while (!pq.isEmpty() && currPop[findSet(pq.peek()[1])] != pq.peek()[0]) {
                pq.poll();
            }

            ans.add(pq.peek()[0]);
        }

        for (int i = ans.size() - 2; i >= 0; i--) {
            System.out.println(ans.get(i));
        }
    }

    static void makeSet() {
        for (int i = 1; i <= N; i++) {
            parentCity[i] = i;
            setSize[i] = 1;
        }
    }

    static int findSet(int node) {
        if (parentCity[node] != node)
            parentCity[node] = findSet(parentCity[node]);
        return parentCity[node];
    }

    static void unionSet(int a, int b) {
        int rootA = findSet(a);
        int rootB = findSet(b);
        if (rootA == rootB) return;

        if (setSize[rootA] < setSize[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        parentCity[rootB] = rootA;
        currPop[rootA] += currPop[rootB];
        setSize[rootA] += setSize[rootB];
    }
}
