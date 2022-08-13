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
    public boolean f(TreeNode root , int t,int sum){
        if(root==null)
            return false;
        sum += root.val;
        if(root.left == null && root.right == null){
            if(sum ==t)
                return true;
            return false;
        } 
        
        boolean left = f(root.left,t,sum);
        boolean right = f(root.right,t,sum);
        return left||right;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum =0;
        return f(root,targetSum, sum);
    }
}