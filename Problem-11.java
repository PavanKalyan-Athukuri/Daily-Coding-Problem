/*
Ninjaland is a country in the shape of a 2-Dimensional grid 'GRID', with 'N' rows and 'M' columns. Each point in the grid has some cost associated with it.
Find a path from top left i.e. (0, 0) to the bottom right i.e. ('N' - 1, 'M' - 1) which minimizes the sum of the cost of all the numbers along the path. You need to tell the minimum sum of that path.
Note:
You can only move down or right at any point in time.

2 3
5 9 6
11 5 2

21

*/

public class Solution {
    public static int helper(int grid[][],int i,int j){
        //int up=0,left=0;
        if(i==0&&j==0)
            return grid[i][j];
        if(i<0||j<0)
            return (int)1e6;
       // if(j>0)
         int left = grid[i][j]+helper(grid,i,j-1);
        //if(i>0)
          int up = grid[i][j]+helper(grid,i-1,j);
       return Math.min(left,up);
    }
    public static int minSumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0){
                    dp[i][j] = grid[i][j];
                }
                else{
                int down=grid[i][j];
                if(i>0)
                    down = down+dp[i-1][j];
                else down = down+(int)1e8;
                int right = grid[i][j];
                if(j>0)
                    right = right+dp[i][j-1];
                else right=right+(int)1e8;
                dp[i][j] = Math.min(down,right);
            }
            }
        }
        return dp[m-1][n-1];
    }
}