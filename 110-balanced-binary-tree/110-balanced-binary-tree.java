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
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return result;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int lDepth = dfs(root.left);
        int rDepth = dfs(root.right);
        if(Math.abs(lDepth - rDepth) > 1){
            result = false;
            return 0;
        }
        return Math.max(lDepth, rDepth) + 1;
    }
}