class Solution {
    int MAX=(int)10000000;
    public int f(int ind , int target, int[] coins,int[][] dp){
        if(ind==0){
            if(target%coins[0] ==0)
                return target/coins[0];
           return MAX;
        }
        if(dp[ind][target]!= -1)
            return dp[ind][target];
        int nottake= 0+f(ind-1,target,coins,dp);
        int take = MAX;
        if(coins[ind]<=target)
            take = 1+f(ind,target-coins[ind],coins,dp);
        dp[ind][target] =Math.min(take,nottake);
        return Math.min(take,nottake);
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int row[] : dp)
            Arrays.fill(row,-1);
        int ans =f(coins.length-1,amount , coins,dp);
        if(ans >= MAX)
            return -1;
        
        return ans;
    }
}