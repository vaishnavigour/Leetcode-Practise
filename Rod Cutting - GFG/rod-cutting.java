//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int func(int index, int len,int[] arr,int[][] dp){
        if(index==0){
            return len*arr[0];
        }
        if(dp[index][len] != -1)    return dp[index][len];
        int nottake = 0+func(index-1,len,arr,dp);
        int take = Integer.MIN_VALUE;
        if(index+1<= len){
            take = arr[index]+func(index,len-index-1,arr,dp);
        }
        return dp[index][len]=Math.max(take,nottake);
                
    }
    public int cutRod(int price[], int n) {
        int[][] dp = new int[price.length][n+1];
        for(int[] i: dp) Arrays.fill(i,-1);
        
        return func(price.length-1,n,price,dp);
    }
}