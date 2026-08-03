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
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        return dfs(node); // this means I am giving an original node from a graph, give me the cloned node of graph
    }
    public Node dfs(Node node){
        if(node == null){
            return node;
        }

        if(map.containsKey(node)){
            return map.get(node); // this means the map found a clone of an original node, so it links up with the clone
        }

        Node clone = new Node(node.val);
        map.put(node, clone);
        
        //clone the neighbors of the given node and put them in map also
        for(Node neighbor : node.neighbors){
            Node clonedNeighbor = dfs(neighbor);
            clone.neighbors.add(clonedNeighbor);
        }
        return clone;
    }
}