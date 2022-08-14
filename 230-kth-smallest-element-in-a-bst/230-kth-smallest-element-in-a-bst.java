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
    public void f(TreeNode root, int k , int[] cnt){
        if(root == null)
            return;
        if(root!=null){
            f(root.left , k,cnt);
            cnt[0]++;
            if(cnt[0]==k){
                cnt[1] = root.val;
                return;
            }
            f(root.right,k,cnt);
        }
        
    }
    public int kthSmallest(TreeNode root, int k) {
        int cnt[] = new int[2];
        f(root , k , cnt);
        return cnt[1];
    }
}