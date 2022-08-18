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
    public boolean check(TreeNode r1 , TreeNode r2){
        if(r1 ==null && r2==null)
            return true;
        if(r2==null || r1==null)
            return false;
        if(r1.val == r2.val){
        boolean left = check(r1.left , r2.left);
        boolean right = check(r1.right , r2.right);
            return left &&right;
        }
        return false;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         if(root!=null){
            if(check(root,subRoot)==true)
                return true;
            boolean l = isSubtree(root.left , subRoot);
            boolean r = isSubtree(root.right, subRoot);
             return (l || r);
         }
        return false;
    }
    
        
}