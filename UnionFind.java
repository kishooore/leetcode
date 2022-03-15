import java.util.Arrays;

public class UnionFind {

    int[] parent;
    
    public UnionFind(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
    }

    public int find(int node) {
        if (parent[node] < 0) return node;
        return find(parent[node]);
    }

    public int rank(int node) {
        return parent[find(node)];
    }

    public void union(int node1, int node2) {
        if (find(node1) == find(node2)) {
            System.out.println("detected cycle");
            return;
        }
        int biggerComponent = rank(node1) * (-1) >= rank(node2) * (-1) ? node1:node2;
        int smallerComponent = biggerComponent == node1 ? node2:node1;

        parent[find(biggerComponent)] = rank(biggerComponent) + rank(smallerComponent);
        parent[smallerComponent] = find(biggerComponent);
        for (Integer val:parent) {
            System.out.print(val + ", ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        UnionFind uFind = new UnionFind(5);
        uFind.union(0, 1);
        uFind.union(1, 2);
        uFind.union(3, 4);
        uFind.union(0, 3);
        uFind.union(1, 4);
    }
}
