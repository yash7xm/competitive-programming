import java.io.*;
import java.util.*;

public class ALotOfGames {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static class Trie {
    	private static class Node {
    		Node[] childs;
    		boolean isLeaf;

    		Node() {
    			childs = new Node[26];
    			isLeaf = false;
    		}
    	}

    	public static Node root;

    	public Trie() {
    		root = new Node();
    	}

    	public static void insert(String word) {
    		Node curr = root;
    		for(char ch : word.toCharArray()) {
    			int i = ch - 'a';
    			if(curr.childs[i] == null) {
    				curr.childs[i] = new Node();
    			}
    			curr = curr.childs[i];
    		}
    		curr.isLeaf = true;
    	}

    	public static boolean canWin() {
    		return canWin(root);
    	}

    	private static boolean canWin(Node node) {
        	for (Node child : node.childs) {
            	if (child != null && !canWin(child)) {
                	return true;
            	}
        	}
        	return false;
    	}

    	public static boolean canLose() {
    		return canLose(root);
    	}

    	private static boolean canLose(Node node) {
        	boolean hasChild = false;
        	for (Node child : node.childs) {
            	if (child != null) {
                	hasChild = true;
                	if (!canLose(child)) {
                    	return true;
                	}
            	}
        	}
        	return !hasChild;
    	}
    }

    static void solve() {
        int n = in.nextInt();
        int k = in.nextInt();

        Trie t = new Trie();

        for(int i=0; i<n; i++) {
        	t.insert(in.next());
        }

        boolean win = t.canWin();
        boolean lose = t.canLose();

        if (!win) {
            System.out.println("Second");
        } else if (lose) {
            System.out.println((k % 2 == 1) ? "First" : "Second");
        } else {
            System.out.println("First");
        }
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