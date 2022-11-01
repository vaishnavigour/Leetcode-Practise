class Solution {
    public int majorityElement(int[] nums) {
       int cnt=1,ans=nums[0];
        for(int i=1;i<nums.length;i++){
            if(cnt==0){
                ans = nums[i];
                //cnt=1;
            }
            if(ans==nums[i]){
                cnt++;
            }else{
                cnt--;
            }
        }
        return ans;
    }
}