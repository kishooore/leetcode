import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkDelayTime {
    public static void main(String[] args) {
        NetworkDelayTime test = new NetworkDelayTime();
//        int[][] times = {{2,1,1}, {2,3,1}, {3,4,1}};
//        int n = 4;
//        int k = 2;
        int[][] times = {{1,2,1}, {2,1,3}};
        int n = 2;
        int k = 2;
        int time = test.networkDelayTime(times, n, k);
        System.out.println(time);
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] visited = new int[n+1];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=1; i<n+1; i++) {
            graph.put(i, new ArrayList<>());
        }
        Map<Path, Integer> paths = new HashMap<>();
        for (int i=0; i<times.length; i++) {
            paths.put(new Path(times[i][0], times[i][1]), times[i][2]);
            graph.get(times[i][0]).add(times[i][1]);
        }
        int time = dfs(graph, paths, visited, k, 0);
        for (int i=1; i<=n; i++) {
            if (visited[i] == 0) return -1;
        }
        return time;
    }

    private int dfs(Map<Integer, List<Integer>> graph, Map<Path, Integer> paths, int[] visited, int source, int currentTime) {
        if (visited[source] == 1) return currentTime;
        visited[source] = 1;
        if (graph.get(source).isEmpty()) {
            return currentTime;
        }
        int maxTime = currentTime;
        for (Integer neighbor:graph.get(source)) {
            if (visited[neighbor] == 0) {
                int time = dfs(graph, paths, visited, neighbor, currentTime + paths.get(new Path(source, neighbor)));
                maxTime = Math.max(time, maxTime);
            }
        }
        return maxTime;
    }
}

class Path {
    int source;
    int destination;

    public Path(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + destination;
        result = prime * result + source;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Path other = (Path) obj;
        if (destination != other.destination)
            return false;
        if (source != other.source)
            return false;
        return true;
    }
}
