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
    
    List<TreeNode> list=new ArrayList<>();
    HashMap<String,Integer> map=new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root);
        return list;
    }
    private String helper(TreeNode root){
        if(root==null){
            return "*";
        }
        String ls=helper(root.left);
        String rs=helper(root.right);
        
        String checkdup=root.val+"-"+ls+"-"+rs;
        map.put(checkdup,map.getOrDefault(checkdup,0)+1);
        if(map.get(checkdup)==2){
            list.add(root);
        }
        return checkdup;
    }
}
