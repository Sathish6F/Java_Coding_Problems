/*
Given an MxN matrix where each element can either be 0 or 1. 
We need to find the shortest path between a given source cell to a destination cell. 
The path can only be created out of a cell if its value is 1.
Input:
N=3, M=4
A=[[1,0,0,0], 
   [1,1,0,1],
   [0,1,1,1]]
X=2, Y=3 
Output:
5
Explanation:
The shortest path is as follows:
(0,0)->(1,0)->(1,1)->(2,1)->(2,2)->(2,3).
*/
package Matrix;
import java.util.*;
public class ShortestPath {
    static class Point{
        int x,y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static class QueueNode{
        Point pt;
        int dis;
        QueueNode(Point pt,int dis){
            this.pt=pt;
            this.dis=dis;
        }
    }
    public static boolean isValid(int[][] grid,int r,int c){
        return (r>=0 && r<grid.length && c>=0 && c<grid[0].length);
    }
    public static int shortestPath(int[][] grid,Point src,Point des){
        if(grid[src.x][src.y]!=1 || grid[des.x][des.y]!=1){
            return -1;
        }
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int[] rNbr={-1,0,0,1};
        int[] cNbr={0,-1,1,0};
        Queue<QueueNode> q=new LinkedList<QueueNode>();
        QueueNode s=new QueueNode(src, 0);
        q.add(s);
        while(!q.isEmpty()){
            QueueNode curr=q.peek();
            Point pt=curr.pt;
            if(pt.x==des.x && pt.y==des.y){
                return curr.dis;
            }
            q.remove();
            for(int i=0;i<4;i++){
                int newr=pt.x+rNbr[i];
                int newc=pt.y+cNbr[i];
                if(isValid(grid,newr,newc) && !visited[newr][newc] && grid[newr][newc]==1){
                    visited[newr][newc]=true;
                    QueueNode adj=new QueueNode(new Point(newr,newc),curr.dis+1);
                    q.add(adj);
                }
            }
        }
        return -1;
    }
	public static void main(String[] args){
        int[][] mat={{1,0,0,0}, {1,1,0,1},{0,1,1,1}};
        Point src=new Point(0,0);
        Point des=new Point(2,3);
        System.out.println("The shortest path is:"+shortestPath(mat,src,des));

    }
}