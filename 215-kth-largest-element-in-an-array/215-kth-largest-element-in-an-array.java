class Solution {
    int partition(int l , int r , int[] nums){
        int i = l-1;
        for(int j = l; j<=r-1 ;j++){
            if(nums[j]< nums[r]){
                i++;
                int temp = nums[j];
                nums[j]= nums[i];
                nums[i] =temp;
            }    
        }
        int temp = nums[i+1];
        nums[i+1] = nums[r];
        nums[r] = temp;
        return i+1;
    }
  
    public int findKthLargest(int[] nums, int k) {
        k = nums.length-k ;
        int l=0 , r = nums.length-1;
        while(l<=r){
            int pos = partition(l,r,nums);
            if(pos==k)
                return nums[pos];
            else if(pos > k)
                r = pos-1;
            else
                l= pos+1;
        }
        return -1;
    }   
}