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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        //BFS
        /*
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            depth++;
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null){
                    queue.add(temp.left);
                }
                
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
        }
        return depth;
        */
        
        // DFS
        return Math.max((maxDepth(root.left) + 1),(maxDepth(root.right) + 1));
    }
}