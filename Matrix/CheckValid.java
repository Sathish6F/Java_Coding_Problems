/*
An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).
Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.
Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
Output: true
Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
Hence, we return true.
*/
package Matrix;
public class CheckValid {
    public static boolean checkRow(int[][] matrix,int row){
        int[] hash=new int[matrix.length+1];
        for(int i=0;i<matrix[0].length;i++){
            hash[matrix[row][i]]++;
        }
        for(int i=1;i<hash.length;i++){
            if(hash[i]==0) return false;
        }
        return true;
    }
    public static boolean checkCol(int[][] matrix,int col){
        int[] hash=new int[matrix.length+1];
        for(int i=0;i<matrix.length;i++){
            hash[matrix[i][col]]++;
        }
        for(int i=1;i<hash.length;i++){
            if(hash[i]==0) return false;
        }
        return true;
    }
    public static boolean checkValid(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            if(!checkRow(matrix,i)) return false;
            if(!checkCol(matrix,i)) return false;
        }
        return true;
    }
	public static void main(String[] args){
        int[][] matrix={{1,2,3},{3,1,2},{2,3,1}};
        System.out.println(checkValid(matrix));
    }
}