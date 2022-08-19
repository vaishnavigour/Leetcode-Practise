class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n ; i++){
            for(int j=0; j<i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0 ; i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
        
    }
    public boolean check(int[][] a, int[][] b){
        int n =a.length;
        for(int i=0;i<n ; i++){
            for(int j=0; j<n; j++){
                if(a[i][j] != b[i][j])
                    return false;;
            }
        }
        return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
         int k = 3;
         if(check(mat,target)==true)
             return true;
         while(k-->0){
             rotate(mat);
             if(check(mat,target)==true)
                return true;

         }
        return false;
    }
}