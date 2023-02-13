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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    int[] x = {-1,1,0,0};
    int[] y = {0,0,1,-1};
    public boolean isvalid(int i, int j , int r,int c){
        if(i>=0 && i<r && j>=0 && j<c){
            return true;
        }
        return false;
    }
    public void dfs(int r, int c, boolean[][] vis, int color, int ncolor,int[][] arr){
        vis[r][c] = true;
        arr[r][c] = ncolor;
        for(int i=0;i<4;i++){
            int row = r+x[i];
            int col = c+y[i];
            if(isvalid(row,col,arr.length,arr[0].length)){
                if(arr[row][col]==color && vis[row][col]==false){
                    dfs(row,col,vis,color,ncolor,arr);
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        if(image[sr][sc]==newColor) return image;
        int color = image[sr][sc];
        boolean[][] vis  = new boolean[image.length][image[0].length];
        dfs(sr,sc,vis,color,newColor,image);
        return image;
    }
}