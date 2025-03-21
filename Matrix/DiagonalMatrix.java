package Matrix;
import java.util.*;
public class DiagonalMatrix {
    public static void printDiagonal(int n){
        int[][] mat=new int[n][n];
        int num=1;
        int rowstart=0;
        int colstart=0;
        while(rowstart<n){
            colstart=rowstart;
            rowstart=0;
            while(colstart>=0){
                mat[rowstart++][colstart--]=num++;
            }
        }
        rowstart=1;
        while(rowstart<n){
            int i=rowstart;
            colstart=n-1;
            while(colstart>=0 && i<n){
                mat[i++][colstart--]=num++;
            }
            rowstart++;
        }
        for(int[] row:mat){
            System.out.println(Arrays.toString(row));
        }
    }
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the N value:");
        int n=sc.nextInt();
        printDiagonal(n);
    }
}