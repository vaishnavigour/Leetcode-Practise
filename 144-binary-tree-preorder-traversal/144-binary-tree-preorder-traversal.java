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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(root ==null)
            return ans;
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode curr = root;
        while(curr!=null || !(st.isEmpty())){
            while(curr!=null){
                ans.add(curr.val);
                if(curr.right!=null)
                    st.push(curr.right);
                curr = curr.left;
            }
            if(!st.isEmpty())
                curr = st.pop();
        }
        return ans;
        
    }
    
}