//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int node;
    int distance;
    Pair(int v, int d){
        node =v;
        distance = d;
    }
}
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0],edge[2]));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,(int)(1e9));
        int[] memo = new int[n+1];
        for(int i=0;i<n+1;i++){
            memo[i] = i;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> a.distance-b.distance);
        
        dist[1]=0;
        pq.add(new Pair(1,0));
        while(pq.size()!=0){
            int node = pq.peek().node;
            int dis = pq.peek().distance;
            pq.poll();
            for(int i=0;i<adj.get(node).size();i++){
                int newNode = adj.get(node).get(i).node;
                int edgeWeight = adj.get(node).get(i).distance;
                
                if(dis+edgeWeight<dist[newNode]){
                    dist[newNode] = dis+edgeWeight;
                    memo[newNode] = node;
                    pq.add(new Pair(newNode,dist[newNode]));
                }
            }
        }
        // for(int k:memo)
        // System.out.println(k+" ");
        
        List<Integer> ls = new ArrayList<>();
        if(dist[n] == (int)(1e9)){
            ls.add(-1);
            return ls;
        }
        ls.add(n);
        int i=n;
        while(memo[i]!=i){
            ls.add(0,memo[i]);
            i=memo[i];
        }
        
        return ls;
        
        
        
    }
}