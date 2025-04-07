import java.util.*;
import java.io.*;

public class APTree {

	static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class Node {
    	long a, d, k;

    	public Node(long a, long d, long k) {
    		this.a = a;
    		this.d = d;
    		this.k = k;
    	}
    }

    static class SegmentTree {
    	Node[] tree;
    	int size;

    	public SegmentTree(int n) {
    		this.size = n;
    		tree = new Node[4 * n + 1];
    		for(int i=1; i<=4*n; i++) {
    			tree[i] = new Node(0, 0, 0);
    		}
    	}

    	private Node merge(Node left, Node right) {
            return new Node(left.a + right.a, left.d + right.d, left.k + right.k);
        }

    	public void update(int l, int r, int a, int d) {
    		update(1, 1, size, l, r, a , d);
    	}

    	private void update(int node, int start, int end, int l, int r, int a, int d) {
    		if(r < start || end < l) return;
    		if(l <= start && end <= r) {
    			tree[node].a += a;
    			tree[node].d += d;
    			tree[node].k += l*d;
    			return;
    		}

    		int mid = (start + end) / 2;
    		update(2*node, start, mid, l, r, a, d);
    		update(2*node + 1, mid + 1, end, l, r, a, d);
    	}

    	public long query(int i) {
    		Node res = query(1,1,size,i);

    		long ans = res.a + i*res.d - res.k;

    		return ans;
    	}

    	private Node query(int node, int start, int end, int i) {
    		if(start == end) {
    			return tree[node];
    		}

    		int mid = (start + end) / 2;
    		
    		Node res;
    		if(i <= mid) {
    			res = query(2*node, start , mid , i);
    		} else {
    			res = query(2*node + 1, mid + 1,end, i);
    		}

    		return merge(tree[node], res);
    	}
    }

	public static void main(String[] args) {
		int n = in.nextInt();
		int m = in.nextInt();

		SegmentTree segTree = new SegmentTree(n);

		while(m-- > 0) {
			int type = in.nextInt();
			if(type == 1) {
				int l = in.nextInt();
				int r = in.nextInt();
				int a = in.nextInt();
				int d = in.nextInt();

				segTree.update(l,r,a,d);
			} else {
				int i = in.nextInt();
				out.println(segTree.query(i));
			}
		}

		out.flush();
	}

	static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}