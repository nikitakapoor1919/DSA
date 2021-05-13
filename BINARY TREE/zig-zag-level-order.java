class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        queue.addLast(root);
        boolean reverse=false;
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int n=queue.size();
            for(int i=0;i<n;i++){
                TreeNode rv=queue.poll();
                list.add(rv.val);
                if(rv.left!=null){
                    queue.addLast(rv.left);
                }
                if(rv.right!=null){
                    queue.addLast(rv.right);
                }
            }
            if(reverse){
                Collections.reverse(list);
            }
            reverse=!reverse;
            res.add(list);
        }
        return res;
    }
}
