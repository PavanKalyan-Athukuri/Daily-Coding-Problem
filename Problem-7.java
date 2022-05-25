/*You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

*/

//Recursive Approach

class Solution {
    public int helper(int nums[],int target,int i,int sum){
        if(target==sum&&i==nums.length)
            return 1;
        if(i>nums.length-1&&sum!=target)
            return 0;
        return helper(nums,target,i+1,sum+nums[i])+helper(nums,target,i+1,sum-nums[i]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,target,0,0);
    }
}

//Optimized dynamic programming Approach


