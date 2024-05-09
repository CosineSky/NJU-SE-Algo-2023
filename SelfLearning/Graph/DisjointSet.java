package Algo2023.SelfLearning.Graph;

public class DisjointSet {
    private final int[] parent;

    DisjointSet(int number) {
        this.parent = new int[number];
    }

    public void reset() {
        for ( int i = 0; i < 100; i++ ) {
            parent[i] = i;
        }
    }

    public int find(int target) {
        return parent[target] == target ? target : find(parent[target]);
    }

    public void union(int v1, int v2) {
        parent[find(v1)] = find(v2);
    }
}
