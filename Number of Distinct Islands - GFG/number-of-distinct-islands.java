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

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int first;
    int second;
    Pair(int x,int y){
        first = x;
        second = y;
    }
}
class Solution {
    public String toString(int i,int j){
        return Integer.toString(i)+" "+Integer.toString(j);
    }
    public void dfs(int row,int col, int[][] vis,int[][] grid,int baserow,int basecol,ArrayList<String> ls){
        vis[row][col] = 1;
        ls.add(toString(row-baserow, col-basecol));
        int n = grid.length;
        int m = grid[0].length;
        int[] x = {-1,1,0,0};
        int[] y = {0,0,-1,1};
        
        for(int i=0;i<4;i++){
            int xx = row+ x[i];
            int yy = col + y[i];
            if(xx>=0 && xx<n && yy>=0 && yy<m && vis[xx][yy]== 0 && grid[xx][yy]==1){
                dfs(xx,yy,vis,grid,baserow,basecol,ls);
            }
        }
    }
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        
        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //not visited and a land
                if(vis[i][j]== 0 && grid[i][j]==1){
                    ArrayList<String> ls = new ArrayList<>();
                    dfs(i,j,vis,grid,i,j,ls);
                    set.add(ls);
                    //System.out.println(ls);
                }
            }
        }
        return set.size();
        
    }
}
