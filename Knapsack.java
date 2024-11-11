package DAA;
import java.util.*;
public class Knapsack {
   public static int findMax(int n1, int n2) {
      if (n1 > n2) {
         return n1;
      } else {
         return n2;
      }
   }
   public static int knapsack(int W, int wt[], int val[], int n) {
      int K[][] = new int[n + 1][W + 1];
      for (int i = 0; i <= n; i++) {
         for (int w = 0; w <= W; w++) {
            if (i == 0 || w == 0) {
               K[i][w] = 0;
            } else if (wt[i - 1] <= w) {
               K[i][w] = findMax(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
            } else {
               K[i][w] = K[i - 1][w];
            }
         }
      }
      return K[n][W];
   }
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter the number of items: ");
      int len = scanner.nextInt();
      int[] val = new int[len];
      int[] wt = new int[len];
      System.out.println("Enter the values of the items:");
      for (int i = 0; i < len; i++) {
         val[i] = scanner.nextInt();
      }
      System.out.println("Enter the weights of the items:");
      for (int i = 0; i < len; i++) {
         wt[i] = scanner.nextInt();
      }
      System.out.print("Enter the maximum capacity of the knapsack: ");
      int W = scanner.nextInt();
      System.out.print("Maximum Profit achieved with this knapsack: " + knapsack(W, wt, val, len));
      scanner.close();;
   }
}