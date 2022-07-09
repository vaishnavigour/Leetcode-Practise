class Solution {
    int MAX=(int)10000000;
   
    public int coinChange(int[] coins, int amount) {
        int[] prev = new int[amount+1];
         int[] curr = new int[amount+1];
        for(int target = 0;target<=amount;target++){
            if(target%coins[0]==0) 
                prev[target] = target/coins[0];
            else
                prev[target] =MAX;
        }
        for(int ind=1;ind<coins.length;ind++){
            for(int target =0 ; target <=amount ;target++){
                int nottake= prev[target];
                int take = MAX;
                if(coins[ind]<=target)
                    take = 1+curr[target-coins[ind]];
                curr[target] =Math.min(take,nottake);
            }
            for(int i=0;i<=amount;i++)
                prev[i] = curr[i];
        }
        
        if( prev[amount] >= MAX)
            return -1;
        return prev[amount];
    }
}