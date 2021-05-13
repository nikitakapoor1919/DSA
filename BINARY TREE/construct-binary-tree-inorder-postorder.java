class Solution {
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder.length-1,0,inorder.length-1,inorder,postorder);
    }
    private TreeNode helper(int postStart,int inStart,int inEnd,int[] inorder,int[] postorder){
        if(inStart>inEnd){
            return null;
        }
        TreeNode root=new TreeNode(postorder[postStart]);
        int inIndex=map.get(postorder[postStart]);
        
        root.right=helper(postStart-1,inIndex+1,inEnd,inorder,postorder);
        root.left=helper(postStart+inIndex-inEnd-1,inStart,inIndex-1,inorder,postorder);
        
        return root;
    }
}
