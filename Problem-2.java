/* You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.*/

import java.util.Queue;
import java.util.ArrayList;
class Pair{
    int x,y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int low = 0;
        int high = 1000000;
        int mid = (high+low)/2;
        int ans = 0;;
        while(low<=high){
            mid = (high+low)/2;
            boolean val = Solution.bfs(heights,mid);
            if(val==true){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static boolean valid(int x,int y,int heights[][]){
        if(x<=heights.length-1&&x>=0&&y>=0&&y<heights[0].length)
            return true;
        return false;
    }
    public static boolean bfs(int heights[][],int k){
        int dy[] = {1,-1,0,0};
        int dx[] = {0,0,1,-1};
        int cx = 0,cy=0;
        Pair p = new Pair(cx,cy);
        boolean visited[][] = new boolean[heights.length][heights[0].length];
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                visited[i][j] = false;
            }
        }
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(p);
        visited[cx][cy] = true;
        while(!queue.isEmpty()){
            Pair temp = queue.remove();
             cx = temp.x;
             cy = temp.y;
            if(cx==heights.length-1&&cy==heights[0].length-1)
                return true;
            for(int i=0;i<4;i++){
                int x = cx+dx[i];
                int y = cy+dy[i];
                if(Solution.valid(x,y,heights)){
               int diff = Math.abs(heights[cx][cy]-heights[x][y]);
                if(diff<=k&&!visited[x][y])
                {
                    Pair p1 = new Pair(x,y);
                    queue.add(p1);
                    visited[x][y] = true;
                }
            }
            }
        }
        return false;
    }
}