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
    public int widthOfBinaryTree(TreeNode root) {
        // Queue to hold nodes and their respective indices in the tree
        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(root, 1));
        int maxWidth = 0;
      
        while (!queue.isEmpty()) {
            maxWidth = Math.max(maxWidth,
                                queue.peekLast().getValue() - queue.peekFirst().getValue() + 1);
          
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; ++i) {
                Pair<TreeNode, Integer> current = queue.pollFirst();
                TreeNode currentNode = current.getKey();
                int index = current.getValue();
              
                if (currentNode.left != null) {
                    queue.offer(new Pair<>(currentNode.left, 2 * index));
                }
                if (currentNode.right != null) {
                    queue.offer(new Pair<>(currentNode.right, 2 * index + 1));
                }
            }
        }
        return maxWidth;
    }
}