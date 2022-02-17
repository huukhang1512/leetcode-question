/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        
        map.put(root,null);
        queue.add(root);
        
        while(!map.containsKey(p) || !map.containsKey(q)){
            TreeNode cur = queue.poll();
            if(cur.left != null){
                queue.add(cur.left);
                map.put(cur.left,cur);
            }
            if(cur.right != null){
                queue.add(cur.right);
                map.put(cur.right,cur);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while(p != null){
            ancestors.add(p);
            p = map.get(p);
        }
        
        while(!ancestors.contains(q)){
            q = map.get(q);
        }
        return q;
    }
}