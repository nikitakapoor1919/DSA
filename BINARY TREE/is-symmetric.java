class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }
    private boolean isSymmetric(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        else if(root1==null || root2==null){
            return false;
        }
        else if(root1.val!=root2.val){
            return false;
        }
        return isSymmetric(root1.left,root2.right) && isSymmetric(root1.right,root2.left);
    }
}
