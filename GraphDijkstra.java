import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@SuppressWarnings("unused")
public class GraphDijkstra {

    private List<List<Node>> adjacencyList;
    private int[] distances;
    private int V;
    private PriorityQueue<Node> minHeap; 

    public GraphDijkstra(int V) {
        this.V = V;
        this.minHeap = new PriorityQueue<>(V);
        this.distances = new int[V];
    }
}

class Node implements Comparator<Node> {
    int val;
    int cost;

    public Node(int val, int cost) {
        this.val = val;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.cost < node2.cost) {
            return -1;
        } else if (node1.cost > node2.cost) {
            return 1;
        } else {
            return 0;
        }
    }
}
