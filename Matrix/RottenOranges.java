/*
Given a matrix of dimension M * N, where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:  
    0: Empty cell
    1: Cells have fresh oranges
    2: Cells have rotten oranges
Input:  arr[][C] = { {2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
Output: 2
*/
package Matrix;
import java.util.*;
public class RottenOranges {
    public static int rotOranges(int[][] grid){
        int freshcnt=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        Queue<int[]> q=new LinkedList<int[]>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                    visited[i][j]=true;
                }
                if(grid[i][j]==1){
                    freshcnt++;
                }
            }
        }
        int[] rNbr={-1,0,0,1};
        int[] cNbr={0,1,-1,0};
        int tm=0,cnt=0;
        while(!q.isEmpty()){
            int[] pos=q.poll();
            int r=pos[0];
            int c=pos[1];
            int t=pos[2];
            tm=Math.max(t,tm);
            for(int i=0;i<4;i++){
                int newr=r+rNbr[i];
                int newc=c+cNbr[i];
                if(newr>=0 && newr<grid.length && newc>=0 && newc<grid[0].length && !visited[newr][newc] && grid[newr][newc]==1){
                    q.add(new int[]{newr,newc,t+1});
                    cnt++;
                    visited[newr][newc]=true;
                }
            }
        }
        return (cnt==freshcnt)?tm:-1;
    }
	public static void main(String[] args){
        int[][] grid={{2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
        System.out.println("The Minimum time to rot all orages is:"+rotOranges(grid));
    }
}