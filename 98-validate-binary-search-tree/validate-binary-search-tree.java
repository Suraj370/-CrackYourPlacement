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
    public boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        check(root,null, null);
        return ans;
    }

    public void check(TreeNode root, Integer lb, Integer ub){
        if(root == null) return;
        if(lb != null && root.val <= lb || ub != null && root.val >= ub){
            ans = false;
            return;
        }
        check(root.left, lb, root.val);
        check(root.right, root.val, ub);
    }
}