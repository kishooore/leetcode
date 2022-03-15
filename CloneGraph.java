import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        Map<Integer, Node> visited = new HashMap<>();
        return clone(node, visited);
    }

    public Node clone(Node node, Map<Integer, Node> visited) {
        if (visited.get(node.val) != null) return visited.get(node.val);
        Node clone = new Node(node.val);
        visited.put(node.val, clone);
        for (Node neighbor:node.neighbors) {
            clone.neighbors.add(clone(neighbor, visited));
        }
        return clone;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
