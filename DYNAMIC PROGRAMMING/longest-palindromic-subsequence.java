class Solution
{
    // A simple function to print leaf nodes of a binary tree
    void printLeaves(Node node,ArrayList<Integer> list)
    {
        if (node == null)
            return;

        printLeaves(node.left,list);
        // Print it if it is a leaf node
        if (node.left == null && node.right == null){
            list.add(node.data);
        }
        printLeaves(node.right,list);
    }

    // A function to print all left boundary nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(Node node,ArrayList<Integer> list)
    {
        if (node == null)
            return;

        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            list.add(node.data);
            printBoundaryLeft(node.left,list);
        }
        else if (node.right != null) {
            list.add(node.data);
            printBoundaryLeft(node.right,list);
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to print all right boundary nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(Node node,ArrayList<Integer> list)
    {
        if (node == null)
            return;

        if (node.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printBoundaryRight(node.right,list);
            list.add(node.data);
        }
        else if (node.left != null) {
            printBoundaryRight(node.left,list);
            list.add(node.data);
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

	ArrayList <Integer> printBoundary(Node node)
	{
	    ArrayList<Integer> list=new ArrayList<>();
	    
	   if (node == null)
            return list;
        list.add(node.data);

        // Print the left boundary in top-down manner.
        printBoundaryLeft(node.left,list);

        // Print all leaf nodes
        printLeaves(node.left,list);
        printLeaves(node.right,list);

        // Print the right boundary in bottom-up manner
        printBoundaryRight(node.right,list);
    
	    return list;
	}
}
