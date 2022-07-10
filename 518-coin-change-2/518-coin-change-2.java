class Solution {
    int f(int ind,int target ,int[] arr , int[][] dp){
        //base case
        if(ind==0){
            if(target%arr[0]==0)
                return 1;
            return 0;
        }
        
        if(dp[ind][target] != -1)
            return dp[ind][target];
        
        //recurrences
        int nottake = f(ind-1 ,target , arr,dp);
        int take =0;
        if(arr[ind]<=target)
            take = f(ind , target-arr[ind] ,arr,dp);
        
        return dp[ind][target] = take+nottake;
        
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return f(n-1,amount , coins,dp);
    }
}