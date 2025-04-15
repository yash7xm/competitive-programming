import java.io.*;
import java.util.*;

class AdaAndIndexing {
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

    	public static Node root;

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
    			if(curr.childs[ch-'a'] == null) {
    				return 0;
    			}
    			curr = curr.childs[ch-'a'];
    		}
    		return curr.cnt;
    	}
    }

    static void solve() {
        int n = in.nextInt();
       	int q = in.nextInt();

       	Trie t = new Trie();

       	for(int i=0; i<n; i++) {
       		String word = in.next();
       		t.insert(word);
       	}

       	for(int i=0; i<q; i++) {
       		String word = in.next();
       		out.println(t.query(word));
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