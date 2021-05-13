/* 
    
    class Node 
        int data;
        Node left;
        Node right;
 */
    class QNode{
        int hd;
        Node node;
        QNode(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public  void topViewTree(Node root) {
      LinkedList<QNode> queue=new LinkedList<>();
      TreeMap<Integer,Node> map=new TreeMap<>();
      
      queue.addLast(new QNode(root,0));
      while(!queue.isEmpty()){
          QNode rv=queue.poll();
          if(!map.containsKey(rv.hd)){
              map.put(rv.hd,rv.node);
          }
          if(rv.node.left!=null){
              queue.addLast(new QNode(rv.node.left,rv.hd-1));
          }
          if(rv.node.right!=null){
              queue.addLast(new QNode(rv.node.right,rv.hd+1));
          }
      }
      for(Map.Entry<Integer,Node> entry:map.entrySet()){
          System.out.print(entry.getValue().data+" ");
      }
   }
