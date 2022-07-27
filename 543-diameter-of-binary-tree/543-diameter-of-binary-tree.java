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
        int d[] = new int[1];
        height(root , d);
        return d[0];
    }
    int height (TreeNode root, int[] d){
        if(root==null)
            return 0;
        int lh = height(root.left ,d);
        int rh = height(root.right,d);
        d[0]  = Math.max(lh+rh , d[0]);
        return 1+Math.max(lh,rh);
    }
}