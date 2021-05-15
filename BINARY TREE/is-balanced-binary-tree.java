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
//*********************************************************************************************************************************************************
class Solution {
    class BalPair{
        boolean isBal=true;
        int ht=-1;
    }
    public boolean isBalanced(TreeNode root) {
       return helper(root).isBal;
    }
    private BalPair helper(TreeNode root) {
        if(root==null){
            return new BalPair();
        }
        BalPair lbp=helper(root.left);
        BalPair rbp=helper(root.right);
        
        BalPair sbp=new BalPair();
        
        boolean lb=lbp.isBal;
        boolean rb=rbp.isBal;
        int sb=lbp.ht-rbp.ht;
        
        if(lb && rb && sb>=-1 && sb<=1){
            sbp.isBal=true;
        }
        else{
            sbp.isBal=false;
        }
        sbp.ht=Math.max(lbp.ht,rbp.ht)+1;
        
        return sbp;
        
    }
}
