/*
You are given a triangular array/list 'TRIANGLE'. Your task is to return the minimum path sum to reach from the top to the bottom row.
The triangle array will have N rows and the i-th row, where 0 <= i < N will have i + 1 elements.
You can move only to the adjacent number of row below each step. For example, if you are at index j in row i, then you can move to i or i + 1 index in row j + 1 in each step.
For Example :
If the array given is 'TRIANGLE' = [[1], [2,3], [3,6,7], [8,9,6,1]] the triangle array will look like:

1
2,3
3,6,7
8,9,6,10

For the given triangle array the minimum sum path would be 1->2->3->8. Hence the answer would be 14.
*/

import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        List<List<Integer>>dp = new ArrayList<>();
        for(int i=0;i<n;i++){
            dp.add(new ArrayList<Integer>());
        }
        List<Integer> last = new ArrayList<>();
        for(int i=0;i<triangle[n-1].length;i++){
            last.add(triangle[n-1][i]);
        }
        dp.add(n-1,last);
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<triangle[i].length;j++){
                dp.get(i).add(Math.min(triangle[i][j]+dp.get(i+1).get(j),triangle[i][j]+dp.get(i+1).get(j+1)));
            }
        }
        return dp.get(0).get(0);
    }
}