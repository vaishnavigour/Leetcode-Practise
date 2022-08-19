class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0; i<nums.length;i++){
            int x = Math.abs(nums[i]);
            if(nums[x]<0)
                return x;
            else
                nums[x] = -nums[x];
        }
        return 0;
    }
    // public int findDuplicate(int[] nums) {
    //     int slow =nums[0];
    //     int fast = nums[0];
    //     do{
    //         slow =nums[slow];
    //         fast = nums[nums[fast]];
    //     }while(fast!= slow);
    //     fast = nums[0];
    //     while(fast!=slow){
    //         slow = nums[slow];
    //         fast = nums[fast];
    //     }
    //     return fast;
    // }
}