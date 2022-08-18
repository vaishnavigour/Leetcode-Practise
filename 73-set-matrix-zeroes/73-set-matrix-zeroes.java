class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean flag = false;
        for(int i =0; i<row ;i++){
            if(matrix[i][0] ==0)
                flag =true;
            for(int j=1;j<col;j++){
                if(matrix[i][j] ==0){
                    matrix[i][0] =0;
                    matrix[0][j] =0;
                }
            }
        }
       
        for(int i=1;i<col;i++){
            for(int j=1;j<row;j++){
                if(matrix[0][i] ==0 || matrix[j][0] ==0){
                    matrix[j][i]=0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        
        if(flag){
            for(int i=0;i<row;i++){
                matrix[i][0]=0;
            }
            
        }

    }
}