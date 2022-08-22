class Solution {

    public int mergesort(int[] arr, int l, int h){
        if(l>=h)
            return 0;
        int m=(l+h)/2;
        int res=0;
        res += mergesort(arr,l,m);
        res += mergesort(arr,m+1, h);
        res += merge(arr,l,m,h);
        
        return res;
    }
    public int merge(int[] arr , int l ,int m , int h){
        
        int res=0;
        int j = m + 1; 
        for(int i = l;i<=m;i++) {
            while(j<=h && arr[i] > (2 *(long)arr[j])) {
                j++;
            }
            res += (j - (m+1));
        }
        
        int i=l;
        j =m+1;
        ArrayList<Integer> a= new ArrayList<Integer>();
        while(i<=m && j<=h){
            if(arr[i]<=arr[j]){
                a.add(arr[i++]);
            }
            else{
                a.add(arr[j++]);
            }
        }
        while(i<=m){
            a.add(arr[i++]);
        }
        while(j<=h){
            a.add(arr[j++]);
        }
        for( i = l; i<=h;i++) {
            arr[i] = a.get(i - l); 
        }
        return res;
    }
    public int reversePairs(int[] nums) {
        return mergesort(nums,0,nums.length-1);
    }
}