package knapsack;

import java.util.ArrayList;
import java.util.Arrays;

public class DynamicKnapsack {

    int maxValue(int weightLimit, ArrayList<Item> items) {

        int[][] values = new int[items.size() + 1][weightLimit + 1];
        calculateValuesForItems(values, items);

        print(values);

        return values[items.size()][weightLimit];
    }

    private void print(int[][] values) {
        System.out.print("\t\t");
        for (int i = 0; i < values[0].length; i++) {
            System.out.print(i + "\t");
        }
        int k = 0;
        System.out.println();
        for (int[] maxCost : values) {
            System.out.print("item " + k++ + "\t");
            for (int i : maxCost) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    private void calculateValuesForItems(int[][] values, ArrayList<Item> items) {
        Arrays.fill(values[0], 0);
        for (int i = 1; i < values.length; i++) {
            Item item = items.get(i - 1);
            for (int j = 0; j < values[i].length; j++) {
                if (j - item.weight >= 0) {
                    values[i][j] = Math.max(item.cost + values[i - 1][j - item.weight], values[i - 1][j]);
                } else {
                    values[i][j] = values[i - 1][j];
                }
            }
        }
    }


}
