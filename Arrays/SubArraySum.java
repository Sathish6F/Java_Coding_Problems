/*
Given an array of integers nums and an integer k, return the total number of subarrays 
whose sum equals to k. A subarray is a contiguous non-empty sequence of elements within an array.
Input: nums = [1,1,1], k = 2
Output: 2
Input: nums = [1,2,3], k = 3
Output: 2
*/
package Arrays;
import java.util.Scanner;
public class SubArraySum {
    public static int subArraySum(int[] a,int k){
        int cnt=0;
        for(int i=0;i<a.length;i++){
            int sum=0;
            for(int j=i;j<a.length;j++){
                sum+=a[j];
                if(sum==k) cnt++;
            }
        }
        return cnt;
    }
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array size:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter K value:");
        int k=sc.nextInt();
        System.out.println("Subarray counts:"+subArraySum(arr,k));
    }
}