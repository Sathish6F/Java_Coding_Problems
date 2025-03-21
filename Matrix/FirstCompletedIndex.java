/*
You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both 
contain all the integers in the range [1, m * n]. Go through each index i in arr starting from 
index 0 and paint the cell in mat containing the integer arr[i].
Return the smallest index i at which either a row or a column will be completely painted in mat.
Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
Output: 2
Explanation: The moves are shown in order, and both the first row and second column of 
the matrix become fully painted at arr[2].
*/
package Matrix;
import java.util.*;
public class FirstCompletedIndex {
    public static int firstCompleted(int[][] matrix,int[] arr){
        int m=matrix[0].length,n=matrix.length;
        int[] rowCnt=new int[n];
        int[] colCnt=new int[m];
        Map<Integer,int[]> numMap= new HashMap<Integer,int[]>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                numMap.put(matrix[i][j],new int[]{i,j});
            }
        }
        for(int i=0;i<n*m;i++){
            int[] idx=numMap.get(arr[i]);
            if(++rowCnt[idx[0]]==n) return i;
            if(++colCnt[idx[i]]==m) return i;
        }
        return -1;
    }
	public static void main(String[] args){
        int[][] matrix={{1,4},{2,3}};
        int[] arr={1,3,4,2};
        System.out.println(firstCompleted(matrix,arr));
    }
}