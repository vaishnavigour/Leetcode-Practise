//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int first;
    int second;
    Pair(int x,int y){
        first = x;
        second = y;
    }
}
class Solution {
    // Function to find the number of islands.
    public boolean isvalid(int row,int col, int m, int n){
        if(row>=0 && row<m && col>=0 && col<n)
        return true;
        return false;
    }
    public int numIslands(char[][] grid) {
        if(grid.length==0 || grid[0].length==0){
            return 0;
        }
        int r = grid.length,c = grid[0].length;
        Queue<Pair> q = new LinkedList<Pair>();
        int[] x = {-1,1,0,0,1,1,-1,-1};
        int[] y = {0,0,-1,1,-1,1,-1,1};
        int ans =0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]!='1')
                    continue;
                q.add(new Pair(i,j));
                ans++;
                while(!q.isEmpty()){
                    Pair it = q.poll();
                    for(int k=0;k<8;k++){
                        int row = it.first+x[k];
                        int col= it.second+y[k];
                        if(isvalid(row,col,r,c)&& grid[row][col]=='1'){
                            grid[row][col] = '0';
                            q.add(new Pair(row,col));
                        }
                    }
                }
            }
        }
       
        return ans;    // Code here
    }
}