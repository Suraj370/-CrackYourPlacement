/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushToLeft(root);
    }
    
    public int next() {
        TreeNode root = st.pop();
        pushToLeft(root.right);
        return root.val;
    }
    
    public boolean hasNext() {
         if(st.empty())
             return false;
        return true;
            
    }
    
    public void pushToLeft(TreeNode root){
        if(root != null){
            st.push(root);
            pushToLeft(root.left);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */