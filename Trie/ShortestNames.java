import java.io.*;
import java.util.*;

class ShortestNames {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class Trie {
    	private static class Node {
    		Node[] childs;
    		int cnt;

    		Node() {
    			childs = new Node[26];
    			cnt = 0;
    		}
    	}

    	static Node root;

    	public Trie() {
    		root = new Node();
    	}

    	public void insert(String word) {
    		Node curr = root;
    		for(int i=0; i<word.length(); i++) {
    			char ch = word.charAt(i);
    			curr.cnt++;
    			if(curr.childs[ch-'a'] == null) {
    				curr.childs[ch-'a'] = new Node();
    			}
    			curr = curr.childs[ch-'a'];
    		}
    		curr.cnt++;
    	}

    	public int query(String word) {
    		Node curr = root;
    		for(int i=0; i<word.length(); i++) {
    			char ch = word.charAt(i);
    			if(curr.childs[ch-'a'].cnt == 1) {
    				return i+1;
    			}
    			curr = curr.childs[ch-'a'];
    		}
    		return word.length();
    	}
    }

    static void solve() {
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
        	arr[i] = in.next();
        }

        Trie t = new Trie();
        for(int i=0; i<n; i++) {
        	t.insert(arr[i]);
        }

        long res = 0;
        for(int i=0; i<n; i++) {
        	res += t.query(arr[i]);
        }

        out.println(res);
    }

    public static void main(String[] args) {
        int t = in.nextInt();
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