class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int l_count =0;
        for(int i=0;i< nums.length -1; i++){
            if(nums[i]>nums[i+1])
                l_count++;
        }
        int g_count =countGlobalInversion(nums , 0 , nums.length-1);
        if(l_count == g_count)
            return true;
        return false;
        
    }
    
    int countGlobalInversion(int[] arr, int l , int r ){
            int res = 0 ;
            if(l<r){
                int m = l + (r-l)/2;
                res = res + countGlobalInversion(arr, l , m);
                res = res + countGlobalInversion(arr,m+1 , r);
                res = res + countandmerge(arr , l,m,r);
            }
        return res;
    }
    
    int countandmerge(int[] arr, int l , int m , int r){
            //copy all the elements of left half in array left[] 
            int n1 = m-l+1;
            int n2 = r-m;
            int left[] = new int[n1];
            int right[] = new int[n2];
            for(int i=0 ; i<n1 ; i++){
                left[i] = arr[i+l];
            }
            for(int i=0 ; i<n2 ; i++){
                right[i] = arr[i+m+1];
            }
            
            int res =0 , i=0,j=0,k=l;
            
            while(i<n1 && j<n2){
                if(left[i]<=right[j]){
                    arr[k] = left[i];
                    i++;
                }
                else{
                    arr[k] = right[j];
                    j++;
                    res = res+ n1 -i;
                }
                k++;   
            }
            while(i<n1){
                arr[k] = left[i];
                i++;
                k++;
                
            }
            while(j<n2){
                arr[k] = right[j];
                k++;
                j++;
            }
            return res;
     }
}