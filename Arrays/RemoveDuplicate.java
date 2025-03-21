/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place 
such that each unique element appears only once.The relative order The relative order
should be kept the same.Then return the number of unique elements in nums.
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
*/
package Arrays;
import java.util.Scanner;
public class RemoveDuplicate {
    public static int removeDuplicate(int[] a){
        int i=0;
        for(int j=1;j<a.length;j++){
            if(a[i]!=a[j]) a[++i]=a[j];
        }
        return i+1;
    }
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array size:");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("Enter the array elements");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int k=removeDuplicate(a);
        System.out.println("After removing duplicates");
        for(int i=0;i<k;i++){
            System.out.print(a[i]+" ");
        }
    }
}