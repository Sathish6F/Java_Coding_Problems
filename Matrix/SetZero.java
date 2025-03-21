/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
*/
package Matrix;
import java.util.Scanner;
import java.util.Arrays;
public class SetZero {
    public static void setZero(int[][] a){
        boolean[] row=new boolean[a.length];
        boolean[] col=new boolean[a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                if(a[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for(int i=0;i<row.length;i++){
            if(row[i]){
                for(int j=0;j<a[0].length;j++){
                    a[i][j]=0;
                }
            }
        }
        for(int i=0;i<col.length;i++){
            if(col[i]){
                for(int j=0;j<a.length;j++){
                    a[j][i]=0;
                }
            }
        }
    }
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter row size:");
        int row=sc.nextInt();
        System.out.println("Enter column size:");
        int col=sc.nextInt();
        int[][] matrix=new int[row][col];
        System.out.println("Enter Matrix elements:");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        setZero(matrix);
        for(int[] a:matrix){
            System.out.println(Arrays.toString(a));
        }
    }
}