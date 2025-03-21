/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), 
return the number of islands. An island is surrounded by water and is formed by connecting 
adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","1"]
]
Output: 2
*/
package Matrix;
import java.util.*;
public class NumberOfIslands {
    public static boolean isSafe(char[][] grid,boolean[][] visited,int row,int col){
        return row>=0 && row<grid.length && col>=0 && col<grid[0].length && (grid[row][col]=='1' && !visited[row][col]);
    }
    public static void bfs(char[][] grid,boolean[][] visited,int row,int col){
        int[] rNbr={-1,-1,-1,0,0,1,1,1};
        int[] cNbr={-1,0,1,-1,1,-1,0,1};
        Queue<int[]> q=new LinkedList<int[]>();
        q.add(new int[]{row,col});
        visited[row][col]=true;
        while(!q.isEmpty()){
            int[] pos=q.poll();
            int r=pos[0];
            int c=pos[1];
            for(int i=0;i<8;i++){
                int newr=r+rNbr[i];
                int newc=c+cNbr[i];
                if(isSafe(grid,visited,newr,newc)){
                    q.add(new int[]{newr,newc});
                    visited[newr][newc]=true;
                }
            }
        }
    }
    public static int noOfIslands(char[][] grid){
        int res=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    bfs(grid,visited,i,j);
                    res++;
                }
            }
        }
        return res;
    }
	public static void main(String[] args){
        char[][] grid={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','1'}};
        System.out.println("No.of Isalnads:"+noOfIslands(grid));
    }
}