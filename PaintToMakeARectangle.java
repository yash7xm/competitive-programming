import java.io.*;
import java.util.*;

public class PaintToMakeARectangle {
	
	static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) {
		solve();
		out.flush();
	}

	public static void solve() {
		int h = in.nextInt();
		int w = in.nextInt();

		int[][] arr = new int[h][w];
		for(int i=0; i<h; i++) {
			String row = in.next();
			for(int j=0; j<w; j++) {
				char ch = row.charAt(j);
				if(ch == '#') arr[i][j] = 0;
				if(ch == '.') arr[i][j] = 1;
				if(ch == '?') arr[i][j] = -1;
			}
		}

		int rowminx = w, rowminy = w, rowmaxx = 0, rowmaxy = 0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(arr[i][j] == 0) {
					rowminx = Math.min(rowminx, i);
					rowminy = Math.min(rowminy, j);
					rowmaxx = Math.max(rowmaxx, i);
					rowmaxy = Math.max(rowmaxy, j);
				}
			}
		}

		int colminx = h, colminy = h, colmaxx = 0, colmaxy = 0;
		for(int j=0; j<w; j++) {
			for(int i=0; i<h; i++) {
				if(arr[i][j] == 0) {
					colminx = Math.min(colminx, i);
					colminy = Math.min(colminy, j);
					colmaxx = Math.max(colmaxx, i);
					colmaxy = Math.max(colmaxy, j);
				}
			}
		}

		int x1,y1,x2,y2,x3,y3,x4,y4;

		x1 = Math.min(rowminx, colminx);
		y1 = Math.min(rowminy, colminy);

		x2 = Math.max(rowmaxx, colminx);
		y2 = Math.min(rowmaxy, colminy);

		x3 = Math.min(rowminx, colmaxx);
		y3 = Math.max(rowminy, colmaxy);

		x4 = Math.max(rowmaxx, colmaxx);
		y4 = Math.max(rowmaxy, colmaxy);

		out.println(x1 + " " + y1);
		out.println(x2 + " " + y2);
		out.println(x3 + " " + y3);
		out.println(x4 + " " + y4);

		for(int i=x1; i<=x4; i++) {
			for(int j=y1; j<=y4; j++) {
				if(arr[i][j] == 1) {
					out.println("No");
					return;
				}	
			}
		}

		out.println("Yes");
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