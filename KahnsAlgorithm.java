import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;

public class KahnsAlgorithm {

    int[] sort(Map<Integer, List<Integer>> graph) {
        int[] indegree = new int[graph.size()];
        for (Entry<Integer, List<Integer>> node:graph.entrySet()) {
            for (Integer edge:node.getValue()) {
                indegree[edge]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i=0; i < graph.size(); i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int[] order = new int[graph.size()];
        int i = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order[i] = current;
            i++;
            for (Integer to:graph.get(current)) {
                indegree[to]--;
                if (indegree[to] == 0) {
                    queue.offer(to);
                }
            }
        }

        if (i != graph.size()) {
            throw new IllegalArgumentException("Graph is not acyclic! Detected a cycle.");
        }
        return order;
    }
}
