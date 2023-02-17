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
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[v];
        for(int i=0;i<v;i++){
            for(int j: adj.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int index=0;
        ArrayList<Integer> ls = new ArrayList<>();
        while(!q.isEmpty()){
            Integer it = q.poll();
            ls.add((int)it);
            
            for(int i=0;i<adj.get(it).size();i++){
                indegree[adj.get(it).get(i)]--;
                if(indegree[adj.get(it).get(i)]==0){
                    q.add(adj.get(it).get(i));
                }
            }
        }
        if(ls.size() !=v)return true;
        return false;
    }
}