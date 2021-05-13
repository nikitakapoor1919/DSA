class Solution
{
    class Leaf{
        int lv;
    }
    boolean check(Node root)
    {
	    return check(root,0,new Leaf());
    }
    boolean check(Node root,int level,Leaf leaf){
        if(root==null){
            return true;
        }
        if(root.left==null && root.right==null){
            // Check if it first leafNode
            if(leaf.lv==0){
                leaf.lv=level;
                return true;
            }
            return (leaf.lv==level);
        }
        return check(root.left,level+1,leaf) && check(root.right,level+1,leaf);
    }
}
