class Solution {
    int MIN;
    public int coinChange(int[] coins, int amount) {
        MIN = amount + 1;
        int[] memo = new int[amount + 1];
        int result = dfs(coins, amount, memo);
        if (result == MIN) {
            return -1;
        }
        return result;
    }

    int dfs(int[] coins, int amount, int[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        }

        int min = MIN;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) {
                continue;
            } else {
                min = Math.min(min, 1 + dfs(coins, amount - coins[i], memo));
            }
            
        }

        memo[amount] = min;

        return min;
    }
}
