package main;

import unweighted.AdjacencyListGraph;
import unweighted.EdgesListGraph;
import unweighted.MatrixGraph;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        showUnweightedMatrixGraph();
    }

    private static void showUnweightedMatrixGraph() {
        int[][] matrix = new int[5][5];
        matrix[1][2] = 1;
        matrix[2][4] = 1;
        matrix[3][1] = 1;
        matrix[4][3] = 1;
        matrix[4][1] = 1;

        BaseGraph graph = new MatrixGraph(matrix);
        graph.dump();
        graph.print();
        graph.reachableVerticesFrom(4);
    }

    private static void showUnweightedEdgesListGraph() {
        ArrayList<EdgesListGraph.Edge<Integer>> edges = new ArrayList<>();
        edges.add(new EdgesListGraph.Edge<>(1, 2));
        edges.add(new EdgesListGraph.Edge<>(2, 4));
        edges.add(new EdgesListGraph.Edge<>(3, 1));
        edges.add(new EdgesListGraph.Edge<>(4, 1));
        edges.add(new EdgesListGraph.Edge<>(4, 3));

        BaseGraph graph = new EdgesListGraph(edges);
        graph.dump();
        graph.print();
        graph.reachableVerticesFrom(4);
    }

    private static void showUnweightedAdjacencyListGraph() {
        ArrayList<LinkedList<Integer>> vertexList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            vertexList.add(new LinkedList<>());
        }
        vertexList.get(1).add(2);
        vertexList.get(2).add(4);
        vertexList.get(3).add(1);
        vertexList.get(4).add(1);
        vertexList.get(4).add(3);

        BaseGraph graph = new AdjacencyListGraph(vertexList);
        graph.dump();
        graph.print();
        graph.reachableVerticesFrom(4);
    }

    private static void showWeightedMatrixGraph() {
        int[][] matrix = new int[5][5];
        matrix[1][2] = 2;
        matrix[2][4] = 4;
        matrix[3][1] = 5;
        matrix[4][3] = 3;
        matrix[4][1] = 9;

        BaseGraph graph = new weighted.MatrixGraph(matrix);
        graph.dump();
        graph.print();
        graph.reachableVerticesFrom(4);
    }

    private static void showWeightedEdgesListGraph() {
        ArrayList<weighted.EdgesListGraph.WeightedEdge<Integer, Integer>> edges = new ArrayList<>();
        edges.add(new weighted.EdgesListGraph.WeightedEdge<>(1, 2, 2));
        edges.add(new weighted.EdgesListGraph.WeightedEdge<>(2, 4, 4));
        edges.add(new weighted.EdgesListGraph.WeightedEdge<>(3, 1, 5));
        edges.add(new weighted.EdgesListGraph.WeightedEdge<>(4, 1, 9));
        edges.add(new weighted.EdgesListGraph.WeightedEdge<>(4, 3, 3));

        BaseGraph graph = new weighted.EdgesListGraph(edges);
        graph.dump();
        graph.print();
        graph.reachableVerticesFrom(4);
    }

    private static void showWeightedAdjacencyListGraph() {
        ArrayList<LinkedList<weighted.AdjacencyListGraph.Pair<Integer, Integer>>> vertexList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            vertexList.add(new LinkedList<>());
        }
        vertexList.get(1).add(new weighted.AdjacencyListGraph.Pair<>(2, 2));
        vertexList.get(2).add(new weighted.AdjacencyListGraph.Pair<>(4, 4));
        vertexList.get(3).add(new weighted.AdjacencyListGraph.Pair<>(1, 5));
        vertexList.get(4).add(new weighted.AdjacencyListGraph.Pair<>(1, 9));
        vertexList.get(4).add(new weighted.AdjacencyListGraph.Pair<>(3, 3));

        BaseGraph graph = new weighted.AdjacencyListGraph(vertexList);
        graph.dump();
        graph.print();
        graph.reachableVerticesFrom(4);
    }


}
