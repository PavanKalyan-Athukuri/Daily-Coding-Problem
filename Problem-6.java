/*
You are given an array of binary strings strs and two integers m and n.

Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

A set x is a subset of a set y if all elements of x are also elements of y.

 

Example 1:

Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
Output: 4
Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
{"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
*/

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int arr[][] = new int[m+1][n+1];
        for(String str:strs){
            int count[] = count(str);
        for(int i=m;i>=count[0];i--){
            for(int j=n;j>=count[1];j--){
                arr[i][j] = Math.max(arr[i][j],arr[i-count[0]][j-count[1]]+1);
            }
        }
        }
        return arr[m][n];
    }
    int[] count(String str){
        int count[] = new int[2];
        for(int i=0;i<str.length();i++){
            count[str.charAt(i)-'0']++;
        }
        return count;
    }
}