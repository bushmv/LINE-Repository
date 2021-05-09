package unweighted;

import java.util.ArrayList;
import java.util.Comparator;

public class EdgesListGraph implements UnweightedGraph {

    private final ArrayList<Edge<Integer>> edges;

    public EdgesListGraph() {
        this(new ArrayList<>());
    }

    public EdgesListGraph(ArrayList<Edge<Integer>> edges) {
        this.edges = edges;
    }

    @Override
    public void dump() {
        edges.forEach(System.out::println);
    }

    @Override
    public void print() {
        edges.sort(Comparator.comparing(o -> o.from));
        edges.forEach(it -> System.out.println("from " + it.from + " to " + it.to));
    }

    @Override
    public void reachableVerticesFrom(int vertex) {
        edges.forEach(it -> {
            if (it.from == vertex) System.out.println(it.to + " ");
        });
    }

    @Override
    public void addVertex(int vertex) {
        throw new UnsupportedOperationException(this.getClass().getName() + " doesn't support operation add vertex");
    }

    @Override
    public void removeVertex(int vertex) {
        throw new UnsupportedOperationException("Sorry, the operation of removing a vertex doesn't support.");
    }

    @Override
    public void addEdge(int from, int to) {
        edges.add(new Edge<>(from, to));
    }


    @Override
    public void removeEdge(int from, int to) {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).from == from && edges.get(i).to == to) {
                edges.remove(i);
                break;
            }
        }
    }

    public static class Edge<T> {

        private final T from;
        private final T to;

        public Edge(T from, T to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "Edge {" +
                    "from=" + from +
                    ", to=" + to +
                    '}';
        }
    }
}
