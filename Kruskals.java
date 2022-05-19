import java.util.PriorityQueue;

public class Kruskals {

    public static void main(String[] args) {
        Kruskals kruskals = new Kruskals();
        int[][] points = {{3,12},{-2,5},{-4,1}};
        int cost = kruskals.minCost(points);
        System.out.print(cost);
    }

    /**
     * @param int     total number of verticies int the tree
     * @param int[][] edge list src, dest, weight
     * @return int minimum cose of the spanning tree
     */
    public int minCost(int[][] points) {
        int V = points.length;
        int minCost = 0;
        Edge[] mst = new Edge[V - 1];
        int k = V - 2;
        PriorityQueue<Edge> minHeap = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            for (int j=0; j < points.length; j++) {
                if (i == j) continue;
                int[] p2 = points[j];
                int distance = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                minHeap.add(new Edge(i, j, distance));
            }

        }
        UnionFind uf = new UnionFind(V);
        while (!minHeap.isEmpty()) {
            Edge current = minHeap.poll();
            if (!uf.connected(current.src, current.dest)) {
                uf.union(current.src, current.dest);
                minCost += current.weight;
                mst[k] = current;
                k--;
                if (k < 0)
                    break;
            }
        }
        // mst contains edges of minimum spanning tree
        return minCost;
    }

    class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int distance) {
            this.src = src;
            this.dest = dest;
            this.weight = distance;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        UnionFind(int V) {
            this.count = V;
            parent = new int[V+1];
            rank = new int[V+1];
            for (int i = 0; i < V; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ)
                return;

            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
                rank[rootP] += rank[rootQ];
            } else {
                parent[rootP] = rootQ;
                rank[rootQ] += rank[rootP];
            }
        }

        boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        int totalComponents() {
            return this.count;
        }
    }
}
