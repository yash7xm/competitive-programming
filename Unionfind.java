import java.io.*;
import java.util.*;

public class Unionfind {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int[] par, rank;

    public static int find(int x) {
    	if(par[x] == x) return x;
    	int temp = find(par[x]);
    	par[x] = temp;
    	return temp;
    }

    public static void union(int x, int y) {
    	int lx = find(x);
    	int ly = find(y);

    	if(lx != ly) {
    		if(rank[lx] > rank[ly]) {
    			par[ly] = lx;
    		} else if(rank[lx] < rank[ly]) {
    			par[lx] = ly;
    		} else {
    			par[lx] = ly;
    			rank[ly]++;
    		}
    	}
    }

    public static void solve() {
    		int n = in.nextInt();
    		int q = in.nextInt();

    		par = new int[n];
    		rank = new int[n];
    		for(int i = 0; i < n; i++) {
        		par[i] = i;
        		rank[i] = 1;
    		}

    		for(int i = 0; i < q; i++) {
        		int type = in.nextInt();
        		int u = in.nextInt();
        		int v = in.nextInt();
        
        	if(type == 0) {
            	union(u, v);
        	} else {
           		if(find(u) == find(v)) {
                	out.println("1");
            	} else {
                	out.println("0");
            	}
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