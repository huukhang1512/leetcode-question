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
    int postIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }
        postIndex = postorder.length - 1;
        return helper(0, postorder.length - 1,postorder);
    }

    public TreeNode helper(int left,int right,int[] post){
        if(postIndex < 0 || left > right){
            return null;
        }
        TreeNode root = new TreeNode(post[postIndex]);
        postIndex--;
        int inIndex = inOrderMap.get(root.val); 
        
        root.right = helper(inIndex + 1, right , post); 
        root.left = helper(left, inIndex - 1, post); 
        
        return root;
    }
    
}