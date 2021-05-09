package main;

public interface BaseGraph {

    void dump();
    void print();
    void reachableVerticesFrom(int vertex);
    void addVertex(int vertex);
    void removeVertex(int vertex);
    void removeEdge(int from, int to);

}

