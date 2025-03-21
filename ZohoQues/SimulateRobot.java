package ZohoQues;
/*
A robot on an infinite XY-plane starts at point (0, 0) facing north. The robot receives an array of integers commands, which represents a sequence of moves that it needs to execute. There are only three possible types of instructions the robot can receive:
    -2: Turn left 90 degrees.
    -1: Turn right 90 degrees.
    1 <= k <= 9: Move forward k units, one unit at a time.
Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi). If the robot runs into an obstacle, it will stay in its current location (on the block adjacent to the obstacle) and move onto the next command.
Return the maximum squared Euclidean distance that the robot reaches at any point in its path (i.e. if the distance is 5, return 25).
Note:
    There can be an obstacle at (0, 0). If this happens, the robot will ignore the obstacle until it has moved off the origin. However, it will be unable to return to (0, 0) due to the obstacle.
    North means +Y direction.
    East means +X direction.
    South means -Y direction.
    West means -X direction.
Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
Output: 65
*/
import java.util.*;
class Point{
    int r,c;
    Point(int r,int c){
        this.r = r;
        this.c = c;
    }
}
public class SimulateRobot {

    public static int simulateRobot(int[] commands,int[][] obstacles){
        int res = 0;
        int x =0,y=0;
        HashSet<Point> set = new HashSet<>();
        for(int[] a:obstacles){
           set.add(new Point(a[0],a[1])); 
        }
        int[][] direction ={{0,1},{1,0},{0,-1},{-1,0}};
        int d = 0;
        for(int c:commands){
            if(c==-1){
                d= (d+1)%4;
            }
            else if(c==-2){
                d=(d-1)%4;
            }else{
                int[] di = direction[d];
            Point p1 = new Point(di[0]+x,di[1]+y);
            for(int i =0;i<c;i++){
                if(set.contains(p1)){
                    break;
                }
                x+=di[0];
                y+=di[1];
            }
            }
            int t =(x*x)+(y*y);
            res =Math.max(res,(t));
        }
        return res;
    }
	public static void main(String[] args){
        int[] commands = {4,-1,4,-1,4};
        int[][] obstacles ={{2,4}};
        System.out.println(simulateRobot(commands,obstacles));
    }
}