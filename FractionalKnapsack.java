package DAA;
import java.util.ArrayList;
import java.util.Scanner;
public class FractionalKnapsack {
    int value, weight;
    double ratio;
    public FractionalKnapsack(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }
    public static double fractionalKnapsack(int capacity, ArrayList<FractionalKnapsack> items) {
        items.sort((a, b) -> Double.compare(b.ratio, a.ratio));
        double maxValue = 0.0; // Total maximum value that can be carried
        for (FractionalKnapsack item : items) {
            if (capacity >= item.weight) {
                capacity -= item.weight;
                maxValue += item.value;
            }
            else {
                maxValue += item.value * ((double) capacity / item.weight);
                break; // Knapsack is full
            }
        }
        return maxValue;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();
        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = sc.nextInt();
        ArrayList<FractionalKnapsack> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter value of item "+ (i+1) +":");
            int value = sc.nextInt();
            System.out.println("Enter weight of item "+ (i+1) +":");
            int weight = sc.nextInt();
            items.add(new FractionalKnapsack(value, weight));
        }
        double maxValue = fractionalKnapsack(capacity, items);
        System.out.println("Maximum value in knapsack = " + maxValue);
        sc.close();
    }
}
