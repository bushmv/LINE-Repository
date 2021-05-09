package weighted;

public class MatrixGraph implements WeightedGraph {

    private final int[][] matrix;

    public MatrixGraph(int[][] matrix) {
        this.matrix = matrix;
    }

    public MatrixGraph(int vertices) {
        matrix = new int[vertices + 1][vertices + 1];
    }


    @Override
    public void dump() {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void print() {
        for (int i = 1; i < matrix.length; i++) {
            System.out.print("vertex " + i + " has edges: ");
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) System.out.print(j + " with weight: " + matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

    @Override
    public void reachableVerticesFrom(int vertex) {
        for (int i = 1; i < matrix[vertex].length; i++) {
            if (matrix[vertex][i] > 0) System.out.print(i + " ");
        }
        System.out.println();
    }

    @Override
    public void addVertex(int vertex) {
        throw new UnsupportedOperationException("Sorry, the operation of adding a new vertex doesn't support.");
    }

    @Override
    public void removeVertex(int vertex) {
        for (int i = 1; i < matrix[vertex].length; i++) {
            matrix[vertex][i] = 0;
        }
    }

    @Override
    public void addEdge(int from, int to, int weight) {
        matrix[from][to] = weight;
    }

    @Override
    public void removeEdge(int from, int to) {
        matrix[from][to] = 0;
    }

}
