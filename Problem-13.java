/*
You have been given an N*M matrix filled with integer numbers, find the maximum sum that can be obtained from a path starting from any cell in the first row to any cell in the last row.
From a cell in a row, you can move to another cell directly below that row, or diagonally below left or right. So from a particular cell (row, col), we can move in three directions i.e.
Down: (row+1,col)
Down left diagonal: (row+1,col-1)
Down right diagonal: (row+1, col+1)
Input Format :
The first line contains an integer 'T', which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case contains two Integers 'N' and 'M' where 'N' denotes the number of rows in the given matrix. And 'M' denotes the number of columns in the given matrix.

The next 'N' line of each test case contains 'M' space-separated integers denoting the cell elements.
*/



public class Solution {
    public static int helper(int matrix[][],int i,int j,int dp[][]){
        if(i<0||j<0||i>matrix.length-1||j>matrix[0].length-1)
            return (int)(-1e8);
        if(i==0)
            return matrix[0][j];
        if(dp[i][j]!=-1)
            return dp[i][j];
        int up = matrix[i][j]+helper(matrix,i-1,j,dp);
        int diagonal1 = matrix[i][j]+helper(matrix,i-1,j-1,dp);
        int diagonal2 = matrix[i][j]+helper(matrix,i-1,j+1,dp);
        dp[i][j] = Math.max(up,Math.max(diagonal1,diagonal2));
        return dp[i][j];
    }
	public static int getMaxPathSum(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int dp[][] = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                dp[i][j] = -1;
            }
        }
        for(int i=0;i<matrix[0].length;i++){
        int temp = helper(matrix,matrix.length-1,matrix[0].length-1-i,dp);
          max = Math.max(temp,max);}
        return max;
	}
}

