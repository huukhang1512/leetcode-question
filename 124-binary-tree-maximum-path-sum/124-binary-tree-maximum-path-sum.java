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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    public int helper(TreeNode cur){
        if(cur == null){
            return 0;
        }
        // recursively through left and right
        int left = Math.max(helper(cur.left),0); // get the maximum path of the left sub tree
        int right = Math.max(helper(cur.right),0); // get the maximum path of the right sub tree
        max = Math.max(max, cur.val + left + right); // result
        return cur.val + Math.max(left,right); // maximum you could get without split
    }
}