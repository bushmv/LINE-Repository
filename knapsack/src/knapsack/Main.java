package knapsack;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(2, 9));
        items.add(new Item(2, 8));
        items.add(new Item(3, 15));
        items.add(new Item(2, 10));
        items.add(new Item(6, 23));
        items.add(new Item(2, 8));

        KnapsackBruteForce knapsack = new KnapsackBruteForce();
        knapsack.maxValue(10, items);

        GreedyKnapsack greedyKnapsack = new GreedyKnapsack();
        greedyKnapsack.maxValue(10, items);

        DynamicKnapsack dynamicKnapsack = new DynamicKnapsack();
        dynamicKnapsack.maxValue(10, items);

    }


}
