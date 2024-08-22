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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        getTreePaths(root, "", res);
        return res; 
    }

    private void getTreePaths(TreeNode root, String currpath, List<String> res){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            res.add(currpath  + root.val);
            return;
        }
        getTreePaths(root.left, currpath + root.val + "->", res);
        getTreePaths(root.right, currpath + root.val + "->", res);


    }
}