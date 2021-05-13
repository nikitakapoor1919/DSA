class Tree
{
    class QNode{
        int hd;
        Node node;
        QNode(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }

    public ArrayList <Integer> bottomView(Node root)
    {
        LinkedList<QNode> queue=new LinkedList<>();
        TreeMap<Integer,Node> map=new TreeMap<>();
        
        ArrayList<Integer> list=new ArrayList<>();
        
        if(root==null){
            return list;
        }
        
        queue.addLast(new QNode(root,0));
        while(!queue.isEmpty()){
            QNode rv=queue.poll();
            map.put(rv.hd,rv.node);
            if(rv.node.left!=null){
                queue.addLast(new QNode(rv.node.left,rv.hd-1));
            }
            if(rv.node.right!=null){
                queue.addLast(new QNode(rv.node.right,rv.hd+1));
            }
        }
        for(var x:map.entrySet()){
            list.add(x.getValue().data);
        }
        return list;
    }
}
