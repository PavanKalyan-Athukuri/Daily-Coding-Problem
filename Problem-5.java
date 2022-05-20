/*
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]

Output: 2

Explanation: There is one obstacle in the middle of the 3x3 grid above.

There are two ways to reach the bottom-right corner:

1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       if(obstacleGrid.length==1&&obstacleGrid[0].length==1)
          if(obstacleGrid[0][0]==0)
              return 1;
        else return 0;
        int arr[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[0][0]==0){
            arr[0][0]=1;
        }
        else{
            arr[0][0] = 0;
        }
        for(int i=1;i<arr[0].length;i++){
            if(obstacleGrid[0][i]==0){
                if(arr[0][i-1]==1)
                    arr[0][i] = 1;
                else
                    arr[0][i] = 0;
            }
            else{
                arr[0][i] = 0;
            }
        }
        for(int i=1;i<arr.length;i++){
            if(obstacleGrid[i][0]==0){
                if(arr[i-1][0]==1)
                    arr[i][0] = 1;
                else
                    arr[i][0] = 0;
            }
            else{
                arr[i][0] = 0;
            }
        }
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[0].length;j++){
                if(obstacleGrid[i][j]==1){
                    arr[i][j] = 0;
                }
                else{
                    arr[i][j] = arr[i-1][j]+arr[i][j-1];
                }
            }
        }
        return arr[arr.length-1][arr[0].length-1];
    }
}