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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        return getdia(root).getValue() - 1;
    }
    public Pair<Integer, Integer> getdia(TreeNode root){
        if(root == null) return new Pair<Integer, Integer>(0,0);
        Pair< Integer, Integer> lst = getdia(root.left);
        Pair< Integer, Integer> rst = getdia(root.right);
        int h = 1 + Math.max(lst.getKey(), rst.getKey());
        int d = Collections.max(Arrays.asList(1 + lst.getKey() + rst.getKey(), lst.getValue(), rst.getValue()));
        return new Pair<Integer, Integer>(h, d);
        
    }
}