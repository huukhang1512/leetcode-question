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
    /*
    traverse the bs with dfs, and then check the sub tree of each node to see whether or not it is going  matched. Think of it like a root force solution*/
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        if(checkIfSame(root,subRoot)){
            return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean checkIfSame(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            // the end of both tree, means that both of these tree dont have any child from this point
            return true;
        }
        if(root == null || subRoot == null){ 
            // reach the end of the root tree or the sub tree, this means that one of these tree still have child
            return false;
        }

        if(root.val != subRoot.val){
            // different value => not a subtree
            return false;
        }
        return checkIfSame(root.left,subRoot.left) && checkIfSame(root.right,subRoot.right);
    }
}