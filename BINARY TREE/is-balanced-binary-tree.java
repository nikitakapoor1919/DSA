class Solution {
    class Height{
        int ht;
    }
    public boolean isBalanced(TreeNode root) {
        return isBalanced(root,new Height());
    }
    private boolean isBalanced(TreeNode root,Height height){
        Height lh=new Height();
        Height rh=new Height();
        
        if(root==null){
            height.ht=0;
            return true;
        }
        boolean l=isBalanced(root.left,lh);
        boolean r=isBalanced(root.right,rh);
        
        height.ht=Math.max(lh.ht,rh.ht)+1;
        if( Math.abs(lh.ht-rh.ht)>=2){
            return false;
        }
        return l&&r;
    }
}
