package knapsack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class GreedyKnapsack {

    private static class UnitCostItem {

        private final Item item;
        private final double costPerUnitWeight;

        private UnitCostItem(Item item) {
            this.item = item;
            costPerUnitWeight = item.cost * 1.0 / item.weight;
        }

        @Override
        public String toString() {
            return "UnitCostItem{" +
                    "item=" + item +
                    ", costPerUnitWeight=" + costPerUnitWeight +
                    '}';
        }
    }

    public int maxValue(int weightLimit, ArrayList<Item> items) {

        ArrayList<UnitCostItem> unitCostItems = new ArrayList<>(items.size());
        items.forEach(it -> unitCostItems.add(new UnitCostItem(it)));
        unitCostItems.sort(Comparator.comparingDouble(o -> o.costPerUnitWeight));

        ArrayList<Item> result = formResult(weightLimit, unitCostItems);

        result.forEach(System.out::println);
        return sum(result);
    }

    private int sum(ArrayList<Item> list) {
        int sum = 0;
        for (Item item : list) {
            sum += item.cost;
        }
        return sum;
    }

    private ArrayList<Item> formResult(int weightLimit, ArrayList<UnitCostItem> list) {
        int limit = weightLimit;
        ArrayList<Item> result = new ArrayList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            limit -= list.get(i).item.weight;
            if (limit < 0) {
                break;
            }
            result.add(list.get(i).item);
        }
        return result;
    }

}
