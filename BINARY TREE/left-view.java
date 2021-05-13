/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> list=new ArrayList<>();
        LinkedList<Node> queue=new LinkedList<>();
        
        if(root==null){
            return list;
        }
        
        queue.addLast(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                Node rv=queue.poll();
                if(i==0){
                    list.add(rv.data);
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
