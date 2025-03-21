/*
Given an array of strings arr[]. Return the longest common prefix among each and every strings 
present in the array. If there's no prefix common in all the strings, return "".
Input: arr[] = ["geeksforgeeks", "geeks", "geek", "geezer"]
Output: "gee"
Explanation: "gee" is the longest common prefix in all the given strings.
*/
package Strings;
import java.util.*;
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] arr){
        Arrays.sort(arr);
        String s1=arr[0];
        String s2=arr[arr.length-1];
        int index=0;
        while(index<s1.length()){
            if(s1.charAt(index)==s2.charAt(index)) index++;
            else break;
        }
        return (index==0)?"":s1.substring(0,index);
    }
	public static void main(String[] args){
        String[] str={"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println("The longest common prefix is:"+longestCommonPrefix(str));
    }
}