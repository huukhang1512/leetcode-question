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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int lDepth = dfs(root.left);
        int rDepth = dfs(root.right);
        if(Math.abs(lDepth - rDepth) <= 1){
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(dfs(root.right), dfs(root.left)) + 1;
    }
}