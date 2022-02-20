/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Integer,Node> map = new HashMap();
        return clone(node, map);
    }
    public Node clone(Node node, HashMap<Integer,Node> map){
        if(node == null){
            return null;
        }
        if(map.get(node.val) != null){
            return map.get(node.val);
        }
        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(newNode.val, newNode);
        for(Node neighbor: node.neighbors){
            newNode.neighbors.add(clone(neighbor,map));
        }
        return newNode;
    }
}