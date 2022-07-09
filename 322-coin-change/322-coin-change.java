class Solution {
    int MAX=(int)10000000;
   
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int target = 0;target<=amount;target++){
            if(target%coins[0]==0) 
                dp[0][target] = target/coins[0];
            else
                dp[0][target] =MAX;
        }
        for(int ind=1;ind<coins.length;ind++){
            for(int target =0 ; target <=amount ;target++){
                int nottake= dp[ind-1][target];
                int take = MAX;
                if(coins[ind]<=target)
                    take = 1+dp[ind][target-coins[ind]];
                dp[ind][target] =Math.min(take,nottake);
            }
        }
        
        if( dp[coins.length-1][amount] >= MAX)
            return -1;
        return dp[coins.length-1][amount];
    }
}