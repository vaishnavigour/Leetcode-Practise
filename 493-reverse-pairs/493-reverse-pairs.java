class Solution {
    public int  merge(int[] arr,int l, int r ){
         if(l>=r)
            return 0;
        int cnt =0;
        int mid = (l+r)/2;
            
        cnt += merge(arr,l,mid);
        cnt += merge(arr,mid+1,r);
        cnt += countandmerge(arr,l,mid,r);
            
        return cnt;
    }
    public int countandmerge(int[] arr,int l , int mid, int r){
        int count =0;
        int j = mid+1,i=l;
        for(i = l;i<=mid;i++) {
            while(j<=r && arr[i] > (2 *(long)arr[j])) {
                j++;
            }
            count  += (j - (mid+1));
        }
        i =l;
        j=mid+1 ;
        ArrayList<Integer> a= new ArrayList<Integer>();
        while(i<=mid && j<=r){
            if(arr[i]<=arr[j]){
                a.add(arr[i++]);
            }
            else{
                a.add(arr[j]);
                j++;
            }
        }
        while(i<=mid){
            a.add(arr[i++]);
        }
        while(j<=r){
            a.add(arr[j++]);
        }
        for(i=l;i<=r; i++){
            arr[i] =a.get(i-l);
        }
        return count;
        
    }
    public int reversePairs(int[] nums) {
        return merge(nums , 0,nums.length-1);
    }
}