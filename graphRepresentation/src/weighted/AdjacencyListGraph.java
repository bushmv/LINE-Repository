package weighted;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyListGraph implements WeightedGraph {

    private final ArrayList<LinkedList<Pair<Integer, Integer>>> vertexList;

    public AdjacencyListGraph(ArrayList<LinkedList<Pair<Integer, Integer>>> vertexList) {
        this.vertexList = vertexList;
    }

    public AdjacencyListGraph(int vertices) {
        vertexList = new ArrayList<>();
        for (int i = 0; i < vertices + 1; i++) {
            vertexList.add(new LinkedList<>());
        }
    }

    @Override
    public void dump() {
        System.out.println(vertexList.toString());
    }

    @Override
    public void print() {
        for (int i = 1; i < vertexList.size(); i++) {
            System.out.print("vertices from " + i + ": ");
            vertexList.get(i).forEach(it -> System.out.print(it + " with weight " + it.weight + "; "));
            System.out.println();
        }
    }

    @Override
    public void reachableVerticesFrom(int vertex) {
        vertexList.get(vertex).forEach(System.out::println);
    }

    @Override
    public void addVertex(int vertex) {
        vertexList.add(new LinkedList<>());
    }

    @Override
    public void removeVertex(int vertex) {
        vertexList.get(vertex).clear();
    }

    @Override
    public void addEdge(int from, int to, int weight) {
        vertexList.get(from).add(new Pair<>(to, weight));
    }

    @Override
    public void removeEdge(int from, int to) {
        for (int i = 0; i < vertexList.get(from).size(); i++) {
            if (vertexList.get(from).get(i).to == from) {
                vertexList.get(from).remove(i);
                break;
            }
        }
    }

    public static class Pair<E, T> {

        final E to;
        final T weight;

        public Pair(E to, T weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }

}
