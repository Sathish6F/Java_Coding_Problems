/*
Given an array of integers arr[] representing non-negative integers, arrange them so that after 
concatenating all of them in order, it results in the largest possible number.
Since the result may be very large, return it as a string.
Input: arr[] = [3, 30, 34, 5, 9]
Output: "9534330"
Explanation: Given numbers are [3, 30, 34, 5, 9], the arrangement "9534330" gives the largest value.
*/
package Arrays;
import java.util.*;
class myComparator implements Comparator<String>{
        public int compare(String s1,String s2){
            return (s2+s1).compareTo(s1+s2);
        }
}
public class FormLargestNumber {
    
    public static String largestNumber(int[] arr){
        String[] a= new String[arr.length];
        for(int i=0;i<a.length;i++){
            a[i]=String.valueOf(arr[i]);
        }
        Arrays.sort(a,new myComparator());
        if(a[0].equals("0")) return "0";
        StringBuilder sb=new StringBuilder();
        for(String s:a){
            sb.append(s);
        }
        return sb.toString();
    }
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array size:");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        System.out.println("The largest number is:"+largestNumber(a));
    }
}