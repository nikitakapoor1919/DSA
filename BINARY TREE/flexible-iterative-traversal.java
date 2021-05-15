class Solution {
    class Pair{
        TreeNode node;
        boolean sd;
        boolean ld;
        boolean rd;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Pair> stack=new Stack<>();
        
        if(root==null){
            return list;
        }
        Pair np=new Pair();
        np.node=root;
        stack.push(np);
        while(!stack.isEmpty()){
            Pair tp=stack.peek();
            if(tp.node==null){
                stack.pop();
                continue;
            }
            if(tp.sd==false){
                list.add(tp.node.val);
                tp.sd=true;
            }
            else if(tp.ld==false){
                Pair lp=new Pair();
                lp.node=tp.node.left;
                stack.push(lp);
                tp.ld=true;
            }else if(tp.rd==false){
                Pair rp=new Pair();
                rp.node=tp.node.right;
                stack.push(rp);
                tp.rd=true;
            }
            else{
                stack.pop();
            }
        }
        return list;
    }
}
