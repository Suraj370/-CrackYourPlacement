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
     public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumDFS(root, targetSum);
    }

     private boolean hasPathSumDFS(TreeNode node, int currentSum) {
        if (node == null) {
            return false;
        }
      
        currentSum -= node.val;
      
       
        if (node.left == null && node.right == null && currentSum == 0) {
            return true;
        }
      
       
        return hasPathSumDFS(node.left, currentSum) || hasPathSumDFS(node.right, currentSum);
    }

}