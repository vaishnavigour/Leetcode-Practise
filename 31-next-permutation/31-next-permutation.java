class Solution {
    public void swap(int r, int l ,int[] a){
        int temp = a[r];
        a[r] = a[l];
        a[l] = temp;
        return;
    }
    public void nextPermutation(int[] nums) {
        boolean c = true;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]<nums[i+1])
                c = false;
        }
        if(c==true){
            Arrays.sort(nums);
            return;
        }
        
        int r = nums.length-1;
        while(r>0){
            if(nums[r]>nums[r-1])
                break;
            else
                r--;
        }
        r=r-1;
        for(int k=nums.length-1 ; k>r;k--){
            if(nums[k]>nums[r]){
                swap(k,r,nums);
                break;
            }
        }
        Arrays.sort(nums , r+1,nums.length);
    }
}