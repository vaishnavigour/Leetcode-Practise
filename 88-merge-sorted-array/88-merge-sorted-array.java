class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m-1 , j = n-1;
        for(int k = m+n-1 ; k>=0; k-- ){
            if(i>=0 && j>=0){
                if(arr1[i]>arr2[j]){
                    arr1[k] = arr1[i];
                    i--;
                }
                else{
                    arr1[k]= arr2[j];
                    j--;
                }
            }
            else if(i<0 && j>=0){
                arr1[k] = arr2[j--];
            }
            else
                arr1[k] = arr1[i--];
        }
    }
}