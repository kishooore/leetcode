import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathExists {

    public static void main(String[] args) {
        PathExists tester = new PathExists();
        int N = 416;
        List<List<Integer>> edges = Collections.emptyList();
        tester.solve(N,edges);
    }

    public int solve(int N, List<List<Integer>> edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=1; i<=N; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        for (List<Integer> edge:edges) {
            graph.get(edge.get(0)).add(edge.get(1));
        }
        boolean[] visited = new boolean[N+1];
        return dfs(graph, visited, 1, N) ;
    }

    int dfs(Map<Integer, List<Integer>> graph, boolean[] visited, Integer source, Integer destination) {
        if (visited[source]) return 0;
		if (source == destination) return 1;
        visited[source] = true;
        for (Integer neighbor:graph.get(source)) {
            if (dfs(graph, visited, neighbor, destination) == 1) return 1;
        }
        return 0;
    }
}
