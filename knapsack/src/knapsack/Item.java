package knapsack;

public class Item {

    public final int weight;
    public final int cost;

    public Item(int weight, int cost) {
        this.weight = weight;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return
                "{weight=" + weight +
                ", cost=" + cost +
                '}';
    }
}
