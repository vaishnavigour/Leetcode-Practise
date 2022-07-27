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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode>  q= new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root ==null)
            return ans;
        q.add(root);
        while(!q.isEmpty()){
            int levelnum = q.size();
            List<Integer> sub = new ArrayList<Integer>();
            for(int i=0; i<levelnum ; i++){
                TreeNode curr = q.poll();
                sub.add(curr.val);
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right !=null)
                    q.add(curr.right);
                
            }
            //arraylist.add(index , num) this will add an element in the array at an specific index
            ans.add(0 , sub);
        }
        return ans;
    }
}