package unweighted;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyListGraph implements UnweightedGraph {

    private final ArrayList<LinkedList<Integer>> vertexList;

    public AdjacencyListGraph(ArrayList<LinkedList<Integer>> vertexList) {
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
            vertexList.get(i).forEach(it -> System.out.print(it + " "));
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
        vertexList.remove(vertex);
        // or vertexList.get(vertex).clear();
    }

    @Override
    public void addEdge(int from, int to) {
        vertexList.get(from).add(to);
    }

    @Override
    public void removeEdge(int from, int to) {
        for (int i = 0; i < vertexList.get(from).size(); i++) {
            if (vertexList.get(from).get(i) == to) {
                vertexList.get(from).remove(i);
                break;
            }
        }
    }


}
