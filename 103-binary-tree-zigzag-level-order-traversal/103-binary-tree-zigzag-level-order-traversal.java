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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
            return ans;
        boolean flag = true;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> subList = new ArrayList<>();
            for(int i=0;i<size ; i++){
                TreeNode curr= q.poll();
                if(flag == true)
                    subList.add(curr.val);
                else
                    subList.add(0,curr.val);
                
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right !=null)
                    q.add(curr.right);
            }
            flag = !flag;
            ans.add(subList);
            
        }
        return ans;
    }
}