/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if(root ==null)
            return null;
        TreeNode curr = root;
        if(curr.val<a.val && curr.val<b.val)
            return lowestCommonAncestor(curr.right , a,b);
        else if(curr.val>a.val && curr.val>b.val)
            return lowestCommonAncestor(curr.left , a,b);
        return curr;
    }
}