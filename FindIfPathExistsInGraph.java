import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindIfPathExistsInGraph {
    public static void main(String[] args) {
        FindIfPathExistsInGraph tester = new FindIfPathExistsInGraph();
        int n = 6;
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.print(tester.validPath(n, edges, 0, 5));
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=0; i<n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        for (int i=0; i<edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean[] visited = new boolean[n];
        return dfs(graph, visited, source, destination);
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int source, int destination) {
        if (visited[source] == true) return false;
        if (source == destination) return true;
        visited[source] = true;
        for (Integer neighbour:graph.get(source)) {
            if (dfs(graph, visited, neighbour, destination)) return true;
        }
        return false;
    }
}
