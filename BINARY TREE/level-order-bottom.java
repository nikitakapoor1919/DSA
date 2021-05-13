class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode poll=queue.poll();
                list.add(poll.val);
                if(poll.left!=null){
                    queue.addLast(poll.left);
                }
                if(poll.right!=null){
                    queue.addLast(poll.right);
                }
            }
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }
}
