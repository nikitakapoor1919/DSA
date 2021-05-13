class Solution {
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(0,0,inorder.length-1,preorder,inorder);
    }
    private TreeNode helper(int preStart,int inStart,int inEnd,int[] preorder,int[] inorder){
        if(inStart>inEnd){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        
        int inIndex=map.get(preorder[preStart]);
        
        root.left=helper(preStart+1,inStart,inIndex-1,preorder,inorder);
        root.right=helper(preStart+inIndex-inStart+1,inIndex+1,inEnd,preorder,inorder);
        
        return root;
    }
}
