/*
You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.
Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.
*/

public class Solution {
    public static int helper(int end,int target,int arr[],int dp[][]){
        if(target==0)
            return 1;
        if(end<0||target<0)
            return 0;
        if(arr[end]>target)
            return helper(end-1,target,arr,dp);
        if(dp[end][target]!=-1)
            return dp[end][target];
            if(helper(end-1,target,arr,dp)!=0||helper(end-1,target-arr[end],arr,dp)!=0)
                dp[end][target] = 1;
            else
                dp[end][target] = 0;
        return dp[end][target];
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        int dp[][] = new int[n][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                dp[i][j] = -1;
            }
        }
        int result = helper(n-1,k,arr,dp);
        if(result==0)
            return false;
        return true;
    }
}
