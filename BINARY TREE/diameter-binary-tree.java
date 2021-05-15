class Solution {
    class Height{
        int ht;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        // We need to return edges and edges=n-1
         return diameterOfBinaryTree(root,new Height())-1;
    }
    public int diameterOfBinaryTree(TreeNode root,Height height){
        if(root==null){
            height.ht=0;
            return 0;
        }
        Height lh=new Height();
        Height rh=new Height();
        int lDia=diameterOfBinaryTree(root.left,lh);
        int rDia=diameterOfBinaryTree(root.right,rh);
        
        height.ht=Math.max(lh.ht,rh.ht)+1;
        
        return Math.max(lh.ht+rh.ht+1,Math.max(lDia,rDia));
    }
}

********************************************************************
class Solution {
    class DiaPair{
        int dia=0;
        int ht=-1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).dia;
    }
    private DiaPair helper(TreeNode root){
        if(root==null){
            return new DiaPair();
        }
        DiaPair ldp=helper(root.left);
        DiaPair rdp=helper(root.right);
        
        DiaPair sdp=new DiaPair();
        int ld=ldp.dia;
        int rd=rdp.dia;
        int sd=ldp.ht+rdp.ht+2;
        
        sdp.dia=Math.max(sd,Math.max(ld,rd));
        sdp.ht=Math.max(ldp.ht,rdp.ht)+1;
        
        return sdp;
    }
}
