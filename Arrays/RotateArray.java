/*
Given an integer array nums, rotate the array to the right by k steps,where k is non-negative.
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
*/
package Arrays;
import java.util.Scanner;
public class RotateArray {
    public static int[] rotateArray(int[] a,int k){
        if(k==0) return a;
        int t=a[a.length-1];
        for(int i=a.length-1;i>0;i--){
            a[i]=a[i-1];
        }
        a[0]=t;
        return rotateArray(a,--k);
    }
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array size:");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        System.out.println("Enter the rotation count:");
        int k=sc.nextInt();
        if(k>a.length) k=k%a.length;
        a=rotateArray(a,k);
        System.out.println("After rotation:");
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
}