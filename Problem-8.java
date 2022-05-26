/*
There is a frog on the 1st step of an N stairs long staircase. The frog wants to reach the Nth stair. HEIGHT[i] is the height of the (i+1)th stair.If Frog jumps from ith to jth stair, the energy lost in the jump is given by |HEIGHT[i-1] - HEIGHT[j-1] |.In the Frog is on ith staircase, he can jump either to (i+1)th stair or to (i+2)th stair. Your task is to find the minimum total energy used by the frog to reach from 1st stair to Nth stair.

For Example

If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20.
*/

public class Solution {
    public static int helper(int n,int heights[]){
        if(n==0)
            return 0;
        int one = Math.abs(heights[n]-heights[n-1])+helper(n-1,heights);
        int two = Integer.MAX_VALUE;
        if(n>1)
        two = Math.abs(heights[n]-heights[n-2])+helper(n-2,heights);
        return Math.min(one,two);
    }
    public static int frogJump(int n, int heights[]) {
        return helper(n-1,heights);
    }

}


public class Solution {
    public static int helper(int n,int heights[],int dp[]){
        if(n==0)
            return 0;
        if(dp[n]!=-1){
            return dp[n];
        }
        int one = Math.abs(heights[n]-heights[n-1])+helper(n-1,heights,dp);
        int two = Integer.MAX_VALUE;
        if(n>1)
        two = Math.abs(heights[n]-heights[n-2])+helper(n-2,heights,dp);
        dp[n] =  Math.min(one,two);
        return dp[n];
    }
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int dp[] = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        return helper(n-1,heights,dp);
    }

}