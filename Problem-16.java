/*
You are given an array containing N non-negative integers. Your task is to partition this array into two subsets such that the absolute difference between subset sums is minimum.
You just need to find the minimum absolute difference considering any valid division of the array elements.
*/

public class Solution {
    public static int sum1 = Integer.MAX_VALUE;
    public static int helper(int arr[],int end,int sum,int temp){
        if(end<0)
        return Math.abs((sum-temp)-temp);
        return Math.min(helper(arr,end-1,sum,temp),helper(arr,end-1,sum,temp+arr[end]));
    }
	public static int minSubsetSumDifference(int[] arr, int n) {
		// Write your code here.
        int sum=0,temp=0;
        for(int i=0;i<n;i++){
            sum = sum+arr[i];
        }
         boolean dp[][] = new boolean[n][sum+1];
        for(int i=0;i<n;i++){
            dp[i][0] = true; 
        }
        dp[0][arr[0]] = true;
        for(int i=1;i<n;i++){
            boolean take = false;
            for(int j=1;j<=sum;j++){
                if(j-arr[i]>=0)
                    dp[i][j] = dp[i-1][j]||dp[i-1][j-arr[i]];
                else
                    dp[i][j] = dp[i-1][j]||take;
            }
        }
        //return helper(arr,n-1,sum,temp);
        int min = Integer.MAX_VALUE;
        for(int j=0;j<=sum/2;j++){
            if(dp[n-1][j])
            min = Math.min(min,Math.abs(sum-j)-j);
        }
        return min;
	}

}
