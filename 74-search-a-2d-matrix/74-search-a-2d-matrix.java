class Solution {
    public boolean search(int[] arr,int target){
        int l =0 , r =arr.length-1;
        while(l<=r){
            int mid = (l+r)>>1;
            if(arr[mid] == target)
                return true;
            else if(arr[mid]<target)
                l = mid+1;
            else
                r = mid-1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length , n = matrix[0].length -1 , first = 0;
        while(first<m){
            if(matrix[first][0] <= target && matrix[first][n] >= target)
                return search(matrix[first] ,target );
            else
                first++;
        }
        return false;
    }
}