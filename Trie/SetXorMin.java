import java.io.*;
import java.util.*;

public class SetXorMin {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static class Trie {
    	private static class Node {
    		Node left, right;
    		int cnt;
    	}

    	public static Node root;

    	public Trie() {
    		root = new Node();
    	}

    	public static void insert(int num, int x) {
    		int bitIndex = 30;
    		Node curr = root;

    		while(bitIndex >= 0) {
    			int mask = 1 << bitIndex;
    			int bit = (num & mask) > 0 ? 1 : 0;

    			curr.cnt += x;
    			if(bit == 0) {
    				if(curr.left == null) {
    					curr.left = new Node();
    				}
    				curr = curr.left;
    			} else {
    				if(curr.right == null) {
    					curr.right = new Node();
    				}
    				curr = curr.right;
    			}

    			bitIndex--;
    		}
    		curr.cnt += x;
    	}

    	public static int query(int num) {
    		int bitIndex = 30;
    		Node curr = root;
    		int ans = 0;

    		while(bitIndex >= 0) {
    			int mask = 1 << bitIndex;
    			int bit = (num & mask) > 0 ? 1 : 0;

    			if(bit == 0) {
    				if(curr.left != null && curr.left.cnt > 0) {
    					curr = curr.left;
    				} else {
    					curr = curr.right;
    					ans |= mask;
    				}
    			} else {
    				if(curr.right != null && curr.right.cnt > 0) {
    					curr = curr.right;
    				} else {
    					curr = curr.left;
    					ans |= mask;
    				}
    			}

    			bitIndex--;
    		}

    		return ans;
    	}
    }

    static void solve() {
        int n = in.nextInt();

        HashSet<Integer> set = new HashSet<>();
        Trie t = new Trie();

        for(int i=0; i<n; i++) {
        	int type = in.nextInt();
        	int x = in.nextInt();

        	if(type == 0) {
        		set.add(x);
        		t.insert(x, 1);
        	} else if(type == 1) {
        		if(set.contains(x)) {
        			t.insert(x, -1);
        			set.remove(x);
        		}
        	} else {
        		out.println(t.query(x));
        	}
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