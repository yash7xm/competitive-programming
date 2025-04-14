import java.io.*;
import java.util.*;

public class BeautifulSubarrays {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static class Trie {
    	private static class Node {
    		Node left, right;
    		int cnt;

    		Node() {
    			left = null;
    			right = null;
    			cnt = 0;
    		}
    	}

        public static Node root;

        public Trie() {
        	root = new Node();
        }

        public static void insert(int num) {
        	int bitIndex = 30;
        	Node curr = root;

        	while(bitIndex >= 0) {
        		int mask = (1 << bitIndex);
        		int bit = (num & mask) > 0 ? 1 : 0;

        		curr.cnt++;
        		if(bit == 0) {
        			if(curr.left == null) curr.left = new Node();
        			curr = curr.left;
        		} else {
        			if(curr.right == null) curr.right = new Node();
        			curr = curr.right;
        		}

        		bitIndex--;
        	}
        	curr.cnt++;
        }

        public static long query(int q, int k) {
        	int bitIndex = 30;
        	Node curr = root;
        	long res = 0;

        	while(bitIndex >= 0) {
        		int mask = (1 << bitIndex);
        		int qbit = (q & mask) > 0 ? 1 : 0;
        		int kbit = (k & mask) > 0 ? 1 : 0;

        		if(kbit == 1) {
        			if(qbit == 0) {
        				if(curr.left != null) res += curr.left.cnt;
        				if(curr.right != null) curr = curr.right;
        				else return res;
        			} else {
        				if(curr.right != null) res += curr.right.cnt;
        				if(curr.left != null) curr = curr.left;
        				else return res;
        			}
        		} else {
        			if(qbit == 0) {
        				if(curr.left != null) curr = curr.left;
        				else return res;
        			} else {
        				if(curr.right != null) curr = curr.right;
        				else return res;
        			}
        		}

        		bitIndex--;
        	}

        	return res;
        }
    }

    static void solve() {
        int n = in.nextInt();
        int k = in.nextInt();

        Trie t = new Trie();

        long res = 0;
        int p = 0;
        t.insert(0);
        for (int i = 0; i < n; i++) {
        	int q = p ^ (in.nextInt());
        	res += (i - t.query(q, k) + 1);
        	t.insert(q);
        	p = q;
        }

        out.println(res);
    }

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        out.close();
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}