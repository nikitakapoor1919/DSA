class Solution {
    public int minDepth(TreeNode root) {
        LinkedList<TreeNode> queue=new LinkedList<>();
        int depth=0;
        if(root==null){
            return 0;
        }
        queue.addLast(root);
        while(!queue.isEmpty()){
            depth++;
            int n=queue.size();
            for(int i=0;i<n;i++){
                TreeNode rv=queue.poll();
                if(rv.left==null && rv.right==null){
                    return depth;
                }
                if(rv.left!=null){
                    queue.addLast(rv.left);
                }
                if(rv.right!=null){
                    queue.addLast(rv.right);
                }
            }
        }
        return depth;
    }
}
//****************************************************************************************************************************************************
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ld=minDepth(root.left);
        int rd=minDepth(root.right);
        
        if(ld==0||rd==0){
            return Math.max(ld,rd)+1;
        }
        else{
            return Math.min(ld,rd)+1;
        }
    }
}
