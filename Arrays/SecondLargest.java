/*
Given an array of positive integers arr[], return the second largest element from the array. 
If the second largest element doesn't exist then return -1
Input: arr[] = [12, 35, 1, 10, 34, 1]
Output: 34
*/
package Arrays;
import java.util.Scanner;
public class SecondLargest {
    public static int secondLargest(int[] a){
        int firstLargest=a[0];
        int secondlargest=-1;
        for(int i=1;i<a.length;i++){
            if(a[i]>firstLargest){
                secondlargest=firstLargest;
                firstLargest=a[i];
            }
            else if(a[i]>secondlargest && a[i]<firstLargest){
                secondlargest=a[i];
            }
        }
        return secondlargest;
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
        System.out.println(secondLargest(a));
    }
}