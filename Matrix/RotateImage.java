/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
DO NOT allocate another 2D matrix and do the rotation.
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
*/
package Matrix;
import java.util.*;
public class RotateImage {
    public static void rotateImage(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                int t=a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=t;
            }
        }
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length/2;j++){
                int t=a[i][j];
                a[i][j]=a[i][a.length-1-j];
                a[i][a.length-1-j]=t;
            }
        }
    }
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the matrix size:");
        int n=sc.nextInt();
        int[][] matrix=new int[n][n];
        System.out.println("Enter elements:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        rotateImage(matrix);
        System.out.println("After 90deg rotation:");
        for(int[] a:matrix){
            System.out.println(Arrays.toString(a));
        }
    }
}