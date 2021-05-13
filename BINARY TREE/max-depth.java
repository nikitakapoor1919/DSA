class Solution {
    public int maxDepth(TreeNode root) {
        // Base Case
       if(root==null){
           return 0;
       }
        int lHeight=maxDepth(root.left);
        int rHeight=maxDepth(root.right);
        int max=lHeight>rHeight ? lHeight ? rHeight;
        return max+1;
    }
}
