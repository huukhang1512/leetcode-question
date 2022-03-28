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
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder){
        for(int i = 0; i < inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }
        return helper(0,0,inorder.length - 1,preorder);
    }
    // pre == preOrder
    // in == inOrder
    public TreeNode helper(int preStart, int left,int right,int[] pre){
        if(left > right){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int inIndex = inOrderMap.get(root.val); // get the index of the root in the inorder arr
        
        /* 
        preOrder = root left right 
            -> left sub arr = root + 1
            -> right sub arr = root + 

        inOrder = left root right 
            -> left sub arr = root - 1
            -> right sub arr = root + 
        */
        
        
        root.left = helper(preStart + 1, left, inIndex - 1, pre); 
        root.right = helper(preStart + inIndex - left + 1, inIndex + 1, right, pre); // 
        
        return root;
    }
}