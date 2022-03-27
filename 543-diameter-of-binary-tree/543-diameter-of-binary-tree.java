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
    int count = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return count;
    }
    
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int maxDepthL = dfs(root.left);
        int maxDepthR = dfs(root.right);
        count = Math.max(count, maxDepthL + maxDepthR);
        return 1 + Math.max(maxDepthL, maxDepthR);
    }
}