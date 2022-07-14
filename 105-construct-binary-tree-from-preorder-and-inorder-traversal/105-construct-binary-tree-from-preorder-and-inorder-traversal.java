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
    TreeNode buildTree(int[] preorder , int prstart , int prend, int[] inorder , int instart, int inend, HashMap<Integer,Integer> map){
        if(prstart>prend || instart>inend)
            return null;
        TreeNode root = new TreeNode(preorder[prstart]);
        int inroot = map.get(root.val);
        int numsleft = inroot - instart;
        root.left = buildTree(preorder , prstart+1,prstart + numsleft ,inorder ,instart,inroot-1, map );
        root.right = buildTree(preorder , prstart+numsleft+1, prend , inorder , inroot+1, inend , map);
        return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = buildTree(preorder,0 , preorder.length-1, inorder, 0, inorder.length-1,map );
        return root;
    }
}