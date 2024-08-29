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
   private void dfs(TreeNode node, int column, int row, List<int[]> nodes) {
        if (node == null) {
            return; // Base case: if the node is null, then just return.
        }
        // Add the current node's data as a tuple (column, row, value) to the nodes list.
        nodes.add(new int[]{column, row, node.val});
        // Continue DFS on the left subtree, decrementing column and row for left traversal.
        dfs(node.left, column - 1, row - 1, nodes);
        // Continue DFS on the right subtree, incrementing column and decrementing row for right traversal.
        dfs(node.right, column + 1, row - 1, nodes);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>(); 
        dfs(root, 0, 0, nodes); 

        nodes.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] node1, int[] node2) {
                if (node1[0] != node2[0]) return Integer.compare(node1[0], node2[0]);
                if (node1[1] != node2[1]) return Integer.compare(node2[1], node1[1]);
                return Integer.compare(node1[2], node2[2]);
            }
        });

        List<List<Integer>> result = new ArrayList<>(); 
        int previousColumn = Integer.MIN_VALUE; 
      
        for (int[] currentNode : nodes) {
            if (previousColumn != currentNode[0]) {
                result.add(new ArrayList<>());
                previousColumn = currentNode[0]; 
            }
       
            result.get(result.size() - 1).add(currentNode[2]);
        }
        return result; 
    }
}
