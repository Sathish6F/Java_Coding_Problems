/*
Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
Input: arr[] = [0, 1, 2, 0, 1, 2]
Output: [0, 0, 1, 1, 2, 2]
*/
package Arrays;
import java.util.*;
public class Move012 {
    public static void move012(int[] arr){
        int zCnt=0,oCnt=0;
        for(int n:arr){
            if(n==0) zCnt++;
            if(n==1) oCnt++;
        }
        for(int i=0;i<zCnt;i++) arr[i]=0;
        for(int i=zCnt;i<zCnt+oCnt;i++) arr[i]=1;
        for(int i=zCnt+oCnt;i<arr.length;i++) arr[i]=2;
    }
	public static void main(String[] args){
        int[] arr={0, 1, 2, 0, 1, 2};
        move012(arr);
        System.out.println(Arrays.toString(arr));
    }
}