/*
You are given a 0-indexed integer array nums of even length consisting of an equal number of 
positive and negative integers. You should return the array of nums such that the 
the array follows the given conditions:
    Every consecutive pair of integers have opposite signs.
    For all integers with the same sign, the order in which they were present in nums is preserved.
    The rearranged array begins with a positive integer.
Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
*/
package Arrays;
import java.util.*;
public class RearrangeArray {
    public static int[] rearrangeArray(int[] a){
        int odd=1,even=0;
        int[] ans=new int[a.length];
        for(int i=0;i<a.length;i++){
            if(a[i]<0){
                ans[odd]=a[i];
                odd+=2;
            }
            else{
                ans[even]=a[i];
                even+=2;
            }
        }
        return ans;
    }
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array size:");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        int[] res=rearrangeArray(a);
        System.out.println(Arrays.toString(res));
    }

}