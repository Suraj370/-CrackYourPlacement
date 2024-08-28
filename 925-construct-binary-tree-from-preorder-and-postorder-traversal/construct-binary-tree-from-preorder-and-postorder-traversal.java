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
    private Map<Integer, Integer> postOrderIndexMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            postOrderIndexMap.put(postorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                               int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        if (preStart == preEnd) return root;

        int leftRootIndex = postOrderIndexMap.get(preorder[preStart + 1]);

        int leftSubtreeLength = leftRootIndex - postStart + 1;

        root.left = buildTree(preorder, preStart + 1, preStart + leftSubtreeLength,
                              postorder, postStart, leftRootIndex);

        root.right = buildTree(preorder, preStart + leftSubtreeLength + 1, preEnd,
                               postorder, leftRootIndex + 1, postEnd - 1);

        return root;
    }
}