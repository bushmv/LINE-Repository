package knapsack;

import java.util.ArrayList;

public class KnapsackBruteForce {

    int maxValue(int weightLimit, ArrayList<Item> items) {

        if (items.size() >= 32) {
            throw new IllegalArgumentException("items count must be less that 32");
        }

        int maxCost = 0;
        ArrayList<Item> result = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, items.size()); i++) {
            String binary = intToBinaryString(i, items.size());
            int localCost = 0;
            int localWeight = 0;

            for (int j = 0; j < binary.toCharArray().length; j++) {
                if (binary.charAt(j) == '1') {
                    localCost += items.get(j).cost;
                    localWeight += items.get(j).weight;
                }
            }

            if (localWeight < weightLimit && localCost > maxCost) {
                maxCost = localCost;
                result = formResult(binary, items);
            }
        }

        result.forEach(System.out::println);
        System.out.println("max cost: " + maxCost);
        return maxCost;

    }

    public String intToBinaryString(int value, int length) {
        String binary = Integer.toBinaryString(value);
        return String.format("%"+ length + "s", binary).replaceAll(" ", "0");
    }

    private ArrayList<Item> formResult(String binary, ArrayList<Item> items) {
        ArrayList<Item> result = new ArrayList<>();
        for (int j = 0; j < binary.toCharArray().length; j++) {
            if (binary.charAt(j) == '1') {
                result.add(items.get(j));
            }
        }
        return result;
    }

}
