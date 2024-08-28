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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
      

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
      

        boolean leftToRight = true;
      

        while (!queue.isEmpty()) {

            List<Integer> tempList = new ArrayList<>();

            for (int i = queue.size(); i > 0; --i) {

                TreeNode currentNode = queue.poll();

                tempList.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
          
            if (!leftToRight) {
                Collections.reverse(tempList);
            }

            result.add(tempList);
            leftToRight = !leftToRight;
        }
      
        return result;
    }
}