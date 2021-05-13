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
        List<List<Integer>> res=new ArrayList<>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        
        if(root==null){
            return res;
        }
        
        queue.addLast(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode rv=queue.poll();
                list.add(rv.val);
                if(rv.left!=null){
                    queue.addLast(rv.left);
                }
                if(rv.right!=null){
                    queue.addLast(rv.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
