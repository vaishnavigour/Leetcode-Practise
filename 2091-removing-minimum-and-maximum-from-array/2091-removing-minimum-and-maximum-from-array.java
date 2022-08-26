class Solution {
    public int minimumDeletions(int[] nums) {
        int n= nums.length;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        int a=0,b=0;
        for(int i=0; i<n ;i++){
            if(mini> nums[i]){
                mini = nums[i];
                a=i;
            }
            if(maxi <nums[i]){
                maxi =nums[i];
                b = i;
            }
        }
        
        int ans=0;
        if(a>b)
            ans = Math.min(a+1,n-b);
        else
            ans = Math.min(b+1,n-a);
        
        ans = Math.min(ans , (a<b)? a+n-b+1:b+n-a+1);
        
        return ans;
    }
}