package Algo2023.Homework;

import java.util.*;

class Edge implements Comparable<Edge> {
    private final int from;
    private final int to;
    Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
    @Override
    public String toString() {
        return "(" + this.from + "," + this.to + ")";
    }
    @Override
    public int compareTo(Edge e) {
        return this.from != e.from ? this.from - e.from : this.to - e.to;
    }
}

class DirectedGraph {
    private final int vertices;
    private final int edges;
    private final int[][] adjacent_;

    private final boolean[] visited, dfs;
    private final Stack<Integer> stack = new Stack<>();
    private final ArrayList<Integer>[] adjacent = new ArrayList[99];
    private final TreeSet<Edge> loopResult = new TreeSet<>();

    DirectedGraph(int vertices, int edges, int[][] adjacent_) {
        this.vertices = vertices;
        this.edges = edges;
        this.adjacent_ = adjacent_;
        this.dfs = new boolean[vertices];
        this.visited = new boolean[vertices];
        for ( int i = 0; i < vertices; i++ ) {
            this.adjacent[i] = new ArrayList<>();
        }
        for ( int[] edge : this.adjacent_) {
            adjacent[edge[0]].add(edge[1]);
        }
    }

    public void dfs(int start) {
        for ( int dest : this.adjacent[start] ) {
            if ( !this.visited[dest] ) {
                this.dfs[dest] = true;
                this.visited[dest] = true;
                this.stack.push(dest);
                dfs(dest);
                this.stack.pop();
                this.visited[dest] = false;
            }
            else {
                for ( int i = 0; i < stack.size(); i++ ) {
                    if ( dest == stack.get(i) ) {
                        for ( int j = i; j < stack.size(); j++ ) {
                            loopResult.add(new Edge(stack.get(j), j == stack.size() - 1 ? dest : stack.get(j + 1)));
                        }
                        break;
                    }
                }
            }
        }
    }

    public static StringBuilder FindCycle(DirectedGraph graph) {
        // TODO
        Arrays.fill(graph.dfs, false);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < graph.vertices; i++ ) {
            if ( !graph.dfs[i] ) {
                Arrays.fill(graph.visited, false);
                graph.visited[i] = true;
                graph.stack.empty();
                graph.stack.push(i);
                graph.dfs(i);
            }
        }
        graph.loopResult.forEach(result::append);
        return result;
    }

    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(7, 9, new int[][]{
                {0, 1}, {1, 3}, {2, 3}, {2, 5}, {3, 1}, {3, 4}, {4, 2}, {4, 5}, {6, 6}
        });
//        DirectedGraph g = new DirectedGraph(4, 5, new int[][]{
//                {0, 2}, {0, 1},
//                {2, 3}, {1, 3},
//                {3, 0}
//        });
        System.out.println(FindCycle(g));
    }
}