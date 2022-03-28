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
    public TreeNode buildTree(int[] preorder, int[] inorder){
        return helper(0,0,inorder.length - 1,preorder,inorder);
    }
    // pre == preOrder
    // in == inOrder
    public TreeNode helper(int preStart, int inStart,int inEnd,int[] pre,int[] in){
        if(preStart > pre.length -1 || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]); // e.g 3
        int inIndex = inStart; // get the index of the root in the inorder arr
        for(int i = inStart; i <= inEnd; i++){
            if(in[i] == root.val){
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, pre, in);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, pre, in);
        return root;
    }
}