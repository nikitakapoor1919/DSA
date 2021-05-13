/* use Queue, do Level by Level Traversal */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        
        if(root==null){
            return list;
        }
        
        queue.addLast(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                TreeNode rv=queue.poll();
                if(i==n-1){
                    list.add(rv.val);
                }
                if(rv.left!=null){
                    queue.addLast(rv.left);
                }
                if(rv.right!=null){
                     queue.addLast(rv.right);
                }
            }
        }
        return list;
    }
}
