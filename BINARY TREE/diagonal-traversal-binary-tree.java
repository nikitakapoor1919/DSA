/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    class Node{
         int dd;
         TreeNode node;
         Node(TreeNode node,int dd){
             this.dd=dd;
             this.node=node;
         }
     }

    public ArrayList<Integer> solve(TreeNode root) {
           Stack<Node> stack=new Stack<>();
           HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
           
           ArrayList<Integer> list=new ArrayList<>();
           
           stack.push(new Node(root,0));
           while(!stack.isEmpty()){
               Node rv=stack.pop();
               ArrayList<Integer> tmp;
               if(!map.containsKey(rv.dd)){
                   tmp=new ArrayList<Integer>();
                   tmp.add(rv.node.val);
                   map.put(rv.dd,tmp);
               }
               else{
                   tmp=map.get(rv.dd);
                   tmp.add(rv.node.val);
                   map.put(rv.dd,tmp);
               }
               if(rv.node.right!=null){
                   stack.push(new Node(rv.node.right,rv.dd));
               }
               if(rv.node.left!=null){
                   stack.push(new Node(rv.node.left,rv.dd+1));
               }
           }
           
           for(Map.Entry<Integer,ArrayList<Integer>> x:map.entrySet()){
               ArrayList<Integer> tmp=x.getValue();
               for(int val:tmp){
                   list.add(val);
               }
           }
           return list;

    }
}
