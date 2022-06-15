/*
You are given an array (0-based indexing) of positive integers and you have to tell how many different ways of selecting the elements from the array are there such that the sum of chosen elements is equal to the target number “tar”.
*/

public class Solution {
    public static int helper(int num[],int end,int tar){
        if(tar==0)
            return 1;
        if(end<0)
            return 0;
        return helper(num,end-1,tar-num[end])+helper(num,end-1,tar);
    }
    public static int findWays(int num[], int tar) {
        // Write your code here..
      //  return helper(num,num.length-1,tar);
        int dp[][] = new int[num.length][tar+1];
        for(int i=0;i<num.length;i++){
            dp[i][0] = 1;
        }
        if(num[0]<=tar)
        dp[0][num[0]] = 1;
        for(int i=1;i<num.length;i++){
            for(int j=1;j<=tar;j++){
                if(j-num[i]>=0)
                dp[i][j] = dp[i-1][j]+dp[i-1][j-num[i]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[num.length-1][tar];
    }
}