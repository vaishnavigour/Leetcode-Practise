class Solution {
    public int findways(int[] nums , int target,int n){
        int[][] dp = new int[n][target+1];
        if(nums[0]==0)
            dp[0][0]=2;
        else
            dp[0][0] =1;
        
        if(nums[0] !=0 && nums[0]<=target)
            dp[0][nums[0]] =1;
        
        for(int ind =1;ind<n;ind++){
            for(int tar =0;tar<=target;tar++){
                int nottake = dp[ind-1][tar];
                int take =0;
                if(nums[ind]<=tar)
                    take = dp[ind-1][tar-nums[ind]];
                
                dp[ind][tar] = take+nottake;
            }
        }
        return dp[n-1][target];
            
    }
    
    
    public int findTargetSumWays(int[] nums, int target) {
        //basically the question says count partitions whose difference is the given target
        //exactly the same question
        int n = nums.length;
        int totalsum =0;
        for(int i=0;i<n;i++)
            totalsum+=nums[i];
        //check for edge cases
        if(totalsum-target<0 || (totalsum-target)%2==1)
            return 0;
        return findways(nums,(totalsum-target)/2,n);
    }
}