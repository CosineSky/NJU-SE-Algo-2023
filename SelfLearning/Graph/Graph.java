package Algo2023.SelfLearning.Graph;

import java.util.*;

public class Graph {
    private static final int MAX_NODES = 100;

    private final int maxVertices;
    private final ArrayList<Edge>[] adjacent = new ArrayList[MAX_NODES];

    // Temp for traversal.
    private final boolean[] visited = new boolean[MAX_NODES];
    private final Queue<Integer> queue = new ArrayDeque<>();

    // Temp for spanning tree.
    private final DisjointSet disjointSet = new DisjointSet(MAX_NODES);

    Graph(int maxVertices) {
        this.maxVertices = maxVertices;
        for ( int i = 0; i < maxVertices; i++ ) {
            this.adjacent[i] = new ArrayList<>();
        }
    }

    private void resetVisited(int start) {
        for ( int i = 0; i < this.maxVertices; i++ ) {
            this.visited[i] = start != -1 && (i == start);
        }
    }

    public boolean findEdge(int from, int to) {
        for ( Edge e : this.adjacent[from] ) {
            if ( e.getTo() == to ) return true;
        }
        return false;
    }

    public void addEdge(Edge e) {
        Edge reverse = new Edge(e.getTo(), e.getFrom(), e.getWeight());
        adjacent[e.getFrom()].add(e);
        adjacent[e.getTo()].add(reverse);
    }
    public void addEdges(Edge[] edges) {
        for ( Edge e : edges ) {
            addEdge(e);
        }
    }

    public void addDirectedEdge(Edge e) {
        adjacent[e.getFrom()].add(e);
    }
    public void addDirectedEdges(Edge[] edges) {
        for ( Edge e : edges ) {
            addDirectedEdge(e);
        }
    }


    public void removeEdge(int from, int to) {
        this.adjacent[from].removeIf(e -> e.getTo() == to);
    }

    public void dfs(int start) {
        resetVisited(start);
        System.out.println(start);
        dfs_(start);
    }
    private void dfs_(int start) {
        this.visited[start] = true;
        for ( Edge e : this.adjacent[start] ) {
            if ( !this.visited[e.getTo()] ) {
                System.out.println(e.getTo());
                dfs_(e.getTo());
            }
        }
    }

    public void bfs(int start) {
        resetVisited(start);
        queue.add(start);
        while ( !queue.isEmpty() ) {
            int current = queue.poll();
            System.out.println(current);
            for ( Edge e : this.adjacent[current] ) {
                if ( !this.visited[e.getTo()] ) {
                    queue.add(e.getTo());
                    visited[e.getTo()] = true;
                }
            }
        }
    }

    public HashSet<Edge> kruskal() {
        HashSet<Edge> result = new HashSet<>();
        ArrayList<Edge> edges = new ArrayList<>();
        for ( int i = 0; i < maxVertices; i++ ) {
            edges.addAll(this.adjacent[i]);
        }
        Collections.sort(edges);
        disjointSet.reset();
        for ( Edge e : edges ) {
            if ( disjointSet.find(e.getFrom()) != disjointSet.find(e.getTo()) ) {
                disjointSet.union(e.getFrom(), e.getTo());
                result.add(e);
            }
        }
        return result;
    }

    public HashSet<Edge> prim() {
        HashSet<Edge> result = new HashSet<>();
        PriorityQueue<Edge> q = new PriorityQueue<>();
        resetVisited(0);
        q.addAll(this.adjacent[0]);
        while ( !q.isEmpty() ) {
            Edge current = q.poll();
            if ( !this.visited[current.getTo()] ) {
                this.adjacent[current.getTo()].stream().filter(e -> !visited[e.getTo()]).forEach(q::add);
                this.visited[current.getTo()] = true;
                result.add(current);
            }
        }
        return result;
    }

    public int[] dijkstra(int start) { // wrong
        resetVisited(-1);
        Queue<Integer> q = new ArrayDeque<>();
        int[] result = new int[maxVertices];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;
        q.add(start);
        while ( !q.isEmpty() ) {
            int current = q.poll();
            if ( !visited[current] ) {
                visited[current] = true;
                for ( Edge e : adjacent[current] ) {
                    if ( result[e.getTo()] > result[current] + e.getWeight() ) {
                        result[e.getTo()] = result[current] + e.getWeight();
                        q.add(e.getTo());
                    }
                }
            }
        }
        return result;
    }

    public int[] bellman_fond(int start) {
        int[] result = new int[maxVertices];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;
        for ( int i = 0; i < maxVertices; i++ ) {
            boolean modified = false;
            for ( int u = 0; u < maxVertices; u++ ) {
                for ( Edge e : adjacent[u] ) {
                    if ( result[e.getTo()] > result[u] + e.getWeight() ) {
                        result[e.getTo()] = result[u] + e.getWeight();
                        modified = true;
                    }
                }
            }
            if ( !modified ) break;

        }
        return result;
    }

    public int[][] floyd() {
        int[][] result = new int[maxVertices][maxVertices];
        for ( int i = 0; i < result.length; i++ ) {
            Arrays.fill(result[i], Integer.MAX_VALUE / 2);
            result[i][i] = 0;
        }
        for ( int i = 0; i < maxVertices; i++ ) {
            for ( Edge e : adjacent[i] ) {
                result[e.getFrom()][e.getTo()] = e.getWeight();
            }
        }
        System.out.println(Arrays.deepToString(result));
        for ( int i = 0; i < maxVertices; i++ ) {
            for ( int u = 0; u < maxVertices; u++ ) {
                for ( int v = 0; v < maxVertices; v++ ) {
                    result[u][v] = Math.min(result[u][v], result[u][i] + result[i][v]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
//        Edge[] initialEdges = new Edge[]{
//                new Edge(0, 1, 10),
//                new Edge(0, 3, 30),
//                new Edge(0, 4, 100),
//                new Edge(1, 2, 50),
//                new Edge(2, 4, 10),
//                new Edge(3, 2, 20),
//                new Edge(3, 4, 60),
//        };
//        Edge[] initialEdges = new Edge[]{
//                new Edge(0, 1, 6),
//                new Edge(0, 2, 5),
//                new Edge(0, 3, 5),
//                new Edge(1, 4, -1),
//                new Edge(2, 1, -2),
//                new Edge(2, 4, 1),
//                new Edge(3, 2, -2),
//                new Edge(3, 5, -1),
//                new Edge(4, 6, 3),
//                new Edge(5, 6, 3),
//        };
        Edge[] initialEdges = new Edge[]{
                new Edge(0, 1, 6),
                new Edge(0, 2, 3),
                new Edge(2, 1, 2),
                new Edge(1, 3, 5),
        };
        g.addDirectedEdges(initialEdges);
        System.out.println(Arrays.toString(g.dijkstra(0)));
        System.out.println(Arrays.toString(g.bellman_fond(0)));
//        System.out.println(Arrays.toString(g.floyd()[0]));

    }
}
