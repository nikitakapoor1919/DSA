/*
    Step 1: Create two empty Stacks i.e stack1 and stack2. 
    Step 2: Add root in stack1.
    Step 3: If Stack1 is not empty.
            Step 3.1: Pop Node.
            Step 3.2: Add pop Node in stack2.
            Step 3.3: If poppedNode.left !=null then push in stack.
            Step 3.4: If poppedNode.right !=null then push in stack.
    Step 4: If Stack2 is not empty.
            Step 4.1: Pop Node.
            Step 4.2: Add pop Node value in list.
*/

public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        //Step 1: Create two empty Stacks i.e stack1 and stack2.
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        
        //Step 2: Add root in stack1.
        stack1.push(root);
        //Step 3: If Stack1 is not empty
        while(!stack1.isEmpty()){
            //Step 3.1: Pop Node.
            TreeNode rv=stack1.pop();
            //Step 3.2: Add pop Node in stack2.
            stack2.push(rv);
            //Step 3.3: If poppedNode.left !=null then push in stack.
            if(rv.left!=null){
                stack1.push(rv.left);
            }
            // Step 3.4: If poppedNode.right !=null then push in stack.
            if(rv.right!=null){
                stack1.push(rv.right);
            }
        }
        //Step 4: If Stack2 is not empty
        while(!stack2.isEmpty()){
            //Step 4.1: Pop Node.
            TreeNode rv=stack2.pop();
            //Step 4.2: Add pop Node value in list.
            list.add(rv.val);
        }
        return list;
    }
}
