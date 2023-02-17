//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    public boolean dfs(int node,int[] vis, int[] pathvis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        pathvis[node] = 1;
        for(int i=0;i< adj.get(node).size(); i++){
            if(vis[adj.get(node).get(i)]==0){
                if(dfs(adj.get(node).get(i),vis,pathvis,adj))
                    return true;
            }
            else if(pathvis[adj.get(node).get(i)]==1) {
                return true;
            }
        }
        pathvis[node] = 0;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[v];
        int[] pathvis = new int[v];
        for(int i=0; i<v; i++){
            if(vis[i]==0){
                if(dfs(i,vis,pathvis,adj)){
                    return true;
                }
            }
        }
        return false;
    }
}