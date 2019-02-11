import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.Math.abs;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        ArrayList<Integer> stockValues = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            stockValues.add(in.nextInt());
        }

        int lowestMaximalLoss = 0;

        for (int i = 0; i < stockValues.size(); i++) {
            for (int j = i + 1; j < stockValues.size(); j++) {
                if (stockValues.get(i) > stockValues.get(j)) {
                    int currentMaximalLost = -1 * abs(stockValues.get(i) - stockValues.get(j));
                    if (lowestMaximalLoss > currentMaximalLost) {
                        lowestMaximalLoss = currentMaximalLost;
                    }
                }
            }

        }
        System.out.println(lowestMaximalLoss);
    }
}