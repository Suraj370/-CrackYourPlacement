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
    public TreeNode invertTree(TreeNode root) {
        depthFirstSearchInvert(root);
        return root;
    }
    private void depthFirstSearchInvert(TreeNode node) {
        if (node == null) {
            return;
        }
      
        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
      
        depthFirstSearchInvert(node.left);
        depthFirstSearchInvert(node.right);
    }
}