/*Given an unsorted integer array nums. Return the smallest positive integer 
that is not present in nums.
Input: nums = [1,2,0]
Output: 3
Input: nums = [3,4,-1,1]
Output: 2
*/
package Arrays;
import java.util.Scanner;
public class FirstMissingNumber {
    public static int firstMissingNumber(int[] a){
        int n=a.length;
        for(int i=0;i<n;i++){
            while(a[i]>0 && a[i]<=n && a[a[i]-1]!=a[i]){
                swap(a,i,a[i]-1);
            }
        }
        for(int i=0;i<n;i++){
            if(a[i]!=i+1) return i+1;
        }
        return n+1;
    }
    public static void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
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
        System.out.println(firstMissingNumber(a));
    }
}