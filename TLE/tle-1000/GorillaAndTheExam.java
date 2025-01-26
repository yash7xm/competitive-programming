import java.io.*;
import java.util.*;

public class GorillaAndTheExam {

	static FastReader in = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		int t = in.nextInt();
		while (t-- > 0) {
			solve();
		}
		out.flush();
	}

	public static void solve() {
		int n = in.nextInt();
		int k = in.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}


		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		List<Integer> list = new ArrayList<>(map.values());
		Collections.sort(list);

		int cnt = list.size();
		for (int freq : list) {
			if (freq <= k) {
				k -= freq;
				cnt--;
			} else {
				break;
			}
		}

		out.println(cnt == 0 ? 1 : cnt);
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}
}