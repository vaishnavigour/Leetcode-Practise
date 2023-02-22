//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int first;
    int second;
    Pair(int a,int b){
        first =a;
        second =b;
    }
}
class Solution {
    boolean exists(int i,int j, int r, int c){
        if(i>=0 && i<r && j<c && j>=0)return true;
        return false;
    }
    int bfs(int i, int j, int desti, int destj,int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        int ans =0;
        
        int[] x = {-1,1,0,0};
        int[] y = {0,0,-1,1};
        
        while(!q.isEmpty()){
            
            int size=q.size();
            while(size-->0){
                int ii = q.peek().first;
                int jj = q.peek().second;
                q.poll();
                for(int k=0;k<4;k++){
                    int xx = x[k]+ii;
                    int yy = y[k]+jj;
                    if(xx==desti && yy==destj)return ans+1;
                    if(exists(xx,yy,row,col) && grid[xx][yy]==1){
                        grid[xx][yy]=2;
                        q.add(new Pair(xx,yy));
                    }
                }
            }
            ans++;
        }
        return -1;
        
    }
    int shortestPath(int[][] grid, int[] s, int[] d) {
        if(s[0]==d[0]&& s[1]==d[1]) return 0;
        return bfs(s[0],s[1],d[0],d[1],grid);
        
        
    }
}
