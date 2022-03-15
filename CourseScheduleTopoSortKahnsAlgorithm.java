import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleTopoSortKahnsAlgorithm {
    public int[] findOrder(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=0; i<n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] course:prerequisites) {
            graph.get(course[0]).add(course[1]);
        }
        int[] indegree = new int[n];
        for (int i=0; i<prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }

        int index = 0;
        int[] order = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i=0; i<n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order[index] = current;
            index++;
            for (Integer edge:graph.get(current)) {
                indegree[edge]--;
                if (indegree[edge] == 0) queue.offer(edge);
            }
        }
        if (index != n) {
            return new int[0];
        }

        return order;
    }

    public static void main(String[] args) {
        CourseScheduleTopoSortKahnsAlgorithm kahns = new CourseScheduleTopoSortKahnsAlgorithm();
        int n = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        kahns.findOrder(n, prerequisites);
    }
}
