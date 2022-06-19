/******************************************************************************

A thief is robbing a store and can carry a maximal weight of W into his knapsack. 
There are N items and the ith item weighs wi and is of value vi. 
Considering the constraints of the maximum weight that a knapsack can carry, you have to find and return the maximum value that a thief can generate by stealing items.

*******************************************************************************/

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int dp[][] = new int[n][maxWeight+1];
        for(int i=weight[0];i<=maxWeight;i++){
            dp[0][i] = value[0];
        }
        for(int i=1;i<n;i++){
            int take = -1;
                for(int j=0;j<=maxWeight;j++){
                      if(j>=weight[i]){
                    take = value[i]+dp[i-1][j-weight[i]];
                }
                    int notake = dp[i-1][j];
                    dp[i][j] = Math.max(take,notake);
            }
        }
        return dp[n-1][maxWeight];
    }
}