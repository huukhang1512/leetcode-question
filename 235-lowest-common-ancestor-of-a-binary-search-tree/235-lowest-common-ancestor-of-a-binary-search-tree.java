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
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q); // both p and q are in the left subtree
        } else if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q); // both p and q are in the right subtree
        } else {
            return root; // they split, which makes the current node the LCA
        }
    }
}