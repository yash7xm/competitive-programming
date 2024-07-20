import java.io.*;
import java.util.StringTokenizer;

public class PlanetQueries2 {
	private static int MAX_HEIGHT = 20;
	private static int[][] binaryLifting;
	private static int[] arr;
	private static int[] len;
	private static boolean[] visited;

	public static void main(String[] args) {
		Kattio io = new Kattio();
		StringBuilder output = new StringBuilder();
		int n = io.nextInt();
		int q = io.nextInt();
		arr = new int[n + 1];
		binaryLifting = new int[n + 1][MAX_HEIGHT];
		len = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = io.nextInt();
		}

		visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
			}
		}

		for (int i = 0; i < q; i++) {
			int a = io.nextInt();
			int b = io.nextInt();
			int aa = jump(a, len[a]);
			int answer;
			if (jump(a, len[a] - len[b]) == b) {
				answer = len[a] - len[b];
			} else if (jump(aa, len[aa] - len[b]) == b) {
				answer = (len[aa] - len[b]) + len[a];
			} else {
				answer = -1;
			}
			output.append(answer).append("\n");
		}
		io.println(output);
		io.close();
	}

	private static void dfs(int node) {
		if (visited[node]) {
			return;
		}
		visited[node] = true;
		dfs(arr[node]);
		binaryLifting[node][0] = arr[node];
		len[node] = len[binaryLifting[node][0]] + 1;
		for (int level = 1; level < MAX_HEIGHT; level++) {
			binaryLifting[node][level] = binaryLifting[binaryLifting[node][level - 1]][level - 1];
		}
	}

	private static int jump(int a, int dist) {
		if (dist < 0)
			return -1;
		int level = 0;
		while (dist != 0) {
			if ((dist & 1) == 1) {
				a = binaryLifting[a][level];
			}
			level++;
			dist = dist / 2;
		}
		return a;
	}

	static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;

		public Kattio() {
			this(System.in, System.out);
		}

		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}

		public Kattio(String problemName) throws IOException {
			super(problemName + ".out");
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}

		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) {
			}
			return null;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}