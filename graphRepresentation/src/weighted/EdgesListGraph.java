package weighted;

import java.util.ArrayList;
import java.util.Comparator;

public class EdgesListGraph implements WeightedGraph {

    private final ArrayList<WeightedEdge<Integer, Integer>> edges;

    public EdgesListGraph(ArrayList<WeightedEdge<Integer, Integer>> edges) {
        this.edges = edges;
    }

    public EdgesListGraph() {
        this.edges = new ArrayList<>();
    }


    @Override
    public void dump() {
        edges.forEach(System.out::println);
    }

    @Override
    public void print() {
        edges.sort(Comparator.comparing(o -> o.from));
        edges.forEach(it -> System.out.println("from " + it.from + " to " + it.to + " with weight: " + it.weight));
    }

    @Override
    public void reachableVerticesFrom(int vertex) {
        edges.forEach(it -> {
            if (it.from == vertex) System.out.println(it.to + " with cost " + it.weight + "\t");
        });
    }

    @Override
    public void addVertex(int vertex) {
        throw new UnsupportedOperationException("Sorry, the operation of adding a new vertex doesn't support.");
    }

    @Override
    public void removeVertex(int vertex) {
        throw new UnsupportedOperationException("Sorry, the operation of removing a vertex doesn't support.");
    }

    @Override
    public void addEdge(int from, int to, int weight) {
        edges.add(new WeightedEdge<>(from, to, weight));
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

    public static class WeightedEdge<T, S> {

        final T from;
        final T to;
        final S weight;

        public WeightedEdge(T from, T to, S cost) {
            this.from = from;
            this.to = to;
            this.weight = cost;
        }


        @Override
        public String toString() {
            return "WeightedEdge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }

}
