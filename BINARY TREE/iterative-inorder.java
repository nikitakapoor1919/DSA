/*
    Step 1: Create empty Stack. 
    Step 2: Add root in stack.
    Step 3: If Stack is not empty
            Step 3.1: Pop Node.
            Step 3.2: Add pop Node value in List.
            Step 3.3: If poppedNode.right !=null then push in stack.
            Step 3.4: If poppedNode.left !=null then push in stack.
*/

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        //Step 1: Create empty Stack. 
        Stack<TreeNode> stack=new Stack<>();
        
        //Step 2: Add root in stack.
        stack.push(root);
        //Step 3: If Stack is not empty
        while(!stack.isEmpty()){
            //Step 3.1: Pop Node.
            TreeNode rv=stack.pop();
            //Step 3.2: Add pop Node value in List.
            list.add(rv.val);
            //Step 3.3: If poppedNode.right !=null then push in stack.
            if(rv.right!=null){
                stack.push(rv.right);
            }
            //Step 3.4: If poppedNode.left !=null then push in stack.
            if(rv.left!=null){
                stack.push(rv.left);
            }
        }
        return list;
    }
}
