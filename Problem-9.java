/*
Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn?
You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. Your task is to calculate the maximum number of merit points that Ninja can earn.

For Example

If the given ‘POINTS’ array is [[1,2,5], [3 ,1 ,1] ,[3,3,3] ],the answer will be 11 as 5 + 3 + 3.
*/

public class Solution {
    public static int helper(int day,int last,int points[][],int dp[][]){
        if(day==0){
            int maxi = Integer.MIN_VALUE;
            for(int i=0;i<3;i++){
                if(i!=last){
                    maxi = Math.max(maxi,points[day][i]);
                }
            }
           return maxi;
        }
        if(dp[day][last]!=-1)
            return dp[day][last];
            int maxi = Integer.MIN_VALUE;
            for(int i=0;i<3;i++){
                if(i!=last){
                    int point = points[day][i]+helper(day-1,i,points,dp);
                    maxi = Math.max(point,maxi);
                }
            }
            dp[day][last] = maxi;
        return dp[day][last];
    }
    public static int ninjaTraining(int n, int points[][]) {
        int dp[][] = new int[n][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++)
            {
                dp[i][j] = -1;
            }
        }
        return helper(n-1,3,points,dp);
    }

}