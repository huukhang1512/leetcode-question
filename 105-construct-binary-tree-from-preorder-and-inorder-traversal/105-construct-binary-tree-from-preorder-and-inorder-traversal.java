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
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }
        return helper(0,0,inorder.length - 1,preorder,inOrderMap);
    }
    // pre == preOrder
    // in == inOrder
    public TreeNode helper(int preStart, int inStart,int inEnd,int[] pre, Map<Integer, Integer> inOrderMap){
        if(preStart > pre.length -1 || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]); // e.g 3
        int inIndex = inOrderMap.get(root.val); // get the index of the root in the inorder arr
        
        root.left = helper(preStart + 1, inStart, inIndex - 1, pre, inOrderMap);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, pre, inOrderMap);
        
        return root;
    }
}