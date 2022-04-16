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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        helper(root, targetSum, paths, new ArrayList<>());
        return paths;
    }
    
    private void helper (TreeNode root, int sum, List<List<Integer>> paths, List<Integer> path){
        if(root == null) return;
        sum = sum - root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == 0){
                paths.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }
        helper(root.left, sum, paths, path);
        helper(root.right, sum, paths, path);
        path.remove(path.size() - 1);
    }
}