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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>list=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<TreeNode>();
        if(root==null)
            return list;
        queue.add(root);
        while(queue.isEmpty()==false){
            int size=queue.size();
            List<Integer> list1 = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                list1.add(curr.val);
                if(curr.left!=null)
               queue.add(curr.left);
               if(curr.right!=null)
               queue.add(curr.right);
            }
            list.add(list1);
        }
        return list;
    }
}