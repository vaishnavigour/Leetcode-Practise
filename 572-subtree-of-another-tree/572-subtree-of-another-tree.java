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
        if(r1==null || r2==null)
            return r1 ==null && r2==null;
        if(r1.val == r2.val){
            return check(r1.left , r2.left) && check(r1.right , r2.right);
        }
        return false;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         if(root!=null){
            if(check(root,subRoot)==true)
                return true;
        return(isSubtree(root.left , subRoot)|| isSubtree(root.right, subRoot));
         }
        return false;
    }
    
        
}