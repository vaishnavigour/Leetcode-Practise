class Solution {
    public int findDuplicate(int[] nums) {
         int len = nums.length;
        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx] < 0) {
                return idx;
            }
            nums[idx] = -nums[idx];
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