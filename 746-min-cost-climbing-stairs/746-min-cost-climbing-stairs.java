class Solution {
    public int f(int ind , int[] arr,int[] dp){
        if(ind==0 || ind==1)
            return arr[ind];
        if(dp[ind] != -1)
            return dp[ind];
        int s1 = arr[ind]+f(ind-1,arr,dp);
        int s2 = arr[ind]+f(ind-2,arr,dp);
        return dp[ind]=Math.min(s1,s2);
    }
   
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(f(cost.length-1,cost,dp),f(cost.length-2,cost,dp));
    }
}