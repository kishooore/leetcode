import java.util.Arrays;

public class BellmanFord {
    int V;
    int[] distances;
    int[][] edges;

    public static void main(String[] args) {
        int[][] edges = {{0,1,1}, {1,3,3}, {0,2,2}, {0,3,2}, {2,3,1}, {1,4,4}, {3,4,4}};
        BellmanFord bellmanFord = new BellmanFord(5, edges);
        System.out.println(bellmanFord.shortest(0, 4));
    }

    public BellmanFord(int V, int[][] edges) {
        this.V = V;
        this.distances = new int[V];
        this.edges = edges;
    }

    public int shortest(int src, int dest) {
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;
        for (int i=0; i<V-1; i++) {
            for (int[] edge:edges) {
                int u = edge[0];
                int v = edge[1];
                int cost = edge[2];
                int newDistance = distances[u] + cost;
                if (distances[v] > newDistance) {
                    distances[v] = newDistance;
                }
            }
        }

        for (int[] edge:edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            if (distances[u] + cost < distances[v]) {
                System.out.println("negative loop detected");
            }
        }
        return distances[dest];
    }
}
