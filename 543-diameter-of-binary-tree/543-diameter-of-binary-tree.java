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
    public int diameterOfBinaryTree(TreeNode root) {
       if(root ==null)
           return 0;
        int d1 = height(root.left)+height(root.right);
       
        int d2 = diameterOfBinaryTree(root.left);
        int d3 = diameterOfBinaryTree(root.right);
         System.out.println(d1+" "+ d2+ " "+d3);
        return Math.max(d1 , Math.max(d2,d3));
    }
    int height (TreeNode root){
        if(root==null)
            return 0;
        int lh = height(root.left );
        int rh = height(root.right);
        return 1+Math.max(lh,rh);
    }
}