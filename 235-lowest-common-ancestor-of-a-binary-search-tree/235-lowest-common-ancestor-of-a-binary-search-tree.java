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
            return lowestCommonAncestor(root.left,p,q); // both elements on the left subtree
        }
        else if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right,p,q); // both elements on the right subtree
        } else {
            return root; // they are split, making the current node their LCA
        }
    }
}