import java.util.Arrays;
import java.util.Scanner;

public class QuestionOne {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter The size of arr: ");
        int size = s.nextInt();
        int[] coins = new int[size];
        for (int i = 0; i < coins.length; i++) {
            System.out.print("Enter value of coin " + (i + 1) + " :");
            int temp = s.nextInt();
            coins[i] = temp;
        }
        System.out.print("Enter the amount to be changed: ");
        int amount = s.nextInt();

        Arrays.sort(coins);

        int greedy = greedyChange(coins, amount);
        System.out.println("Min coins for greedy: " + greedy);


        int flow = dpChange(coins,amount);
        System.out.println("Min coins for Dp: " + flow);
    }


    public static int greedyChange(int[] coins, int amount) {
        int count = 0;
        int i = coins.length - 1;
        while (amount > 0) {
            if (coins[i] <= amount) {
                amount -= coins[i];
                count++;
            } else i--;
        }
        return count;
    }

    public static int dpChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int i = 1;
        while (i <= amount) {
            for (int coin : coins){
                int temp = i - coin;
                if (temp >= 0 && dp[temp] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[temp] + 1);
                }
            }
            i++;
        }

        return dp[amount] == Integer.MIN_VALUE ? -1 : dp[amount];
    }
}
