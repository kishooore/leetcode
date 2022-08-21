import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prims {

    public static void main(String[] args) {
        Prims prims = new Prims();
        int V = 7;
        int[][] edges = {{0,1,1}, {1,1,2}, {2,6,4}, {6,5,2}, {5,4,1}, {4,0,2}, {0,3,3}, {3,5,2}, {3,2,3}};
        System.out.print(prims.minCost(V, edges));
    }

    int minCost(int V, int[][] edges) {
        // prepare adjacency matrix
        int[][] adjMat = new int[V][V];
        for (int[] edge:edges) {
            int i = edge[0];
            int j = edge[1];
            int weight = edge[2];
            adjMat[i][j] = weight;
            adjMat[j][i] = weight;
        }

        // prepare adjacency List
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i=0; i<V; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] edge:edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // step-0: all node weights are INFINITY except source
        // source = 0
        int[] values = new int[V];
        Arrays.fill(values, Integer.MAX_VALUE);
        values[0] = 0;

        // to track the seleted nodes while alogorithm is in-progress works like visited set
        boolean[] selected = new boolean[V];         
        
        // to track the final mst (similar to union find parent array)
        int[] parent = new int[V];
        parent[0] = -1;

        // MST contains V-1 edges
        for (int i=0; i<V-1; i++) {
            // step-1: select node with minimum weight
            int current = nextMin(values, selected);
            // step-2: add selected node to set(not to select again)
            selected[current] = true;
            // step-3: relax/recompute adjacent nodes of the current node that are not yet part of the MST
            for (Integer adjacent:adjList.get(current)) {
                if (selected[adjacent] == false && values[adjacent] > adjMat[current][adjacent]) {
                    values[adjacent] = adjMat[current][adjacent];
                    parent[adjacent] = current; // keep track of parent of adjacent node
                }
            }
        }

        // total cost of the minimum spanning tree
        int minCost = 0;
        for (int i=1; i<parent.length; i++) {
            minCost += adjMat[i][parent[i]];
        }

        return minCost;
    }

    int nextMin(int[] values, boolean[] selected) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i=0; i<values.length; i++) {
            if (selected[i] == false && values[i] < minValue) {
                minValue = values[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

}
