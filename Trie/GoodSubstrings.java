import java.io.*;
import java.util.*;

public class GoodSubstrings {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    private static class Node {
		Node[] childs;
		boolean isLeaf;

		Node() {
			childs = new Node[26];
			isLeaf = false;
		}
    }

    public static void solve() {
        String str = in.next();
        String s = in.next();
        int k = in.nextInt();

        long res = 0;
        Node root = new Node();

        for(int i=0; i<str.length(); i++) {
        	int bad = 0;
        	Node curr = root;
        	for(int j=i; j<str.length(); j++) {
        		char ch = str.charAt(j);
        		bad += s.charAt(ch-'a') == '1' ? 0 : 1;

        		if(bad > k) break;

        		int p = ch - 'a';

        		if(curr.childs[p] == null) {
        			curr.childs[p] = new Node();
        		}
        		curr = curr.childs[p];

        		if(curr.isLeaf == false) {
    				res++;
    			}
    			curr.isLeaf = true;
        	}
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