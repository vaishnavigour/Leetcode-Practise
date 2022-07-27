/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int func(TreeNode root , int[] maxpath){
        //base case
        if(root == null)
            return 0;
        
        int leftsum = func(root.left , maxpath);
        int rightsum = func(root.right , maxpath);
         if(leftsum <0)
            leftsum =0;
        if(rightsum < 0)
            rightsum =0;
        maxpath[0]  = Math.max(maxpath[0] , leftsum+rightsum +root.val);
        return Math.max(leftsum , rightsum)+root.val;
        
        
    }
    
    public int maxPathSum(TreeNode root) {
        int maxpath[] = new int[1];
        maxpath[0] = Integer.MIN_VALUE;
        func(root , maxpath);
        return maxpath[0];
    }
}