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
class Solution {
    public boolean isBalanced(TreeNode root) {
        return cbt(root).getKey();
    }
    
    Pair<Boolean, Integer> cbt(TreeNode root){
        if(root == null) return new Pair<Boolean, Integer>(true, 0);
        Pair<Boolean, Integer> lst = cbt(root.left);
        Pair<Boolean, Integer> rst = cbt(root.right);
        boolean f = lst.getKey() && rst.getKey() && Math.abs(lst.getValue() - rst. getValue()) <= 1;
        int h = 1 + Math.max(lst.getValue(), rst.getValue());
        return new Pair<Boolean, Integer>(f,h);
            
    }
}