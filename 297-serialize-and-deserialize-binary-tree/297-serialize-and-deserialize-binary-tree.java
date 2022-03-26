/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }
    public TreeNode buildTree(Queue<String> nodes) {
        String curNode = nodes.poll();
        if(curNode.equals("null")){
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(curNode));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
    public void dfs(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null");
            sb.append(" ");
            return;
        }
        sb.append(root.val);
        sb.append(" ");
        
        dfs(root.left,sb);
        dfs(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(" ")));
        return buildTree(nodes);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));