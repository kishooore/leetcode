public class DS {
    int[] parent;
    int[] size;

    public DS(int N) {
        parent = new int[N];
        size = new int[N];
        for(int i=0; i<N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
            size[rootY] = size[rootY] + size[rootX];
        } else {
            System.out.println("detected loop");
        }
    }

    public int find(int x) {
        if (parent[x] == x) return x;

        return find(parent[x]);
    }

    public int largestConsecutive() {
        int maxLen = Integer.MIN_VALUE;
        for (int i=0; i<parent.length; i++) {
            if (parent[i] == i) maxLen = Math.max(maxLen, size[i]);
        }
        return maxLen;
    }
}
