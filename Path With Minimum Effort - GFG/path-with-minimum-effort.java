//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends

class Pair{
    int distance;
    int a;
    int b;
    Pair(int d,int i,int j){
        distance =d;
        a=i;
        b=j;
    }
}
class Solution {
    public boolean exist(int i,int j,int r,int c){
        if(i>=0 && i<r && j>=0 && j<c)return true;
        return false;
    }
    //dijkstra algorithm
    
    int MinimumEffort(int mat[][]) {
        int[] x = {0,0,-1,1};
        int[] y = {-1,1,0,0};

        int r= mat.length, c = mat[0].length;
        int[][] dist = new int[r][c];
        for(int[] i : dist) Arrays.fill(i,(int)(1e9));
        dist[0][0]=0;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> a.distance-b.distance);
        pq.add(new Pair(0,0,0));
        while(!pq.isEmpty()){
            int dis = pq.peek().distance;
            int i=pq.peek().a;
            int j= pq.peek().b;
            if(i==r-1 && j==c-1) break;
            pq.poll();
            for(int k=0;k<4;k++){
                int xx = i+x[k];
                int yy = j+y[k];
                if(exist(xx,yy,r,c) && Math.max(Math.abs(mat[xx][yy]-mat[i][j]),dist[i][j])<dist[xx][yy]){
                    dist[xx][yy] = Math.max(Math.abs(mat[xx][yy]-mat[i][j]),dist[i][j]);
                    pq.add(new Pair(dist[xx][yy],xx,yy));
                }
            }
        }
        return dist[r-1][c-1];
    }
}