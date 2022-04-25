/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            if (curNode != null) {
                if (curNode.right != null) {
                    curNode.left.next = curNode.right;
                    if (curNode.next != null) {
                        curNode.right.next = curNode.next.left;
                    }
                }
                queue.add(curNode.left);
                queue.add(curNode.right);
            }
        }
        return root;
    }
}