//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

class Pair{
    int v;
    int wt;
    Pair(int a,int b){
        v=a;
        wt=b;
    }
}
//User function Template for Java
class Solution {
    public void dfs(int node,int[] vis, Stack<Integer> st,List<List<Pair>> ls){
        vis[node]=1;
        for(int i=0;i<ls.get(node).size();i++){
            if(vis[ls.get(node).get(i).v]==0){
                dfs(ls.get(node).get(i).v,vis,st,ls);
            }
        }
        st.push(node);
    }
	public int[] shortestPath(int n,int m, int[][] edges) {
		
	    //create adj list of pair (i,edgeweight)
	    List<List<Pair>> ls= new ArrayList<>();
	    for(int i=0;i<n;i++){
	        ls.add(new ArrayList<Pair>());
	    }
	    for(int i=0;i<m;i++){
	        ls.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
	    }
	    
	    //finding topological sort
	    Stack<Integer> st = new Stack<>();
	    int[] vis = new int[n];
	    for(int i=0;i<n;i++){
	        if(vis[i]==0){
	            dfs(i,vis,st,ls);
	        }
	    }
	   //finding shortest path 
	    int[] path = new int[n];
	    Arrays.fill(path,100000);
	    path[0] =0;
	    while(!st.isEmpty()){
	        int node =st.pop();
	        int pweight = path[node];
	        for(int i=0;i<ls.get(node).size(); i++){
	            path[ls.get(node).get(i).v] = Math.min(path[ls.get(node).get(i).v],pweight+ls.get(node).get(i).wt);
	        }
	    }
	    for(int i=0;i<n;i++){
	        if(path[i]==100000)
	            path[i]=-1;
	    }
	    return path;
	    
	}
}