/*
Given a non-empty array of integers nums, every element appears twice except for one. 
Find that single one. You must implement a solution with a linear runtime complexity and 
use only constant extra space.
Input: nums = [2,2,1]
Output: 1
Input: nums = [4,1,2,1,2]
Output: 4
*/
package Arrays;
import java.util.Scanner;
public class SingleNumber {
    public static int singleNumber(int[] a){
        int xor=0;
        for(int i=0;i<a.length;i++){
            xor=xor^a[i];
        }
        return xor;
    }
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array size:");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        System.out.println("Single occurence number:"+singleNumber(a));
    }
}