package Algo2023.SelfLearning.Graph;

public class Edge implements Comparable<Edge> {
    private final int from;
    private final int to;
    private final int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }
    public int getFrom() {
        return this.from;
    }
    public int getTo() {
        return this.to;
    }

    @Override
    public String toString() {
        return this.from + "--(" + this.weight + ")--> " + this.to;
    }

    @Override
    public int compareTo(Edge e) {
        return this.getWeight() - e.getWeight();
    }
}
