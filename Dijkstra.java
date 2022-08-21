import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    private Map<Integer, List<int[]>> adjList = new HashMap<>();
    private int[] distances;
    private PriorityQueue<int[]> minHeap;
    private boolean[] processed;
    private int[] parents;

    // 0-indexed graph
    public Dijkstra(int V, int[][] edges) {
        for (int i=0; i<V; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] edge:edges) {
            int src = edge[0];
            int dest = edge[1];
            int cost = edge[2];
            int[] next = new int[2];
            next[0] = dest;
            next[1] = cost;
            adjList.get(src).add(next);
        }
        distances = new int[V];
        minHeap = new PriorityQueue<>((a1, a2) -> Integer.compare(a1[1], a2[1]));
        processed = new boolean[V];
        parents = new int[V];
    }

    public int shortest(int src, int dest) {
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;
        int[] srcNode = new int[2];
        srcNode[0] = src;
        srcNode[1] = 0;
        minHeap.offer(srcNode);
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            processed[current[0]] = true;
            for (int[] neighbor:adjList.get(current[0])) {
                if (processed[neighbor[0]] == false) {
                    int newDistance = current[1] + neighbor[1];
                    if (newDistance < distances[neighbor[0]]) {
                        distances[neighbor[0]] = newDistance;
                        int[] neighborNode = new int[2];
                        neighborNode[0] = neighbor[0];
                        neighborNode[1] = newDistance;
                        minHeap.offer(neighborNode);
                        parents[neighbor[0]] = current[0];
                    }
                }
            }
        }
        return distances[dest];
    }
}
