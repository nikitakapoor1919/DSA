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
