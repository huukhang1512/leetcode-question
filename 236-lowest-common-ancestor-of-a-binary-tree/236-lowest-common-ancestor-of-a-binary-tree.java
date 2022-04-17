/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == q || root == p) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // p and q in different branch
        if(left != null && right != null) return root;
        // p and q in same branch
        if(left != null && (root == q || root == p)) return root;
        if(right != null && (root == q || root == p)) return root;
        
        return left == null ? right : left;
    }
}