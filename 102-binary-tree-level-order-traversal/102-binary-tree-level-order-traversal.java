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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> rootArr = new ArrayList<>();
        rootArr.add(root.val);
        result.add(rootArr);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            ArrayList<Integer> child = new ArrayList<>();
            for(int i = 0; i < queueSize; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null){
                    queue.add(temp.left);
                    child.add(temp.left.val);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                    child.add(temp.right.val);
                }
            }
            if(child.size() != 0){
                result.add(child);
            }
        }
        return result;
    }
}