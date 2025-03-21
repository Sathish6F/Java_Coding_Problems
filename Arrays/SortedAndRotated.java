/*
Given an array nums, return true if the array was originally sorted in non-decreasing order, 
then rotated some number of positions (including zero). Otherwise, return false.
Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
*/
package Arrays;
import java.util.Scanner;
public class SortedAndRotated {
    public static boolean check(int[] a){
        int cnt=0;
        while(cnt<a.length){
            rotate(a);
            if(sorted(a)) return true;
            cnt++;
        }
        return false;
    }
    public static void rotate(int[] a){
        int t=a[a.length-1];
        for(int i=a.length-1;i>0;i--)
            a[i]=a[i-1];
        a[0]=t;
    }
    public static boolean sorted(int[] a){
        for(int i=0;i<a.length-1;i++)
            if(a[i]>a[i+1]) return false;
        return true;
    }
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array size:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(check(arr));
    }
}