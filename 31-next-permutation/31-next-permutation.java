class Solution {
    public void swap(int r, int l ,int[] a){
        int temp = a[r];
        a[r] = a[l];
        a[l] = temp;
        return;
    }
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j= nums.length-1;
            while(j>i && nums[j]<=nums[i])
                j--;
            swap(i,j,nums);
        }
        Arrays.sort(nums , i+1,nums.length);
    }
}