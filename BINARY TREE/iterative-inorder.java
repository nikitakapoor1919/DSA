/*
    Step 1: Create empty Stack. 
    Step 2: Intialize current Node as Root.
    Step 3: Push current in stack and set current=current.left.
    Step 4: if current is null.
            Step 4.1: Check if Stack empty break .
            Step 4.2: Pop Node.
            Step 4.3: Add pop Node value in List
            Step 4.4: Set current=poppedNode.right repeat step 3
    
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        //Step 1: Create empty Stack
        Stack<TreeNode> stack=new Stack<>();
        
        //Step 2: Intialize current Node as Root
        TreeNode current=root;
        while(true){
            //Step 3: Push current in stack and set current=current.left
            if(current!=null){
                stack.push(current);
                current=current.left;
            }
            //Step 4: if current is null
            else{
                //Step 4.1: Check if Stack empty break 
                if(stack.isEmpty()){
                    break;
                }
                //Step 4.2: Pop Node
                TreeNode rv=stack.pop();
                //Step 4.3: Add pop Node value in List
                list.add(rv.val);
                //Step 4.4: Set current=poppedNode.right repeat step 3
                current=rv.right;
            }
        }
        return list;
    }
}
