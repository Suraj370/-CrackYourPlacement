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
   public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
      
        if (root == null) {
            return answer;
        }
      
        Deque<TreeNode> queue = new ArrayDeque<>();
      
        queue.offer(root);
      
        while (!queue.isEmpty()) {
            answer.add(queue.peekLast().val);
          
            for (int n = queue.size(); n > 0; --n) {
                TreeNode node = queue.poll();
              
                if (node.left != null) {
                    queue.offer(node.left);
                }
              
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
      
        return answer;
    }
}