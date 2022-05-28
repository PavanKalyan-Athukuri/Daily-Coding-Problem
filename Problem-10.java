/*
You are present at point ‘A’ which is the top-left cell of an M X N matrix, your destination is point ‘B’, which is the bottom-right cell of the same matrix. Your task is to find the total number of unique paths from point ‘A’ to point ‘B’.In other words, you will be given the dimensions of the matrix as integers ‘M’ and ‘N’, your task is to find the total number of unique paths from the cell MATRIX[0][0] to MATRIX['M' - 1]['N' - 1].
To traverse in the matrix, you can either move Right or Down at each step. For example in a given point MATRIX[i] [j], you can move to either MATRIX[i + 1][j] or MATRIX[i][j + 1].
*/


import java.util.* ;
import java.io.*; 
public class Solution {
    public static int helper(int m,int n,int dp[][]){
        if(m==0&&n==0)
            return 1;
        if(m<0||n<0)
            return 0;
        if(dp[m][n]!=-1)
            return dp[m][n];
        dp[m][n] = helper(m-1,n,dp)+helper(m,n-1,dp);
        return dp[m][n];
    }
	public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return helper(m-1,n-1,dp);
	}
}

public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        dp[0][0] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>0)
                dp[i][j] = dp[i][j]+dp[i-1][j];
                if(j>0)
                    dp[i][j] = dp[i][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
	}
}