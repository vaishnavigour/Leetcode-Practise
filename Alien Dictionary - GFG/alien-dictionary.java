//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis,Stack<Integer> st){
        vis[node] = 1;
        for(int i : adj.get(node)){
            if(vis[i]==0){
                dfs(i,adj,vis,st);
            }
        }
        st.push(node);
    }
    public String findOrder(String [] dict, int n, int k)
    {
        //k -- vertices
        ArrayList<ArrayList<Integer>>  adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<k; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<n-1;i++){
            String s = dict[i];
            String t = dict[i+1];
            int j=0,l=0;
            while(j<s.length() && l<t.length()){
                if(s.charAt(j)!= t.charAt(l)){
                    adj.get(s.charAt(j)-'a').add(t.charAt(l)-'a');
                    break;
                }else{
                    j++;
                    l++;
                }   
            }
        }
        int[] topo = new int[k];
        int[] vis = new int[k];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<k;i++){
            if(vis[i]==0){
                dfs(i,adj,vis,st);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append((char)(st.pop()+'a'));
        }
        return sb.toString();
        
    }
}