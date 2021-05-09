package weighted;

import main.BaseGraph;

public interface WeightedGraph extends BaseGraph {

    void addEdge(int from, int to, int weight);
}
