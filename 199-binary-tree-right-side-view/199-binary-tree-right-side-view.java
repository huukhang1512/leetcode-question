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
    public List<Integer> rightSideView(TreeNode root) {
        // return bfs(root);
        List<Integer> res = new ArrayList<>();
        // dfs(root, res, new Stack<TreeNode>());
        dfs(root, res, 0);
        return res;
    }
    
    private void dfs(TreeNode root, List<Integer>res, int depth){
        if(root == null) {
            return;
        }
        depth++;
        // stack.add(root);
        // if(stack.size() > res.size()) res.add(root.val);
        if(depth > res.size()) res.add(root.val);
        
        dfs(root.right,res,depth);
        dfs(root.left,res,depth);
        // stack.pop();
        depth--;
    }
    private List<Integer> bfs (TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                
                if(i == 0) res.add(cur.val);
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                if(cur.left != null){
                    queue.offer(cur.left);
                }
            }
        }
        return res;
    }
}