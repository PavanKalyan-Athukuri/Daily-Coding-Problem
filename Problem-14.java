/*
Ninja has a 'GRID' of size 'R' X 'C'. Each cell of the grid contains some chocolates. Ninja has two friends Alice and Bob, and he wants to collect as many chocolates as possible with the help of his friends.
Initially, Alice is in the top-left position i.e. (0, 0), and Bob is in the top-right place i.e. (0, ‘C’ - 1) in the grid. Each of them can move from their current cell to the cells just below them. When anyone passes from any cell, he will pick all chocolates in it, and then the number of chocolates in that cell will become zero. If both stay in the same cell, only one of them will pick the chocolates in it.
If Alice or Bob is at (i, j) then they can move to (i + 1, j), (i + 1, j - 1) or (i + 1, j + 1). They will always stay inside the ‘GRID’.
Your task is to find the maximum number of chocolates Ninja can collect with the help of his friends by following the above rules.
*/

public class Solution {
    public static int helper(int grid[][],int i,int j1,int j2,int dp[][][]){
        if(i<0||j1<0||j2<0||i>grid.length-1||j1>grid[0].length-1||j2>grid[0].length-1)
            return (int)-1e8;
        if(dp[i][j1][j2]!=-1)
            return dp[i][j1][j2];
        if(i==grid.length-1){
            if(j1==j2){
            return grid[i][j1];}
            else
            return grid[i][j1]+grid[i][j2];}
        int maxi = (int)-1e8;
        int value=0;
        for(int d1=-1;d1<2;d1++){
            for(int d2=-1;d2<2;d2++){
                if(j1==j2)
                    value = grid[i][j1];
                else
                    value = grid[i][j1]+grid[i][j2];
                value = value+helper(grid,i+1,j1+d1,j2+d2,dp);
                maxi = Math.max(maxi,value);
            }
        }
        dp[i][j1][j2] = maxi;
        return dp[i][j1][j2];
    }
	public static int maximumChocolates(int r, int c, int[][] grid) {
        int dp[][][] = new int[r][c][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                for(int k=0;k<c;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(grid,0,0,c-1,dp);
	}
}