//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Pair{
    int first;
    int second;
    Pair(int x, int y){
        first=x;
        second = y;
    }
}
class Solution
{
    public boolean indexExists(int i, int j ,int r, int c){
        if(i>=0 && i<r && j>=0 && j<c){
            return true;
        }
        return false;
    }
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length, m = grid[0].length;
        int[][] ans = new int[n][m];
        for(int[] i:ans)   Arrays.fill(i,-1);
        
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ans[i][j]=0;
                    q.add(new Pair(i,j));
                }
            }
        }
        
        int[] x = {-1,1,0,0};
        int[] y = {0,0,-1,1};
        
        int len =1;
        while(!q.isEmpty()){
            int size =q.size();
            while(size-->0){
                Pair it = q.poll();
                int ii = it.first;
                int jj = it.second;
                for(int k=0; k<4; k++){
                    int xx = ii + x[k];
                    int yy = jj + y[k];
                    
                    if(indexExists(xx,yy,n,m) && ans[xx][yy]==-1){
                        ans[xx][yy] = len;
                        q.add(new Pair(xx,yy));
                    }
                }
            }
            len++;
        }
        return ans;
    }
}